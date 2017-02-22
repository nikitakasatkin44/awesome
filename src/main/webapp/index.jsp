<!DOCTYPE html>
<html lang="en" xmlns:c="http://java.sun.com/jsf/core">
<head>
    <title>Awesome application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar">1</span>
                <span class="icon-bar">2</span>
                <span class="icon-bar">3</span>
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
                <li><button type="button" class="btn btn-success btn-lg" id="myBtnlog" onclick="document.getElementById('login-form').style.display='block'" style="width:auto;">Login</button></li>
                <li><button type="button" class="btn btn-info btn-lg" id="myBtnreg" onclick="document.getElementById('registration-form').style.display='block'" style="width:auto;">Registration</button></li>
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

            <div class="container" id="registration-form">


                <div class="modal fade" id="myModalreg" role="dialog">
                    <div class="modal-dialog">

                        <div class="modal-content">
                            <div class="modal-header" style="padding:35px 50px;">
                                <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></button>
                                <br><h2> Registration</h2>
                            </div>

                            <div class="modal-body" style="padding:40px 50px;">
                                <form action="/registration" method="post" role="form" data-toggle="validator" name="registrationForm" onsubmit="return validateForm()">
                                    <c:if test ="${empty action}">
                                        <c:set var="action" value="add"/>
                                    </c:if>
                                    <div class="form-group">
                                        <label for="name"><span class="glyphicon glyphicon-user"></span> Username</label>
                                        <input type="text" name="name" class="form-control" id="name" placeholder="Enter Username" value="${user.name}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass1"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                                        <input type="password" name="pass1" class="form-control" id="pass1" placeholder="Enter password" value="${user.password}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="pass2"><span class="glyphicon glyphicon-eye-open"></span> Confirm password</label>
                                        <input type="password" name="pass2" class="form-control" id="pass2" placeholder="Repeat password" >
                                    </div>
                                    <div class="form-group">
                                        <label for="email"><span class="glyphicon glyphicon-envelope"></span> Email</label>
                                        <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required>
                                    </div>

                                    <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> To register</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                                <p>Forgot <a href="#">Password?</a></p>
                            </div>
                        </div>

                    </div>
                </div>
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

    $(document).ready(function(){
        $("#myBtnreg").click(function(){
            $("#myModalreg").modal();
        });
    });
</script>
</html>
