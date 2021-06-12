<% session.setAttribute("username", "");%>
<% session.invalidate();%>
<jsp:forward page="index.jsp"/>

