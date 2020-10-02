package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
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
		// TODO Auto-generated method stub
		String card = "";
    	String pin = "";
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname");
		String Email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        if(!username.equalsIgnoreCase("admin")){
        	card = request.getParameter("cardno"); 
        	pin = request.getParameter("pin"); 
        }else{
        	card = "";
        	pin = "";
        }
        DatabaseConnection db = new DatabaseConnection();
   		db.dbconnection();

        String queryText = "Update customer set fullname= '"+fullname+"', email ='"+Email+"', mobile= '"+mobile+"',card = '"+card+"',pin = '"+pin+"', password ='"+ password+"' where username ='"+username+"'";
        int i = db.getUpdate(queryText);
        if(i==1)
        {
        	if(!username.equalsIgnoreCase("admin")){
        	out.println("<script type=\"text/javascript\">");
        	out.println("alert('Profile details Successfully Updated')");
        	out.println("location=\"customer/profile.jsp\"");
        	out.println("</script>");
        	}else{
        		out.println("<script type=\"text/javascript\">");
            	out.println("alert('Profile details Successfully Updated')");
            	out.println("location=\"admin/profile.jsp\"");
            	out.println("</script>");
        	}
        }
        else
        {
        	if(!username.equalsIgnoreCase("admin")){
        	out.println("<script type=\"text/javascript\">");
        	out.println("alert('Failed to update profile details')");
        	out.println("location=\"customer/profile.jsp\"");
        	out.println("</script>");
        	}else{
        		out.println("<script type=\"text/javascript\">");
            	out.println("alert('Profile details Successfully Updated')");
            	out.println("location=\"admin/profile.jsp\"");
            	out.println("</script>");
        	}
        }
	}
}
