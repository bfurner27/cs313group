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
        <a href="DisplayPosts">Go Directly to Post Page</a>
        <form action="CreatePost" method="POST">
            <label>Title: </label><input type="text" name="title" /><br />
            <input type="hidden" name="username" value="${username}" />
            <label>Post: </label><br />
            <textarea type="text" name="text" /> </textarea><br />
            <button type="submit">Add Post</button> 
        </form>
        <a href="LogoutHandler" >Logout</a>
    </body>
</html>
