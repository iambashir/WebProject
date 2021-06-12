<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Implicit Object</title>
    </head>
    <body>
        <%-- out object example --%>
        <p><strong>out: instance of javax.servlet.jsp.JspWriter</strong> used to output content to be sent in client response.</p>
        <strong>Current Time is</strong>: <% out.print(new Date());%><br><br>

        <%-- request object example --%>
        <p><strong>request: instance of javax.servlet.http.HttpServletRequest</strong>, used to get the request parameters, cookies, request attributes, session, header information and other details about client request.</p>
        <strong>Request User-Agent</strong>: <%=request.getHeader("User-Agent")%><br><br>
        <%=request.getParameter("uname")%>

        <%-- response object example --%>
        <p><strong>response: instance of javax.servlet.http.HttpServletResponse</strong>, used to set content type, character encoding, header information in response, adding cookies to response and redirecting the request to other resource.</p>
        <%response.addCookie(new Cookie("Test", "Value"));%>
        <code>response.sendRedirect("http://www.google.com"); </code>

        <%-- config object example --%>
        <p><strong>config: instance of javax.servlet.ServletConfig</strong>, used to get the JSP init params configured in deployment descriptor.</p>
        <strong>User init param value</strong>:
        <%=config.getInitParameter("User")%><br><br>

        <%-- application object example --%>
        <p><strong>application: instance of javax.servlet.ServletContext</strong>,used to get the context information and attributes in JSP. This object can be used to get initialization parameter from configuaration file (web.xml). It can also be used to get, set or remove attribute from the application scope.
This initialization parameter can be used by all jsp pages.</p>
        <strong>User context param value</strong>:<%=application.getInitParameter("User")%><br><br>

        <%-- session object example --%>
        <p><strong>session: instance of javax.servlet.http.HttpSession</strong>. Whenever we request a JSP page, container automatically creates a session for the JSP in the service method.</p>
        <strong>User Session ID</strong>:<%=session.getId()%><br><br>
        <code>session.setAttribute("user",name); String name=(String)session.getAttribute("user");</code>
        
        <%-- pageContext object example --%>
        <p><strong>pageContext: instance of javax.servlet.jsp.PageContext</strong> abstract class. We can use pageContext to get and set attributes with different scopes(page,request,session,application) and to forward request to other resources. pageContext object also hold reference to other implicit object.</p>
        <% pageContext.setAttribute("Test", "Test Value");%>
        <strong>PageContext attribute</strong>: {Name="Test",Value="<%=pageContext.getAttribute("Test")%>"}<br><br>

        <%-- page object example --%>
        <p><strong>page: instance of java.lang.Throwable</strong> class and used to provide exception details in JSP error pages. We can’t use this object in normal JSP pages and it’s available only in JSP error pages.</p>
        <strong>Generated Servlet Name</strong>:<%=page.getClass().getName()%>
    </body>
</html>
