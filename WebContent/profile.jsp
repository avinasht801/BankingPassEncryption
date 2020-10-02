<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Honeywords</title>
      <link rel="stylesheet" href="css/style.css">
</head>

<body>
  <body>
<div class="container">
	<section id="content">
		<form action="Registration" method="post">
			<h1>Registration Form</h1>
			<div>
				<input type="text" name="fname" placeholder="Fullname" required id="Fullname" />
			</div>
			<div>
				<input type="text" name="address" placeholder="Address" required id="address" />
			</div>
			<div>
				<input type="email" name="email" placeholder="Email" required id="email" />
			</div>
			<div>
				<input type="text" name="mobile" placeholder="Mobile" required id="mobile" />
			</div>
			<div>
				<input type="text" name="Username" placeholder="Username" required id="Username" />
			</div>
			<div>
				<input type="password" name="Password" placeholder="Password" required id="Password" />
			</div>
			<div>
				<input type="password" name="rePassword" placeholder="Confirm password" required id="rePassword" />
			</div>
			<div>
				<input type="submit" value="Register" />
				<div class="forgot"><a href="forget.jsp">Lost your password?</a></div>
				<div class="forgot"><a href="index.jsp">Login</a></div>
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div><!-- container -->
</body>
  
    <script src="js/index.js"></script>

</body>
</html>
