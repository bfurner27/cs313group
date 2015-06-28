<%-- 
    Document   : index
    Created on : Jun 15, 2015, 4:32:59 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Team Login</h1>
        <%
            if (session.getAttribute("failed") != null)
            {
                String isFailed = session.getAttribute("failed").toString();
                if (isFailed.equals("true")) {
                    out.println("<h1>Ultimate Failure</h1>");
                    out.println("<h1>" + session.getAttribute("path").toString() + "</h1>");
                }
            }
            
            
        %>
        <form action="LoginHandler" method="POST">
            <label>Username: </label><br />
            <input type="text" name="user" /> <br />
            <label>Password: </label> <br />
            <input type="password" name="pass" /> <br />
            <button type="submit">Log In</button> 
        </form>
        <a href="Login">Login to facebook</a>
    </body>
</html>
