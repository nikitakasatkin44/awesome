<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
      <link rel="stylesheet" href="../css/bootstrap.min.css">
      <script src="../js/bootstrap.min.js"></script>
  </head>

  <body>
    <div class="container">
        <h2>Users</h2>

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
    </div>
  </body>
</html>