<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

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
        <h1>This should Work! MK 4</h1>
        <%
            String DB_URL = null;

            //  Database credentials
            String USER;
            String PASS;
            String dbHost = System.getenv("$OPENSHIFT_MYSQL_DB_HOST");
            
            if (dbHost == null) {
                DB_URL = "jdbc:mysql://localhost:3306/wishlist";
                USER = "root";
                PASS = "";
            }
            else {
                DB_URL = "jdbc:mysql://" + dbHost + ":" 
                    + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/"
                    + System.getenv("OPENSHIFT_APP_NAME");
                
                USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            }
        
            
            Connection conn = null;
            PreparedStatement  stmt = null;
            List<WishList> result = new ArrayList<WishList>();

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            String sql;
            sql = "SELECT * FROM wishlist WHERE owner = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, "schuylerrs");
            ResultSet rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            while(rs.next()){
                result.add(new WishList(rs.getString("name"), rs.getString("description"), rs.getString("owner"), rs.getBoolean("is_public"), rs.getString("imageurl")));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            
            //WishListController wlc = new ConcreteWishListController();
        %>
        controller created...<br/>
        <%
            //List<WishList> lists = wlc.getWishLists("schuylerrs");
        %>
        query finished...<br/>
        <%  
            pageContext.setAttribute("lists", result);
        %>
        ${lists.size()} lists <br/>
        <c:forEach var="list" items="${lists}">
            ${list.getName()} <br/>
        </c:forEach>
    </body>
</html>
