<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="rowsPerPage" value="2" scope="session"/>

<c:set var="categories" value="${sessionScope.categories}"/>

<c:set var="a">
    <fmt:formatNumber value="${categories.rowCount/rowsPerPage}" maxFractionDigits="0"/>
</c:set>

<c:set var="b" value="${categories.rowCount/rowsPerPage}" />


<c:choose>
    <c:when test="${a==0}">
        <c:set var="numberOfPages" value="1" scope="session"/>   
    </c:when>

    <c:when test="${b>a}">
        <c:set var="xxx" value="${b%a}"/>
        <c:if test="${xxx>0}">
            <c:set var="numberOfPages" value="${b-xxx+1}" scope="session"/>   
        </c:if>
    </c:when>

    <c:when test="${a>=b}">
        <c:set var="numberOfPages" value="${a}" scope="session"/>	   
    </c:when>
</c:choose>
<center>
    <table border="1" width="40%">			    	
    <c:set var="columns" value="0" scope="session"/>
    <c:forEach items="${categories.columnNames}" var="name">
        <c:set var="columns" value="${columns+1}"/>
        <td bgcolor="silver"><c:out value="${name}"/></td>
    </c:forEach>
    <c:set var="columns" value="${columns-1}"/>

    <c:forEach items="${categories.rowsByIndex}" var="row" begin="0" end="${rowsPerPage-1}">
        <tr>
            <c:forEach begin="0" end="${columns}" var="x">
                <td><c:out value="${row[x]}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>


<c:forEach begin="1" end="${numberOfPages}" var="i">
    <c:choose>
        <c:when test="${i!=1}">
            <a href="printPage.jsp?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
        </c:when>
        <c:otherwise>
            <c:out value="${i}"/>
        </c:otherwise>		
    </c:choose>		
</c:forEach>	   

<%--For displaying Next link --%>
    <a href="printPage.jsp?pageNumber=${pageNumber + 2}">Next</a>
 
</center>





<%-- <c:set var="totalCount" scope="session" value="${categories.rowCount}"/>
<c:set var="perPage" scope="session" value="2"/>
<c:set var="totalPages" scope="session" value="${totalCount/perPage}"/>

    <c:set var="pageIndex" scope="session" value="${param.start/perPage+1}"/>

   <c:if test="${!empty param.start && param.start >(perPage-1) && param.start !=0 }">
          <a href="?start=<c:out value="${param.start - perPage}"/>">Prev </a>

    </c:if>

   <c:forEach
        var="boundaryStart"
        varStatus="status"
        begin="0"
        end="${totalCount - 1}"
        step="${perPage}">
        <c:choose>
            <c:when test="${status.count>0 && status.count != pageIndex}">
                             <a href="?start=<c:out value='${boundaryStart}'/>">

                                <c:out value="${status.count}"/> |
                            </a>
            </c:when>
        <c:otherwise>
                <c:out value="${status.count}"/> |
        </c:otherwise>

        </c:choose>
    </c:forEach>

    <c:if test="${empty param.start || param.start<(totalCount-perPage)}">
          <a href="?start=<c:out value="${param.start + perPage}"/>">Next </a>

</c:if>--%>