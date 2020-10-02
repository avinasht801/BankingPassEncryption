package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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

/**
 * Servlet implementation class checkuseravailability
 */
@WebServlet("/checkuseravailability")
public class checkuseravailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkuseravailability() {
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


		

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String keyfound = request.getParameter("keyfound");
		String selectedFromList = request.getParameter("selectedFromList");
		
		ArrayList<studentinfo> studentList=new ArrayList<studentinfo>();
		try {
			studentList=getAllCountries(name,email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				  Gson gson = new Gson();
				  JsonElement element = gson.toJsonTree(studentList, new TypeToken<List<Countries>>() {}.getType());
		JsonObject jsonObject=new JsonObject();

				  JsonArray jsonArray = element.getAsJsonArray();
				  jsonObject.add("jsonarrayval", jsonArray);
				  response.setContentType("application/json");
				  response.getWriter().print(jsonObject);
		
		

		
    
		
		
	
	
	}

	public  ArrayList<studentinfo> getAllCountries(String name, String email) throws Exception {
	     //connection = con;
		
	
		ArrayList<studentinfo> studentList=new ArrayList<studentinfo>();
	        String sql="select * from usertable1 where name='"+name+"' or email='"+email+"'";
	    	
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = con.prepareStatement(sql);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	    	     studentinfo student=new studentinfo();
	    	     if(rs.next()){
	    	    	
	    	    	 student.setMessage("Please choose different username or email");
	    	     }
	    	     else{ 
	            	
	            	
	            	
	            	  
	            	  student.setMessage("CORRECT");
	            	
	            	 
	            }
	    	     
	    	     studentList.add(student);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return studentList;
	}

}




