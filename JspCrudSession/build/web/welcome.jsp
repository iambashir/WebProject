<%-- 
    Document   : welcome
    Created on : Sep 13, 2018, 3:50:25 PM
    Author     : User
--%>

<%@page import="bean.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Password</td>
            </tr>
       
        <% 
        List<User> user = (List<User>)request.getAttribute("user"); 
                        
        for(User u: user){
            %>
            <tr>
                <td><%out.println(u.getName()); %></td>
                <td><%out.println(u.getPass()); %></td>
            </tr><%
        
        }
        
        %>
         </table>
        
    </body>
</html>
