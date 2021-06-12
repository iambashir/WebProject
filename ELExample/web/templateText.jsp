<%--<%@ page isELIgnored="true" %>--%>
<html>
  <head>
      <title>EL and Template Text</title>
  </head>
  <body>
    <h2>EL and Template Text</h2>
    ${empty param.firstname}
    <table border="1">
      <tr>
        <td colspan="2">Hello ${param['firstname']}</td>
        <td colspan="2">Hello <%=request.getParameter("firstname") %></td>
      </tr>
      <tr>
        <form action="templateText.jsp" method="post">
          <td><input type="text" name="firstname"></td>
          <td><input type="submit"></td>
        </form>
      </tr>
    </table>
  </body>
</html>
