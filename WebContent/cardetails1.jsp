<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.PrintWriter"%>
<html>
<head>
<title>Credit card fraud Detection system using Transaction behavier | Transaction :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pendent Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css2/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css2/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
<link href='http://fonts.googleapis.com/css?family=Monda:400,700' rel='stylesheet' type='text/css'>
</head>
	
<body>
<!-- header -->

<!-- //header -->

<!-- reg-form -->
	<div class="reg-form">
		<div class="container">
			<div class="reg">
				<h3>Pay Invoice</h3>
				<p>Welcome, please enter the following details to continue.</p>
				
				 <form action="send1" method="post">
					
					<ul>
						<li class="text-info">Name On Card: </li>
						<li><input type="text" name="NameOnCard" required></li>
					</ul>
					
					 <ul>
						<li class="text-info">Card No: </li>
						<li><input type="password" name="CardNo" ></li>
					 </ul>
					 <ul>
						<li class="text-info">cvv no: </li>
						<li><input type="text" name="cvv no" required></li>
					 </ul>
					  <ul>
						<li class="text-info">validity: </li>
						<li><input type="text" name="validity" required></li>
					 </ul>
	
								 
											
					<input type="submit" value="Process Transaction">
					
				</form>
			</div>
		
			
		</div>
	</div>
<!-- footer -->

<!-- //footer -->
</body>
</html>