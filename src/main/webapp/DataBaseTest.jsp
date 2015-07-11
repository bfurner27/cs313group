<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

<%@page import="WishList.Controller.ConcreteWishListController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="WishList.Storage.WishList"%>
<%@page import="java.util.List"%>
<%@page import="WishList.Controller.Interfaces.WishListControllerFactory"%>
<%@page import="WishList.Controller.Interfaces.WishListController"%>
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
            WishListController wlc = new ConcreteWishListController();
            List<WishList> lists = wlc.getWishLists("schuylerrs");
            
            for (WishList list : lists) {
                System.out.println(list.getName());
            }
            
            pageContext.setAttribute("lists", lists);
        %>
        
        <c:forEach var="list" items="${lists}">
            ${list.getName()} <br/>
        </c:forEach>
    </body>
</html>