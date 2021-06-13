<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>
<s:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/jstlcrud" user="root" password="1234" />
<html>
    <head>
        <title>Query Example</title>
    </head>
    <body>
        <s:query var="users" dataSource="${dataSource}">
            select* from users;
        </s:query>
        <table border=1>
            <c:forEach var="row" items="${users.rows}">
                <tr>
                    <td><c:out value="${row.id}" /></td>
                    <td><c:out value="${row.username}" /></td>
                    <td><c:out value="${row.password}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
