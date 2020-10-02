package MainPackage;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class GetDataOflostChildrenDistributor
 */
@WebServlet("/GetDataOflostChildrenDistributor")
public class GetDataOflostChildrenDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String pathofdataset="D://lostprojectdatset//";
    DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
	 String uploadFilePath;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataOflostChildrenDistributor() {
        super();
        con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String	 applicationPath = request.getSession().getServletContext().getRealPath("dataset");
//		HttpSession session = request.getSession();
//		String username=(String)session.getAttribute("user");
	        // constructs path of the directory to save uploaded file
	         uploadFilePath = applicationPath + File.separator ;
	     System.out.println("upload "+uploadFilePath);
		
	     pathofdataset=applicationPath+"//";
	  
		String imageDataString=request.getParameter("TreeImages");
		String lati=request.getParameter("lati");
		String longi=request.getParameter("longi");
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		String mobilenum=request.getParameter("mobilenum");
		String qunatity=request.getParameter("qunatity");
		String price=request.getParameter("price");
		String category=request.getParameter("category");
		String instruction=request.getParameter("instruction");
		Details d = new Details();
		int id = d.getID("productdistributor");
		
		System.out.println(lati+"_"+longi);
		
		 BufferedImage newImg;
		  newImg = ImageUtils.decodeToImage(imageDataString);
		  
		  String filename=id+"-"+username+".png";
		  
	        ImageIO.write(newImg, "png", new File(pathofdataset+filename));
	        
	        InputStream is = new BufferedInputStream(new FileInputStream(pathofdataset+filename));
	        
	        
	        
	      String sql = "INSERT INTO productdistributor(category,quantity,price,username,instruction,status,location) values (?, ?, ?,?,?,?,?)";
	    	
//			String query="insert into lostfir(childname,filename,parentmobilenumber,address) values(?,?,?,?)";

			
			
	        PreparedStatement psmt;
		
				try {
					psmt = con.prepareStatement(sql);
					 psmt.setString(1,category);
		   		      
		   		        psmt.setString(2,qunatity);
		   		     psmt.setString(3,price);
		   		  psmt.setString(4,username);
	   		        psmt.setString(5,instruction);
	   		        psmt.setString(6,"Pending");
	   		     psmt.setString(7,address);
//	   		  psmt.setString(9,address);
		   	
		   		  if (is != null) {
		                //files are treated as BLOB objects in database
		                //here we're letting the JDBC driver
		                //create a blob object based on the
		                //input stream that contains the data of the file
//		   			psmt.setBlob(1, is);
		            }
		   		      
		                   int i = psmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				String query1="update productdistributor set imagefile=? where id="+id;

		           PreparedStatement psmt3;
		   	
		   		
						try {
							psmt3 = con.prepareStatement(query1);
							
							  if (is != null) {
					                
					   			psmt3.setBlob(1, is);
//					   			psmt3.setString(2, String.valueOf(id));
					            }
							   int im = psmt3.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  
	        
	        
		
	
	}

}
