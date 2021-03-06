<%--
  Created by IntelliJ IDEA.
  User: Madhuri
  Date: 9/19/2018
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
</head>
<body>
<h1>Loginpage</h1>
<div class="container">

    <form method="POST" action="/login" modelAttribute="userForm" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="register">Create an account</a></h4>
            <h4 class="text-center"><a href="userlist">Users List</a></h4>

        </div>

    </form>

</div>

</body>
</html>
