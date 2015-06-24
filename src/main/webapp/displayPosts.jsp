<%-- 
    Document   : displayPosts
    Created on : Jun 23, 2015, 10:10:59 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post's Page</title>
    </head>
    <body>
        <h1>Post Forum</h1>
        <a href="postPage.jsp">Return to Post Page</a><br />
        <c:forEach var="post" items="${posts}" >
            <strong>${post.user}</strong><br />
            <b>${post.title}<br /></b>
            ${post.content}<br/>
            ${post.date}<br/>
            <br />
        </c:forEach>
        
        
    </body>
</html>
