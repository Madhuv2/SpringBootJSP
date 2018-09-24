<%--
  Created by IntelliJ IDEA.
  User: Madhuri
  Date: 9/20/2018
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<h1>List Of Users</h1>

<form action="/userlist" method="GET">



    <c:if test="${not empty users}">
        <ul>
            <c:forEach var="user" items="${users}">

                        <li>${user.username}</li>

            </c:forEach>
        </ul>
    </c:if>


</form>
</body>
</html>
