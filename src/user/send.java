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
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String Amount = request.getParameter("Amount");
		String AccountNumber = request.getParameter("AccountNumber");
        String CardNo = request.getParameter("CardNo");
        String cvvno = request.getParameter("holdername");
                                                                                       
        DatabaseConnection db = new DatabaseConnection();
        db.dbconnection();
        
	        String queryText = "insert into carddetails1(Amount, AccountNumber, CardNo, cvvno) values('"+Amount+"','"+ CardNo+"','"+ cvvno+"','"+AccountNumber+"')";
	
	        int i = db.getUpdate(queryText);
	        if(i==1)
	        {
	        	out.println("<script type=\"text/javascript\">");
	        	out.println("alert('Successfully Enter Details')");
	        	out.println("location=\"cardetails1.jsp\"");
	        	out.println("</script>");
	        }
	        else
	        {         
	        	out.println("<script type=\"text/javascript\">");
	        	out.println("alert('Error Occred in Registration')");
	        	out.println("location=\"signup.jsp\"");
	        	out.println("</script>");
	        }
	}

}
