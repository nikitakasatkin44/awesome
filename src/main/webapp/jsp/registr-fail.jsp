<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<title>Authorization failed!</title>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="/registration">Users</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="alert alert-warning">
        <strong> User already exists!</strong>
    </div>
    <br>
    <button type="button" id="redirectBtn" onclick="redirect();" class="btn btn-primary btn-lg">Return to authorization</button>
</div>
</body>

<script>
    function redirect() {
        window.location.replace('http://localhost:8080/index.jsp');
    }
</script>
</html>