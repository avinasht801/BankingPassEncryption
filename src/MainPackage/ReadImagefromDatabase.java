package MainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.Blob;


/**
 * Servlet implementation class ReadImagefromDatabase
 */
@WebServlet("/ReadImagefromDatabase")
public class ReadImagefromDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1;
	 JsonObject jsonObject;
	 Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadImagefromDatabase() {
        super();
        jsonObject=new JsonObject();
        db1 = new DatabaseConnection();
		con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subcategory=(String) request.getParameter("id");
		String idobt[]=subcategory.split(" ");
		String source="";//(String) request.getParameter("source");
//		String queryFOrCheckingTicket="select * from qrcodereader where id=(select max(id) from qrcodereader where username=? and valid=?)";
		//String qrDecode=DES.decrypt(source);
		 PreparedStatement psmt1;
		  String sql="select * from product where id="+idobt[0]+"";
		  ServletOutputStream out = response.getOutputStream();
					try {
						psmt1 = con.prepareStatement(sql);
						
				     
				        Blob image = null;
		              ResultSet rs = psmt1.executeQuery();
		                if(rs.next()){
		                	 image = (Blob) rs.getBlob("imagefile");
//		                	source=rs.getString("contentsinqrcode");
//		                	 File image = new File("D:\\java.gif");
//		                     FileOutputStream fos = new FileOutputStream(image);
		                	//String decyptData=DES.decrypt(source);
//		                	String fileName = "f"+".png";
//		        	        if(fileName == null || fileName.equals("")){
//		        	            throw new ServletException("File Name can't be null or empty");
//		        	        }
//		        	        File file = new File(fileName);
//		        	        if(!file.exists()){
//		        	            throw new ServletException("File doesn't exists on server.");
//		        	        }
//		        	        System.out.println("File location on server::"+file.getAbsolutePath());
//		        	        ServletContext ctx = getServletContext();
//		        	        InputStream fis = new FileInputStream(file);
//		        	        String mimeType = ctx.getMimeType(file.getAbsolutePath());
//		        	        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
//		        	        response.setContentLength((int) file.length());
//		        	        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//		        	         
//		        	        ServletOutputStream os       = response.getOutputStream();
//		        	        byte[] bufferData = new byte[1024];
//		        	        int read=0;
//		        	        while((read = fis.read(bufferData))!= -1){
//		        	            os.write(bufferData, 0, read);
//		        	        }
//		        	        os.flush();
//		        	        os.close();
//		        	        fis.close();
		                	 
		                	 response.setContentType("image/gif");
		                	 InputStream in = image.getBinaryStream();
		                	  int length = (int) image.length();
		                	  int bufferSize = 1024;
		                	  byte[] buffer = new byte[bufferSize];
		                	  while ((length = in.read(buffer)) != -1) {
		                	  out.write(buffer, 0, length);
		                	  }
		                	  in.close();
		                	  out.flush();
		                	 
		        	        System.out.println("File downloaded at client successfully");
		                }
		                else
		                {
//		                	setmessage("invalid");
		                	 response.setContentType("application/json");
     						  response.getWriter().print(jsonObject);
		                }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
	
	}

}
