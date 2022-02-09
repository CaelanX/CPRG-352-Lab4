<%-- 
    Document   : login
    Created on : Feb. 8, 2022, 8:03:33 p.m.
    Author     : caelan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <p>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="${username}" required>
            </p>
            <p>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </p>
            <p>
                <button type="submit">Login</button>
            </p>
        </form>
        <<p>${message}</p>
    </body>
</html>
