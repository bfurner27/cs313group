<%-- 
    Document   : userPage
    Created on : Jul 6, 2015, 12:38:25 PM
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
        photo URL: ${user.photoURL} <br /> <br />
        
        
        <c:forEach var="friend" items="${user.friends}">
            ${friend.name} ${friend.pictureURL}<br />
        </c:forEach>
    </body>
</html>
