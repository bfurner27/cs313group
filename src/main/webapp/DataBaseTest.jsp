<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

<%@page import="WishList.Controller.MockControllers.MockWishListController"%>
<%@page import="WishList.Controller.MockControllers.MockItemController"%>
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
    <h2> WishList get testing</h2>
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
            
    <h2> WishList add testing</h2>
    <%
        WishListController mwlc = new MockWishListController();
        for (WishList list : mwlc.getWishLists("schuylerrs")) {
            wlc.addWishList(list);
        }
    %>
    query finished...<br/>
    <%  
        lists = wlc.getWishLists("schuylerrs");
        pageContext.setAttribute("lists", lists);
    %>
    ${lists.size()} lists after adding <br/>
    <c:forEach var="list" items="${lists}">
        ${list.getName()} <br/>
    </c:forEach>
        
    <h2> WishList remove testing</h2>
    <%
        for (WishList list : mwlc.getWishLists("schuylerrs")) {
            wlc.removeWishList(list.getId());
        }
    %>
    query finished...<br/>
    <%  
        lists = wlc.getWishLists("schuylerrs");
        pageContext.setAttribute("lists", lists);
    %>
    ${lists.size()} lists after adding <br/>
    <c:forEach var="list" items="${lists}">
        ${list.getName()} <br/>
    </c:forEach>
            
    <h2> Item get testing</h2>        
        <%
            ItemController ic = new ConcreteItemController();
        %>
        Item controller created...<br/>
        <%
            List<Item> items = ic.getItems(5);
        %>
        Item query finished...<br/>
        <%  
            pageContext.setAttribute("items", items);
        %>
        Items from list #5<br/>
        <c:forEach var="item" items="${items}">
            ${item.getDisplayName()} <br/>
        </c:forEach>
    
    <h2> Item add testing</h2>
    <%
        MockItemController mic = new MockItemController();
        for (Item item : mic.getItems(5)) {
            ic.addItem(item);
        }
    %>
    Items added...<br/>
    <%
        items = ic.getItems(5);
    %>
    Item query finished...<br/>
    <%  
        pageContext.setAttribute("items", items);
    %>
    Items from list #2 after adding<br/>
    <c:forEach var="item" items="${items}">
        ${item.getDisplayName()} <br/>
    </c:forEach>
            
        
    <h2> Item delete testing</h2>
    <%
        int count = 0;
        for (Item item : items) {
            ic.removeItem(item.getId());
            if (count >= 3)
                break;
            count++;
        }
    %>
    Items added...<br/>
    <%
        items = ic.getItems(5);
    %>
    Item query finished...<br/>
    <%  
        pageContext.setAttribute("items", items);
    %>
    Items from list #5 after deleting<br/>
    <c:forEach var="item" items="${items}">
        ${item.getDisplayName()} <br/>
    </c:forEach>
            
    </body>
</html>
