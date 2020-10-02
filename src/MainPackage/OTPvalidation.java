package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class OTPvalidation
 */
@WebServlet("/OTPvalidation")
public class OTPvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
	 String sendToMObile;
	    ArrayList<studentinfo> studentList=new ArrayList<studentinfo>();
	    studentinfo student=new studentinfo();
	    String year="100831"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPvalidation() {
        super();
        con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankid=request.getParameter("bankid");
		String otp=request.getParameter("otp");
		
		
		
		 String sql="select * from multifactordata where bankID='"+bankid+"' and OTP='"+otp+"'";
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = con.prepareStatement(sql);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	            if(rs.next()) { 
	            	
		            	System.out.println("output correct");
		            	request.getRequestDispatcher("Success.jsp").forward(request,response);
		          	
	            }
	            else
	            {
	            	System.out.println("output Wrong");
	            	  request.getRequestDispatcher("Failure.jsp").forward(request,response);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
