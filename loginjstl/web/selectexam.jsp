<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pageContext.request.method=='POST'}">
  <c:choose>
    <c:when test="${param.add!=null}">
      <c:if test="${list!=null}">
        <c:set var="list" value="${list}," scope="session" />
      </c:if>

      <c:set var="list" value="${list}${param.item}"
      scope="session" />
    </c:when>

    <c:when test="${param.remove!=null}">
      <c:set var="list2" value="" />

      <c:forEach var="item" items="${list}">
        <c:if test="${item!=param.item}">
          <c:if test="${list2!=''}">
            <c:set var="list2" value="${list2}," />
          </c:if>

          <c:set var="list2" value="${list2}${item}" />
        </c:if>
      </c:forEach>

      <c:set var="list" value="${list2}" scope="session" />

      <c:remove var="list2" />
    </c:when>
  </c:choose>
</c:if>

<html>
  <head>
    <title>Updatable Collections</title>
  </head>

  <body>
    <table border="0">
      <form method="post">
        <tr bgcolor="blue">
          <td colspan="2">
            <font color="white">Updatable Collections</font>
          </td>
        </tr>

        <tr>
          <td valign="top">
            <select NAME="choice" SIZE="5" width="20">
              <c:forEach var="item" items="${list}">
                <option>
                  <c:out value="${item}" />
                </option>
              </c:forEach>
            </select>
          </td>

          <td valign="top">Enter a item to add or remove.
          <br />

          <input width="20" maxwidth="20" name="item" size="20" />

          <br />

          <input type="submit" name="add" value="Add" />

          <input type="submit" name="remove" value="Remove" />
          </td>
        </tr>
      </form>
    </table>
  </body>
</html>