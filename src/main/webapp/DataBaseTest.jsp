<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

<%@page import="WishList.Storage.Item"%>
<%@page import="WishList.Controller.ConcreteItemController"%>
<%@page import="WishList.Controller.Interfaces.ItemController"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
    <h1>This should Work! MK 6</h1>
        <%
            WishListController wlc = new ConcreteWishListController();
        %>
        controller created...<br/>
        <%
            List<WishList> lists = wlc.getWishLists("schuylerrs");
        %>
        query finished...<br/>
        <%  
            pageContext.setAttribute("lists", lists);
        %>
        ${lists.size()} lists <br/>
        <c:forEach var="list" items="${lists}">
            ${list.getName()} <br/>
        </c:forEach>
            
            
        <%
            ItemController ic = new ConcreteItemController();
        %>
        Item controller created...<br/>
        <%
            List<Item> items = ic.getItems(lists.get(1).getId());
        %>
        Item query finished...<br/>
        <%  
            pageContext.setAttribute("items", items);
        %>
        Items from list #${lists.get(1).getId()}<br/>
        <c:forEach var="item" items="${items}">
            ${item.getDisplayName()} <br/>
        </c:forEach>
    </body>
</html>
