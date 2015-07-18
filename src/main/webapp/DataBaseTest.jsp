<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

<%@page import="WishList.Controller.Factories.ItemControllerFactory"%>
<%@page import="WishList.Controller.Factories.WishListControllerFactory"%>
<%@page import="WishList.Controller.Interfaces.WishListController"%>
<%@page import="WishList.Storage.Item"%>
<%@page import="WishList.Controller.Interfaces.ItemController"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="WishList.Storage.WishList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>This should Work! MK 6</h1>
    <h2> WishList get testing</h2>
        <%
            ItemController ic = new ItemControllerFactory().getItemController();
        %>
        controller created...<br/>
        <%
            List<Item> items = ic.getItems(79);
        %>
        query finished...<br/>
        <%  
            pageContext.setAttribute("lists", items);
        %>
        ${lists.size()} lists <br/>
        <c:forEach var="list" items="${lists}">
            ${list.isClaimed()} <br/>
        </c:forEach>
            
        <%
            Item item = items.get(0);
            item.setClaimed(true);
            ic.updateItem(item);
            
            items = ic.getItems(79);
            pageContext.setAttribute("lists", items);
        %>
        <c:forEach var="list" items="${lists}">
            ${list.isClaimed()} <br/>
        </c:forEach>
    </body>
</html>
