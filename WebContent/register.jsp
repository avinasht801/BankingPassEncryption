<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">

<head>
        <title>Banking Password Encryption</title>
    <!-- meta tags -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="keywords" content="Art Sign Up Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, 
		Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
    />
    <!-- /meta tags -->
    <!-- custom style sheet -->
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <!-- /custom style sheet -->
    <!-- fontawesome css -->
    <link href="css/fontawesome-all.css" rel="stylesheet" />
    <!-- /fontawesome css -->
    <!-- google fonts-->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- /google fonts-->

</head>


<body>
    <h1>Banking Password Encryption</h1>
    <div class=" w3l-login-form">
        <h2>Login Here</h2>
		<form action="Registration" method="post">

            <div class=" w3l-form-group">
                <label>fullname:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
                 	<input type="text" name="fullname" placeholder="Fullname" required id="Fullname" />
                </div>
            </div>
              <div class=" w3l-form-group">
                <label>city:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
              	<input type="text" name="city" placeholder="City" required id="city" />
                </div>
            </div>
              <div class=" w3l-form-group">
                <label>email:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
                  <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Email" required id="email" />
                </div>
            </div>
              <div class=" w3l-form-group">
                <label>mobile:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
                <input type="text" name="mobile" pattern="[789][0-9]{9}" placeholder="Mobile" required id="mobile" />
                </div>
            </div>
               <div class=" w3l-form-group">
                <label>username:</label>
                <div class="group">
                    <i class="fas fa-user"></i>
              <input type="text" name="username" pattern=".{5,}" title="Five or more characters"  placeholder="Username" required id="Username" />
                </div>
            </div>
            <div class=" w3l-form-group">
                <label>Password:</label>
                <div class="group">
                    <i class="fas fa-unlock"></i>
<input type="password" name="password" placeholder="password" required id="password" />
                </div>
                <div class=" w3l-form-group">
                <label></div>RePassword:</label>
                <div class="group">
                    <i class="fas fa-unlock"></i>
<input type="password" name="rePassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" placeholder="Confirm password" required onblur="myFunction()" id="confirm_password" />
                </div>
            </div>
            <div class="forgot">
       	<div class="forgot"><a href="forgot.jsp">Lost your password?</a></div>
     
            </div>
            <button type="submit">Register</button>
        </form>
		<a href="index.jsp">login</a>
    </div>
    <footer>
        <p class="copyright-agileinfo"> &copy; 2018 Material Login Form. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
    </footer>

</body>

</html>