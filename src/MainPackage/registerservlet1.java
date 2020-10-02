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
 * Servlet implementation class registerservlet1
 */
@WebServlet("/registerservlet1")
public class registerservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet1() {
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
		// TODO Auto-generated method stub

		 Details d = new Details();
		 int id = d.getID("multifactordata");
		String BankID="BNK"+id;
		
		
		String username = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		String password1 = request.getParameter("password1");
		String phonenumber = request.getParameter("phonenumber");
		String securityquestion = request.getParameter("securityquestion");
		String Answer = request.getParameter("Answer");
		
		
		String IMEI = request.getParameter("IMEI");
		
		String IMSI = request.getParameter("IMSI");
		
		
		String query="insert into multifactordata(bankID,IMEI,IMSI,question,answer,username,password) values(?,?,?,?,?,?,?)";

		
		
        PreparedStatement psmt;
	
			try {
				psmt = con.prepareStatement(query);
				 psmt.setString(1,BankID);
	   		        psmt.setString(2,IMEI);
	   		        psmt.setString(3,IMSI);
	   		     psmt.setString(4,securityquestion);
	   		  psmt.setString(5,Answer);
	   		     psmt.setString(6,username);
	   		  psmt.setString(7,password1);
	   	
	   		      
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
