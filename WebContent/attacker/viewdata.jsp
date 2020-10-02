


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

<form action="searchtweet" method="post" class="d-flex">
							<input class="form-control" type="search" name ="search" placeholder="Search here..." required="">
					<input type="submit" value="submit">
								<i class="fas fa-search"></i>
							</button>
						</form>
						
						<a href="viewtwiiterdata.jsp">view twitter data</a>


<form class="jotform-form" action="selection" method="post"
		name="pid" id="70430832046448" accept-charset="utf-8">
		<li class="form-line" data-type="control_dropdown" id="id_18">
					
					
							<%

							DatabaseConnection db1 = new DatabaseConnection();
							db1.dbconnection();
							ResultSet rs1 = null;
							String sql="Select distinct pid from twitsanalysis " ;

							rs1=db1.getResultSet(sql);
							
							
							
							while(rs1.next())
							{ %>
							
							<%} %>
						</select>
					</div>
				</li>
			
	
					


  <tr>
     <th>tweet name</th>
    <th>tweet</th>

	
					<th>Tweet Date</th>
					<th>Tweet  NAME</th>

			
				
					
  </tr>
  <%


	String pid=(String)session.getAttribute("pid");
   

	DatabaseConnection db = new DatabaseConnection();
	db.dbconnection();
	ResultSet rs = null;
	String sql1="Select * from twitsanalysis  " ;
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
		<td><%=rs.getString("pid")%></td>
					<td><%=rs.getString("tweet")%></td>
					<td><%=rs.getString("tdate")%></td>
					<td><%=rs.getString("tname")%></td>

					
				</tr>
				
				
 
  

  			<%} %>
  			

					
</table>
</div>

</body>
</html>