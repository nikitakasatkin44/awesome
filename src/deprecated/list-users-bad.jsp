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
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/index.jsp">Home</a></li>
                <li class="active"><a href="/registration">Users</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
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
            <h1>Users</h1>

            <form action="/registration" method="get" id="searchUserForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="searchName" id="searchName" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br><br>
            </form>

            <c:if test="${not empty message}">
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if>
            <form action="/registration" method="post" id="userForm" role="form" >
                <input type="hidden" id="idUser" name="idUser">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty userList}">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>#</td>
                                <td>Name</td>
                                <td>Surname</td>
                                <td>Password</td>
                                <td>Email</td>
                            </tr>
                            </thead>
                            <c:forEach var="user" items="${userList}">
                                <c:set var="classSuccess" value=""/>
                                <c:if test="${idUser == user.id}">
                                    <c:set var="classSuccess" value="info" />
                                </c:if>
                                <tr class="${classSuccess}">
                                    <td>
                                        <a href="/registration?idUser=${user.id}&searchAction=searchById">${user.id}</a>
                                    </td>
                                    <td>${user.name}</td>
                                    <td>${user.surname}</td>
                                    <td>${user.password}</td>
                                    <td>${user.email}</td>
                                    <td><a href="#" id="remove"
                                           onclick="document.getElementById('action').value='remove';document.getElementById('idUser').value='${user.id}';

                                                   document.getElementById('userForm').submit();">
                                        <span class="glyphicon glyphicon-trash"/>
                                    </a>
                                    </td>
                                </tr>

                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <br>
                        <div class="alert alert-info">
                            No people found
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>





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

<div class="container">
    <h2>Users</h2>

    <form action="/registration" method="get" id="searchUserForm1" role="form">
        <input type="hidden" id="searchAction1" name="searchAction" value="searchByName">
        <div class="form-group col-xs-5">
            <input type="text" name="searchName" id="searchName1" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
        <br><br>
    </form>

    <c:if test="${not empty message}">
        <div class="alert alert-success">
            ${message}
        </div>
    </c:if>
    <form action="/registration" method="post" id="userForm1" role="form" >
        <input type="hidden" id="idUser1" name="idUser">
        <input type="hidden" id="action1" name="action">
        <c:choose>
            <c:when test="${not empty userList}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>Name</td>
                        <td>Password</td>
                        <td>Email</td>
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${userList}">
                        <c:set var="classSuccess" value=""/>
                        <c:if test="${idUser == user.id}">
                            <c:set var="classSuccess" value="info" />
                        </c:if>
                        <tr class="${classSuccess}">
                            <td>
                                <a href="/registration?idUser=${user.id}&searchAction=searchById">${user.id}</a>
                            </td>
                            <td>${user.name}</td>
                            <td>${user.password}</td>
                            <td>${user.email}</td>
                            <td><a href="#" id="remove1"
                                   onclick="document.getElementById('action').value='remove';document.getElementById('idUser').value='${user.id}';

                                           document.getElementById('userForm').submit();">
                                <span class="glyphicon glyphicon-trash"/>
                            </a>
                            </td>
                        </tr>

                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    No people found
                </div>
            </c:otherwise>
        </c:choose>
    </form>
</div>



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

    $(document).ready(function() {
        $("#myBtnreg").click(function(){
            $("#myModalreg").modal();
        });
    });

    $(document).ready(function() {
        $("#myBtnlog").click(function() {
            $("#myModallog").modal();
        })
    })
</script>
</html>
