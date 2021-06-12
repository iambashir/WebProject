
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>ServletConfig Interface</h3>
        <div>An object of ServletConfig is created by the web container for each servlet. This object can be used to get configuration information from web.xml file.

            If the configuration information is modified from the web.xml file, we don't need to change the servlet. So it is easier to manage the web application if any specific content is modified from time to time.
        </div>
        <h3>Advantage of ServletConfig</h3>

        The core advantage of ServletConfig is that you don't need to edit the servlet file if information is modified from the web.xml file.

        <br></br><h3>Methods of ServletConfig interface</h3>
        <ol>
            <li><b>public String getInitParameter(String name):</b>Returns the parameter value for the specified parameter name.</li>
            <li><b>public Enumeration getInitParameterNames():</b>Returns an enumeration of all the initialization parameter names.</li>
            <li><b>public String getServletName():</b>Returns the name of the servlet.</li>
            <li><b>public ServletContext getServletContext():</b>Returns an object of ServletContext.</li>
        </ol>
        <h3>How to get the object of ServletConfig</h3>

        <ol><li><b>getServletConfig()</b> method of Servlet interface returns the object of ServletConfig.</li></ol>
        <a href="demo_servlet_config">Example</a>



        <h3>ServletContext Interface</h3>

        <div>An object of ServletContext is created by the web container at time of deploying the project. This object can be used to get configuration information from web.xml file. There is only one ServletContext object per web application.

            If any information is shared to many servlet, it is better to provide it from the web.xml file using the &lt;context-param&gt; element.</div>

        <h3>Advantage of ServletContext</h3>

        Easy to maintain if any information is shared to all the servlet, it is better to make it available for all the servlet. We provide this information from the web.xml file, so if the information is changed, we don't need to modify the servlet. Thus it removes maintenance problem.

        <h3>Usage of ServletContext Interface</h3>

        There can be a lot of usage of ServletContext object. Some of them are as follows:
        <ol>
            <li>The object of ServletContext provides an interface between the container and servlet.</li>
            <li>The ServletContext object can be used to get configuration information from the web.xml file.</li>
            <li>The ServletContext object can be used to set, get or remove attribute from the web.xml file.</li>
            <li>The ServletContext object can be used to provide inter-application communication.</li>
        </ol>
        <h3>Commonly used methods of ServletContext interface</h3>

        There is given some commonly used methods of ServletContext interface.
        <ol>
            <li>public String getInitParameter(String name):Returns the parameter value for the specified parameter name.</li>
            <li>public Enumeration getInitParameterNames():Returns the names of the context's initialization parameters.</li>
            <li>public void setAttribute(String name,Object object):sets the given object in the application scope.</li>
            <li>public Object getAttribute(String name):Returns the attribute for the specified name.</li>
            <li>public Enumeration getInitParameterNames():Returns the names of the context's initialization parameters as an Enumeration of String objects.</li>
            <li>public void removeAttribute(String name):Removes the attribute with the given name from the servlet context.</li>
        </ol>
        <h3>How to get the object of ServletContext interface</h3>
        <ol>
            <li>getServletContext() method of ServletConfig interface returns the object of ServletContext.</li>
            <li>getServletContext() method of GenericServlet class returns the object of ServletContext.</li>
        </ol>
        <a href="demo_servlet_context">Example</a>
    </body>
</html>
