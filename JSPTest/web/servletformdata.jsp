<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color: #dbdbdb;
            }
            div.form{
                background-color: white;
                border: 1px solid black;
                padding: 20px;
                margin: auto;
                width: 230px;
                height: 150px;
                -webkit-box-shadow: 0 10px 6px -6px #777;
                -moz-box-shadow: 0 10px 6px -6px #777;
                box-shadow: 0 10px 6px -6px #777;
            }
            div.form:hover{
                box-shadow: 0 10px 10px -5px;
            }
        </style>
    </head>
    <body>
        <div class="form">
            <form name="form1" action="handleFormData" method="post">
                <table border="1" width="50">
                    <thead>
                        <tr>
                            <th colspan="2">Login Here</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><input type="text" name="name" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit" /></td>
                            <td><input type="reset" value="Reset" /></td>
                        </tr>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
