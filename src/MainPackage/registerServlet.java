package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String regId = request.getParameter("regId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String macid = request.getParameter("macid");
		String phonenum = request.getParameter("phonenumber");
		String query="insert into usertable1(name,email,regId,mobilenumber,department) values(?,?,?,?,?)";

		
		
        PreparedStatement psmt;
	
			try {
				psmt = con.prepareStatement(query);
				 psmt.setString(1,name);
	   		        psmt.setString(2,email);
	   		        psmt.setString(3,regId);
	   		     psmt.setString(4,phonenum);
	   		  psmt.setString(5,phonenum);
	   		     
	   		      
	                   int i = psmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String regId = request.getParameter("regId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String macid = request.getParameter("macid");
		String phonenum = request.getParameter("phonenumber");
		String lati = request.getParameter("lati");
		String longi = request.getParameter("longi");
		String query="insert into usertable1(name,email,regId,phone,lati,longi) values(?,?,?,?,?,?)";

		
		
        PreparedStatement psmt;
	
			try {
				psmt = con.prepareStatement(query);
				 psmt.setString(1,name);
	   		        psmt.setString(2,email);
	   		        psmt.setString(3,regId);
	   		     psmt.setString(4,phonenum);
	   		  psmt.setString(5,lati);
	   		     psmt.setString(6,longi);
	   	
	   		     
	   		      
	                   int i = psmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//		SendSms sendsmss=new SendSms();
//		sendsmss.Way2SMS(phonenum, regId);
//		SendEmail sendemail=new SendEmail(email, "Your apps registration id is", regId);
//	
	
	}

}
