<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Awesome application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        .row.content {height: 1000px}

        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }


             /* Full-width input fields */
         input[type=text], input[type=password] {
             width: 100%;
             padding: 12px 20px;
             margin: 8px 0;
             display: inline-block;
             border: 1px solid #ccc;
             box-sizing: border-box;
         }

        /* Set a style for all buttons */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Extra styles for the cancel button */
        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        /* Center the image and position the close button */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
            position: relative;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            padding-top: 60px;
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button (x) */
        .close {
            position: absolute;
            right: 25px;
            top: 0;
            color: #000;
            font-size: 35px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: red;
            cursor: pointer;
        }

        /* Add Zoom Animation */
        .animate {
            -webkit-animation: animatezoom 0.6s;
            animation: animatezoom 0.6s
        }

        @-webkit-keyframes animatezoom {
            from {-webkit-transform: scale(0)}
            to {-webkit-transform: scale(1)}
        }

        @keyframes animatezoom {
            from {transform: scale(0)}
            to {transform: scale(1)}
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">About me</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><button onclick="document.getElementById('login-form').style.display='block'" style="width:auto;">Login</button></li>
                <li><button onclick="document.getElementById('registration-form').style.display='block'" style="width:auto;">Registration</button></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="https://www.tutorialspoint.com">tutorialspoint.com</a></p>
            <p><a href="http://www.mkyong.com">mkyong.com</a></p>
            <p><a href="https://www.w3schools.com">w3schools.com</a></p>
            <p><a href="http://www.journaldev.com">journaldev.com</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <h1>Landing Page</h1>

            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>

            <div id="login-form" class="modal">
                <form class="modal-content animate" action="/registration">
                    <div class="container">
                        <label><b>Name</b></label>
                        <input type="text" placeholder="Enter name" name="name" required>

                        <label><b>Surname</b></label>
                        <input type="text" placeholder="Enter surname" name="surname" required>

                        <label><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" required>

                        <button type="submit">Login</button>
                        <input type="checkbox" checked="checked"> Remember me
                    </div>

                    <div class="container" style="background-color:#f1f1f1">
                        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                        <span class="psw">Forgot <a href="#">password?</a></span>
                    </div>
                </form>
            </div>

            <div id="registration-form" class="modal">
                <form class="modal-content animate" action="/registration" method="post" role="form" data-toggle="validator" name="registrationForm" onsubmit="return validateForm()">
                    <c:if test ="${empty action}">
                        <c:set var="action" value="add"/>
                    </c:if>

                    <div class="container">
                        <input type="hidden" id="action" name="action" value="${action}">

                        <label for="name"><b>Username</b></label>
                        <input type="text" name="name" id="name" placeholder="Enter Username" value="${user.name}" required>

                        <label for="pass1"><b>Password</b></label>
                        <input type="password" name="password" id="pass1" placeholder="Enter Password" value="${user.password}" required>

                        <label for="pass2"><b>Confirm Password</b></label>
                        <input type="password" name="repeatPassword" id="pass2" placeholder="Retype Password" value="${user.passwordConfirm}"  required>

                        <label for="email"><b>Email</b></label>
                        <input type="email" name="email" id="email" placeholder="Enter email"  required>

                        <button type="submit">To register</button>
                    </div>
                </form>
            </div>

            <p>This site created entirely for educational purposes.</p>
            <hr>
        </div>
        <div class="col-sm-2 sidenav">
            <h3>These books served me as good source of knowledge:</h3>
            <div class="well">
                <p>"Spring in Action, 4th edition" by Craig Walls</p>
            </div>
            <div class="well">
                <p>"Beginning Java EE 7" by Antonio Goncalves</p>
            </div>
            <div class="well">
                <p>"Java. The Complete Reference" by Herbert Schildt</p>
            </div>
        </div>
    </div>
</div>



<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>

<script language="JavaScript" type="text/javascript">

    function validateForm() {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;
        var ok = true;
        if (pass1 != pass2) {
            alert("Passwords Do not match");
            document.getElementById("pass1").style.borderColor = "#E34234";
            document.getElementById("pass2").style.borderColor = "#E34234";
            ok = false;
        }
        return ok;
    }
    </script>
</html>
