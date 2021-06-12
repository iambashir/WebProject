<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Use bean example</h1>
        <jsp:useBean id="useBean" class="usebean.MessageBean" scope="request"></jsp:useBean>
        <% usebean.MessageBean mb = new usebean.MessageBean(); %>
        Initial message using jsp:getProperty:<br></br>
        <jsp:getProperty name="useBean" property="message"></jsp:getProperty><br></br>
        Initial message using jsp expression:<br></br>
        <%= mb.getMessage()%><br></br>
        
        <jsp:setProperty name="useBean" property="message" value="New Message"></jsp:setProperty>
        Message using jsp:getProperty after setting message:<br></br>
        <jsp:getProperty name="useBean" property="message"></jsp:getProperty><br></br>
        Message using jsp expression after setting message:<br></br>
        <%= useBean.getMessage()%><br></br>
        <% useBean.setMessage("message set using jsp expression"); %>
        <%= useBean.getMessage()%>
        
    </body>
</html>
