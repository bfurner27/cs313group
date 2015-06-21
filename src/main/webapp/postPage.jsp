<%-- 
    Document   : success
    Created on : Jun 15, 2015, 4:16:52 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome ${username}</h1>
        <form action="CreatePost" method="POST">
            <label>Post: </label><br />
            <textarea type="text" name="user" /> </textarea><br />
            <button type="submit">Log In</button> 
        </form>
        <a href="LogoutHandler" >Logout</a>
    </body>
</html>
