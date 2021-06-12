<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/jstlcrud" user="root" password="root" />

<sql:query dataSource="${dataSource}" var="categories" scope="session">
   		SELECT * FROM product
</sql:query>

<c:import url="dispresult.jsp?pageNumber=1"/>






