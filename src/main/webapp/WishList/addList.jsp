<%-- 
    Document   : addList
    Created on : Jul 8, 2015, 4:14:05 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist</title>
        
        <!-- jquery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        
        
        
        <!-- validation javascript -->
        <script src="javascript/validateAddList.js" ></script>

         <link rel="stylesheet" href="css/main.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">
        <h1>Create a New List</h1>
        <form action="../CreateNewList" method="POST" onsubmit="return validateAddList()">
            <!-- get name -->
            <div class="form-group">
            <label for="listNameId">*List Name</label>
            <input type="text" class="form-control" name="listName" id="listNameId" onblur="validateName()" /><br />
            
            <!-- get picture url -->
            <label>Wishlist Picture URL</label>
            <input type="text" class="form-control" name="pictureURL" id="pURL" /><br />
            
            <!-- get description -->
            <label for="listDesc">Description</label>
            <textarea type="text" class="form-control" name="description" id="listDesc" ></textarea><br />
            
            <!-- get permissions -->
            <label>*Public List Permissions</label><br />
            <label class="radio-inline">
            <input type="radio" name="permission" value="true" id="yesPermissions" checked="true"/>
            Yes</label>
            <label class="radio-inline">
            <input type="radio" name="permission" value="false" id="noPermissions"/>
            No</label><br />
            </div>
            
            <!-- submit form -->
            <button type="submit" class="btn btn-primary">Create List</button><br />
               
        </form>
        </div>
    </body>
</html>
