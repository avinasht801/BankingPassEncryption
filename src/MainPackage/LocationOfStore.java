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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import Database.DatabaseConnection;

/**
 * Servlet implementation class LocationOfStore
 */
@WebServlet("/LocationOfStore")
public class LocationOfStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection dbcon=new DatabaseConnection();
    Connection connection=null; 
    String username=""; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationOfStore() {
        super();
        connection=dbcon.dbconnection();
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
		 ArrayList<Countries> country=new ArrayList<Countries>();
		 username=request.getParameter("username");
		
		  country=getAllCountries();
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(country, new TypeToken<List<Countries>>() {}.getType());
JsonObject jsonObject=new JsonObject();

		  JsonArray jsonArray = element.getAsJsonArray();
		  jsonObject.add("jsonarrayval", jsonArray);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonObject);
	}

	public  ArrayList<Countries> getAllCountries() {
	     //connection = con;
	        ArrayList<Countries> countryList = new ArrayList<Countries>();
	        String sql="select * from usertable1";
	    	
	    	PreparedStatement ps1;
	    	try {
	    		ps1 = connection.prepareStatement(sql);
	    		// ps1.setString(1, "1" );
	    		    
	    	     ResultSet rs=ps1.executeQuery();
	            while(rs.next()) { 
	            	
	            	
	             Countries country=new Countries();
	             country.setLng(rs.getString("longi"));
	             country.setLat(rs.getString("lati"));
	             country.setPlace_name(rs.getString("email"));
	             country.setVicinity(rs.getString("name"));
	           
	          
	             
	             
//	             country.setCode(rs.getString("c_name"));
//	             country.setName(rs.getString("c_notes"));
//	                country.setContinent(rs.getString("c_notes_url"));
	               
	             countryList.add(country);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countryList;
	}

}

