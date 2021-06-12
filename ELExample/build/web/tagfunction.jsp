<%@ taglib prefix="projsp" uri="/WEB-INF/tlds/taglib"%>
<%--<%@page isELIgnored="true" %>--%>
<html>
    <head>
        <title>Using functions to preprocess params</title>
    </head>
    <body>
        <h2>Using functions to preprocess params</h2>
        Creating a bean and setting its string property to 
        ${'${'}projsp:upper('a string')}...<p/>
        <jsp:useBean id="sb" class="com.apress.projsp.SourceBean"/>
        <jsp:setProperty name="sb" property="string"
                         value="${projsp:upper('we love our country')}" />
        Printing value of string property: ${'${'}sb.string} = ${sb.string}
        <p>
            ${projsp:greet()}
        <p>
           

    </body>
</html>