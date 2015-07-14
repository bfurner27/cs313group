<%-- 
    Document   : DataBaseTest
    Created on : Jul 11, 2015, 1:05:11 PM
    Author     : Schuyler
--%>

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
        <h1>Hello World!</h1>
        <%
            WishListController wlc = new ConcreteWishListController();
            List<WishList> lists = wlc.getWishLists("schuylerrs");
            
                String DB_URL = "jdbc:mysql://" 
                    + System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" 
                    + System.getenv("OPENSHIFT_MYSQL_DB_PORT") + "/"
                    + System.getenv("OPENSHIFT_APP_NAME");
                String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = null;
                Statement stmt = null;
                
            //STEP 3: Open a connection
                %>
                Connecting to database...<br/>
            <%
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            DB_URL = "jdbc:mysql://localhost:3306/wishlist";
//            USER = "root";
//            PASS = "";
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            %>
                Creating statement... <br/>
            <%
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM wishlist";
            ResultSet rs = stmt.executeQuery(sql);
                
            while(rs.next()){
                %>
                ${rs.getString("name")}
                <%
            }
            
            pageContext.setAttribute("lists", lists);
        %>
        
        <c:forEach var="list" items="${lists}">
            ${list.getName()} <br/>
        </c:forEach>
    </body>
</html>
