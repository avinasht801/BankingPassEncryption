


<%@page import="java.util.Date"%>
<%@page import="Database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>




  <br>

  <br>
    <br>
      <br>
      
  <br>
    <br>
      <br>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <meta charset="UTF-8">
  <title>Responstable 2.0: a responsive table solution</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style7.css">

  
</head>
<script type="text/javascript">
	function getvname(str)
	{
		//alert(str);
		if(window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
			xmlhttp.onreadystatechange=function()
		  {
		  if(xmlhttp.readyState==4 && xmlhttp.status==200)
		  {			  
		    document.getElementById("vehname").innerHTML=xmlhttp.responseText;
		  }
		  }
		xmlhttp.open("GET","getvcat.jsp?vehtype="+str,true);
		xmlhttp.send();
	}
</script>

<body>
	<form class="jotform-form" action="vehicledetails" method="post"
		name="form_70430832046448" id="70430832046448" accept-charset="utf-8">

	</form>
 
<div id="tableWrap">
<table class="responstable" >


					


  <tr>
     <th>password</th>


			
				
					
  </tr>
  <%


	

	DatabaseConnection db = new DatabaseConnection();
	db.dbconnection();
	ResultSet rs = null;
	String sql1="Select * from userdetails  " ;
	rs=db.getResultSet(sql1);
	
	
	while (rs.next())	
	
	{

		
		
%>
<!-- 			<input type="hidden" name="vehno" /> -->
<!-- 			<input type="hidden" name="vehname" /> -->
<!-- 			<input type="hidden" name="vehno" /> -->
<!-- 			<input type="hidden" name="eno" /> -->
<!-- 			<input type="hidden" name="chno" /> -->
<!-- 			<input type="hidden" name="depot" /> -->
<!-- 			<input type="hidden" name="vehcomplaint" /> -->
<!-- 			<input type="hidden"  name="fine" /> -->
<!-- 			<input type="hidden"  name="date" /> -->
<!-- 			<input type="hidden" name="battery" /> -->
<!-- 			<input type="hidden" name="reason" /> -->
<!-- 			<input type="hidden" name="mirror" /> -->
<!-- 			<input type="hidden" name="verified" /> -->
<!-- 			<input type="hidden" name="towing" /> -->
<!-- 			<input type="hidden"  name="doc" /> -->
<!-- 			<input type="hidden"  name="details" /> -->
<!-- 			<input type="hidden"  name="outtime" /> -->
	<tr>
		<td><%=rs.getString("password")%></td>
				

					
				</tr>
				
				
 
  

  			<%} %>
  			

					
</table>
</div>

</body>
</html>