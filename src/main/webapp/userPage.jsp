<%-- 
    Document   : userPage
    Created on : Jun 27, 2015, 11:06:20 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.name}'s Page</title>
    </head>
    <body>
        <h1>Welcome to ${user.name}'s Home Page</h1>
        Here is the users information<br />
        Name: ${user.name} <br/>
        facebookId: ${user.userId} <br />
        photo URL: ${user.photoURL} <br />
    </body>
</html>
