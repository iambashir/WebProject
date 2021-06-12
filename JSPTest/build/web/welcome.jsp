<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome <%= request.getAttribute("name")%> </h1>
        <h1>Password <%= request.getAttribute("pass")%> </h1>

    </body>
</html>
