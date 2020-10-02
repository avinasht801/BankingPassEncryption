<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Utilizer Login Form Flat Responsive Widget Template :: W3layouts</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="Utilizer Login Form template Responsive, Login form web template, Flat Pricing tables, Flat Drop downs Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

    <script>
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }

    </script>
    <!-- //Meta tag Keywords -->
    <!-- Custom-Files -->
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <!-- font-awesome-icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome-icons -->
    <!-- /Fonts -->
    <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700" rel="stylesheet">
    <!-- //Fonts -->
</head>

<body>
    <!-- main -->
    <div class="main-top-intro">
        <div class="bg-layer">
            <!-- header -->
            <div class="wrapper">
                <header>
                    <div class="header-w3layouts">
                        <h1>
                            <a class="navbar-brand logo" href="index.html">
                                Utilizer
                            </a>
                        </h1>
                    </div>
                    <div class="nav_w3pvt">
                        <nav>
                            <label for="drop" class="toggle mt-lg-0 mt-2"><span class="fa fa-bars" aria-hidden="true"></span></label>
                            <input type="checkbox" id="drop" />
                            <ul class="menu">
                                <li class="active"><a href="#">Home</a></li>
                                <li class=""><a href="#">About</a></li>
                                <li class=""><a href="#">Services</a></li>
                                <li class="p-0">
                                    <!-- First Tier Drop Down -->
                                    <label for="drop-2" class="toggle">Pages <span class="fa fa-angle-down" aria-hidden="true"></span> </label>
                                    <a href="#">Pages <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                                    <input type="checkbox" id="drop-2" />
                                    <ul class="inner-dropdown">
                                        <li><a href="#">Error Page</a></li>
                                        <li><a href="#">About Us</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Portfolio</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="buttons mt-lg-0 mt-3 ml-auto">
                        <div class="form-w3layouts-grid">
                            <form action="#" method="post" class="newsletter">
                                <input class="search" type="search" placeholder="" required="">
                                <button class="form-control btn" value=""><span class="fa fa-search"></span></button>
                                <div class="clear"></div>
                            </form>
                        </div>
                    </div>
                    <div class="clear"></div>


                </header>
                <!-- //header -->
                <div class="content-inner-info">
                    <h2>Say Hello !!!</h2>
                    <div class="content-w3layouts-main">

                        <div class="form-w3ls-left-info">
                            <form action="../Login" method="post">


                              <form action="Registration" method="post">
			<h1>Registration Form</h1>
			<div>
				<input type="text" name="fullname" placeholder="Fullname" required id="Fullname" />
			</div>
			<div>
				<input type="text" name="city" placeholder="City" required id="city" />
			</div>
			<div>
				<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Email" required id="email" />
			</div>
			<div>
				<input type="text" name="mobile" pattern="[789][0-9]{9}" placeholder="Mobile" required id="mobile" />
			</div>
<!-- 			<div> -->
<!-- 				<select name="honeymethod" required id="passpolicy"> -->
<!-- 					<option value="">Select Honey Creator Method </option> -->
<!-- 					<option value="passwd">Password-model</option> -->
<!-- 					<option value="chaff">Chaffing by Tweaking</option> -->
<!-- 					<option value="chaffdig">Chaffing by Tweaking Digits</option> -->
<!-- 					<option value="tail">Take-a-tail</option> -->
<!-- 					<option value="hybrid">Hybrid model</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<select name="passpolicy" required id="passpolicy"> -->
<!-- 					<option value="">Select Password Reset Policy </option> -->
<!-- 					<option value="prefix">Prefix Method</option> -->
<!-- 					<option value="postfix">Postfix Method</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
			<div>
				<input type="text" name="username" pattern=".{5,}" title="Five or more characters"  placeholder="Username" required id="Username" />
			</div>
			<div>
				<input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" placeholder="Password" required id="Password" />
			</div>
			<div>
				<input type="password" name="rePassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" placeholder="Confirm password" required onblur="myFunction()" id="confirm_password" />
			</div>

                                <div class="links">
                                           <p><a href="index.jsp">login</a></p>
                                        

                                </div>
                                <div class="bottom">
                     <form action="register.jsp">
                                    <button class="btn" type="submit">REGISTER</button>
                                 
                          

                            </form>
                        </div>

                    </div>
                </div>
                <!-- copyright -->
                <div class="copy-w3layouts-inf">
                    <p>© 2019
                        Utilizer Login. All rights reserved | Design by
                        <a href="http://w3layouts.com"> W3layouts.</a>
                    </p>
                    <ul class="list-unstyled w3layouts-icons">
                        <li>
                            <a href="#" class="face-b">
                                <span class="fa fa-facebook-f"></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="twit">
                                <span class="fa fa-twitter"></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="dribble">
                                <span class="fa fa-dribbble"></span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="vk">
                                <span class="fa fa-vk"></span>
                            </a>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
                <!-- //copyright -->
            </div>
        </div>
    </div>
    <!-- //main -->

</body>

</html>

</body>
</html>