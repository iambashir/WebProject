<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty param.username and not empty param.password}">
            <s:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                             url="jdbc:mysql://localhost:3306/jstlcrud"
                             user="root" password="root"/>

            <s:update dataSource="${ds}">
                insert into users(username, password) values(?,?)
            <s:param value='${param.username}'/>
            <s:param value='${param.password}'/>
        </s:update>
        <c:redirect url="createuser.jsp" >
            <c:param name="Msg" value="Data Inserted!" />
        </c:redirect>
    </c:if>
</body>
</html>
