package MainPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class DataFromUser
 */
@WebServlet("/DataFromUser")
public class DataFromUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection db1;
	 JsonObject jsonObject;
	 Connection con;
	   ArrayList<Countries> country=new ArrayList<Countries>();
	   static String idgoing="";
	   static String usernameof="";
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFromUser() {
        super();
        db1 = new DatabaseConnection();
    		con=db1.dbconnection();
    		jsonObject=new JsonObject();
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
		String arrayofPurchasedItems=(String)request.getParameter("arrayofPurchasedItems");
		String username=request.getParameter("username");
		String location=request.getParameter("location");
		String store=request.getParameter("store");
		usernameof=username;
		
		String arrayItems[]=arrayofPurchasedItems.split(",");
		float totalAmount=0;
		String itemsPurchased="";
		String amountPurchased="";
		int i=0;
		String amountforenter="";
		int ids=0;
		while(i<arrayItems.length){

	if(itemsPurchased.equals(""))
	{
		String array[]=arrayItems[i].split(":");
		itemsPurchased=(String) (array[0]);
		String array1[]=array[0].split(" ");
		ids=Integer.parseInt(array1[0]);	
		idgoing=idgoing+ids+",";
		amountforenter=array[1];
		amountPurchased=(String) (array[1]);
	}
	else
	{
		String array[]=arrayItems[i].split(":");
		String array1[]=array[0].split(" ");
		ids=Integer.parseInt(array1[0]);
		idgoing=idgoing+ids+",";
		itemsPurchased=itemsPurchased+","+	(String) (array[0]);
		amountPurchased=amountPurchased+","+(String) (array[1]);
		amountforenter=array[1];
	}
	totalAmount=totalAmount+Float.parseFloat((String) (amountforenter));
	i++;
		}
		
		Details d = new Details();
		int id = d.getID("purchasedproduct");
		String query="insert into purchasedproduct values(?,?,?,?,?,?,?,?)";

           PreparedStatement psmt;
   	
   			try {
				psmt = con.prepareStatement(query);
				   psmt.setInt(1,id);
	   		        psmt.setString(2,username);
	   		        psmt.setString(3,itemsPurchased);
	   		        psmt.setString(4,amountPurchased);
	   		        psmt.setString(5,String.valueOf(totalAmount));
	   		        psmt.setString(6,"0");
	   		     psmt.setString(7,location);
	   		  psmt.setString(8,store);

	                   int im = psmt.executeUpdate();
	                   if(im>0)
	                   {
	                		  country=getAllCountries("Success",id);  
	                		  String accountdetails=id+","+itemsPurchased+","+totalAmount;
	                		  
	                		  String query1="update product set status=?,userordered=? where id="+ids;

	       		           PreparedStatement psmt3;
	       		   	
	       		   		
	       						try {
	       							psmt3 = con.prepareStatement(query1);
	       							psmt3.setString(1, "Ordered");
	       							psmt3.setString(2, username);
	       							int imy = psmt3.executeUpdate();
	       						} catch (SQLException e) {
	       							// TODO Auto-generated catch block
	       							e.printStackTrace();
	       						}
	                		  
//	       						GCMNotification2.messagesending();	
	                		  
//	              			try {
//	              				QRCode.qrcodeReader(accountdetails);
//	              			} catch (NotFoundException | WriterException e1) {
//	              				// TODO Auto-generated catch block
//	              				e1.printStackTrace();
//	              			}
//	              			String query1="insert into qrcodereader values(?,?,?,?,?,?)";
//
//	              			Date date=new Date();
//	              			java.util.Date dt = new java.util.Date();
//
//	              			java.text.SimpleDateFormat sdf = 
//	              			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//	              			String currentTime = sdf.format(dt);
//	              			  Calendar calendar = Calendar.getInstance();
//	              		      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//	              			
//	              	        PreparedStatement psmt1;
//	              	        InputStream is = null;
//	              				try {
//	              					psmt1 = con.prepareStatement(query1);
//	              					 psmt1.setInt(1,id);
//	              					 is=new FileInputStream(new File(accountdetails+".png"));
//		              			       // is = new FileInputStream(new File("Student_img.jpg"));
//		              			        psmt1.setBinaryStream(2, is);
//		              			      psmt1.setString(3,username);
//		              			    psmt1.setString(4,"0");
//	              					 psmt1.setDate(5, startDate);
//	              					psmt1.setString(6, location); 
//	              		   		   
//	              		   		
//	              		   		 
//	              			        
//	              		   		      
//	              		                   int i1 = psmt1.executeUpdate();
//	              				} catch (SQLException e) {
//	              					// TODO Auto-generated catch block
//	              					e.printStackTrace();
//	              				}
	              			
	              		
	                   }
	                   else
	                   {
	                	   country=getAllCountries("Failure",0);     
	                   }
	                   System.out.println(psmt);
			 System.out.println(totalAmount); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 country=getAllCountries("Failure",0);     
			}
   			
   		   sendjson(response)  ;
		
	}
	private void sendjson(HttpServletResponse response) throws IOException {
		 Gson gson = new Gson();
  	  JsonElement element = gson.toJsonTree(country, new TypeToken<List<Countries>>() {}.getType());
  	 JsonArray jsonArray = element.getAsJsonArray();
  	  jsonObject.add("jsonarrayval", jsonArray);
  	  response.setContentType("application/json");
  	  response.getWriter().print(jsonObject);
		
	}
	public  ArrayList<Countries> getAllCountries(String activity, int id) {
	     //connection = con;
	        ArrayList<Countries> countryList = new ArrayList<Countries>();
	       
	            	
	            	
	        Countries country=new Countries();
	        if("Success".equals(activity))
	        {
	        	System.out.println("in success");
	        	country.setMessage(""+id);	
	        	
	        }
	        
	        else  if("Failure".equals(activity))
	        {

	        	country.setMessage("Some error occured. Please Try again");	
	        }
	        countryList.add(country);
	        return countryList;
	}	
}
