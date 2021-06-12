<%-- 
    Document   : index
    Created on : Sep 13, 2018, 3:18:28 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="dologin">
            <input type="text" name="username" value="" />
            <input type="password" name="password" value="" />
            <input type="submit" value="Submit" />
        </form>
        <a href="registration.jsp">Registration</a>
    </body>
</html>
