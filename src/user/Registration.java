package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		Map<Integer, String> repassmethod = new HashMap<>();
		repassmethod.put(1, "prefix");
		repassmethod.put(2, "postfix");
		
		PrintWriter out = response.getWriter();
		String fullname = request.getParameter("fullname");
		String city = request.getParameter("city");
		String Email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        
        int randomgender = 1 + (int) (Math.random() * repassmethod.size());
        String policy = repassmethod.get(randomgender);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");  

        DatabaseConnection db = new DatabaseConnection();
   		db.dbconnection();
   		int id = 0;
   		String query = "select max(id) from userdetails";
   		ResultSet rs = db.getResultSet(query);
   		try {
			if(rs.next()){
				id = 1 + rs.getInt(1);
			}
		} catch (SQLException e) {
		}
   		
   		String words = "";
   		
//   		int strength = CheckPasswordStrength.calculatePasswordStrength(password);
//   		
//   		if(strength >= 14){
//   			
//   			words = HoneyCreater.Hybridhoneywords(password);
//        	words = words.substring(1);
//        	
//   		}
//   		else if(strength > 12){
//   			
//   			words = HoneyCreater.chaffdigithoneywords(password);
//        	words = words.substring(1);
//        	
//   		}else if(strength > 10){
//   			
//   			words = HoneyCreater.chaffdigithoneywords(password);
//        	words = words.substring(1);
//        	
////        	words = HoneyCreater.Takeatailhoneywords(password);
////        	words = words.substring(1);
//        	
//   		}else if(strength > 8){
//   			
//   			words = HoneyCreater.chaffwordhoneywords(password);
//        	words = words.substring(1);
//        	
//   		}else if(strength > 6){
//        	
//        	words = HoneyCreater.passmodelHoneyword(password);
//        	words = words.substring(1);
//        	
//   		}
   		
   		String strength = Strength.Passalgo(password);
   		if(strength.equals("passwordmodel")){
   			words = HoneyCreater.passmodelHoneyword(password);
        	words = words.substring(1);
   		}
   		if(strength.equals("hybridmodel")){
   			words = HoneyCreater.Hybridhoneywords(password);
        	words = words.substring(1);
   		}
   		if(strength.equals("chaffdigit")){
   			words = HoneyCreater.chaffdigithoneywords(password);
        	words = words.substring(1);
   		}
   		
   		query = "select * from userdetails where username = '"+username+"'";
   		rs = db.getResultSet(query);
   		try {
			if(rs.next()){
				out.println("<script type=\"text/javascript\">");
	        	out.println("alert('Same username already exists in system, Please try another username')");
	        	out.println("location=\"index.jsp\"");
	        	out.println("</script>");
			}
			else{
   		
        String queryText = "insert into userdetails values("+id+",'"+fullname+"','"+city+"','"+Email+"','"+mobile+"', '"+ username+"','"+words+"','"+policy+"')";
        int i = db.getUpdate(queryText);
        if(i==0)
        {
        	out.println("<script type=\"text/javascript\">");
        	out.println("alert('Please provide all values')");
        	out.println("location=\"home.jsp\"");
        	out.println("</script>");
        }
        else
        {
        	out.println("<script type=\"text/javascript\">");
        	out.println("alert('Register Successfully')");
        	out.println("location=\"index.jsp\"");
        	out.println("</script>");
        }
	  }
   		} catch (SQLException e) {
		}
	}
}
