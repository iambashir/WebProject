
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="c_user.jsp" >
            Username: <input type="text" name="username"/><br/>
            Password: <input type="password" name="password"/><br/>
            <input type="submit" />
        </form>
        <c:if test="${not empty param.Msg}">
            <c:out value="${param.Msg}" />
        </c:if>
    </body>
</html>
