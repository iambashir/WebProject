<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="categories" value="${sessionScope.categories}" />
<c:set var="rowsPerPage" value="${sessionScope.rowsPerPage}" />
<c:set var="pageNumber" value="${param.pageNumber}"/>
<c:set var="numberOfPages" value="${sessionScope.numberOfPages}"/>

<c:set var="b" value="${pageNumber*rowsPerPage-rowsPerPage}"/>
<c:set var="e" value="${pageNumber*rowsPerPage-1}"/>
<center>
    <table border="1" width="40%">			    	
        <c:set var="columns" value="0" scope="session"/>
        <c:forEach items="${categories.columnNames}" var="name">
            <c:set var="columns" value="${columns+1}"/>
            <td bgcolor="silver"><c:out value="${name}"/></td>
        </c:forEach>
        <c:set var="columns" value="${columns-1}"/>

        <c:forEach items="${categories.rowsByIndex}" var="row" begin="${b}" end="${e}">
            <tr>
                <c:forEach begin="0" end="${columns}" var="x">
                    <td><c:out value="${row[x]}"/></td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

    <%--For displaying Previous link --%>
    <c:if test="${pageNumber gt 1}">
        <a href="printPage.jsp?pageNumber=${pageNumber - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${numberOfPages}" var="i">
        <c:choose>
            <c:when test="${i!=pageNumber}">
                <a href="printPage.jsp?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
            </c:when>
            <c:otherwise>
                <c:out value="${i}"/>
            </c:otherwise>		
        </c:choose>		
    </c:forEach>	
    <%--For displaying Next link --%>
    <c:if test="${pageNumber lt numberOfPages}">
        <a href="printPage.jsp?pageNumber=${pageNumber + 1}">Next</a>
    </c:if>
</center>