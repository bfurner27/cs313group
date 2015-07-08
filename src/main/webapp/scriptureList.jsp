<%-- 
    Document   : scriptureList
    Created on : Jun 15, 2015, 1:02:02 PM
    Author     : Benjamin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture Display</title>
    </head>
    <body>
        
        <div> 
            Scriptures:<br /><br />
            <c:forEach var="scripture" items="${scriptures}">

                <strong>${scripture.book}</strong> ${scripture.chapter}:${scripture.verse}<br />

            </c:forEach>
        </div>
    </body>
</html>
