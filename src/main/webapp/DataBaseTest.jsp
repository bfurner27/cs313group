<%-- 
    Document   : LocalVariablesTest
    Created on : Jul 11, 2015, 2:20:51 PM
    Author     : Schuyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String dbHost = System.getenv("$OPENSHIFT_MYSQL_DB_HOST");
            String dbPort = System.getenv("$OPENSHIFT_MYSQL_DB_PORT");
            
            pageContext.setAttribute("host", dbHost);
            pageContext.setAttribute("port", dbPort);
        %>
        
        ${host} <br/>
        ${port} <br/>
    </body>
</html>

