package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

/**
 * Servlet implementation class send1
 */
@WebServlet("/send1")
public class send1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send1() {
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
		String NameOnCard = request.getParameter("NameOnCard");
		String CardNo = request.getParameter("CardNo");
        String cvvno = request.getParameter("cvvno");
        String validity = request.getParameter("validity");
                                                                                       
        DatabaseConnection db = new DatabaseConnection();
        db.dbconnection();
        
	        String queryText = "insert into carddetails2(NameOnCard, Cardno, validity, cvvno) values('"+NameOnCard+"','"+ CardNo+"','"+ cvvno+"','"+validity+"')";
	
	        int i = db.getUpdate(queryText);
	        if(i==1)
	        {
	        	out.println("<script type=\"text/javascript\">");
	        	out.println("alert('Successfully transaction done')");
	        	out.println("location=\"index.jsp\"");
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
