<%-- 
    Document   : addItem
    Created on : Jul 10, 2015, 5:43:05 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="WishList/javascript/validateAddItem.js" ></script>

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
        <h1>Insert Item</h1>
        <form action="CreateNewItem" method="POST" onsubmit="return validateAddItem()">
           
            <div class="form-group">
            <!-- get item name -->
            <label for="nameId">*Name</label>
            <input type="text" class="form-control" name="name" id="nameId" onblur="validateName()" /><br />
            
            <!-- get price of item -->
            <label for="priceId">*Price $</label><br />
            <label hidden='hidden' id='invalidCharacter' style='color: red'>Invalid Format: must be digits of form 7.35</label>
            <label hidden='hidden' id='invalidFormat' style='color: red'>Invalid Format: must be of form 17.35</label>
            <label hidden="hidden" id="invalidDollarSign" style="color: red">Invalid Format: don&#39t include &#39&#36&#39 ex:7.35</label>
            <input type="text" class="form-control" name="price" id="priceId" onblur="validatePrice()" style="width: 25%"/><br />
            
            <!-- get description of item -->
            <label for="descriptionId">Description</label>
            <input type="text" class="form-control" name="description" id="descriptionId" /><br />
            
            <!-- get picture url of the item -->
            <label for="pictureURLId" id="pictureURLLabelId" >Picture URL</label>
            <input type="text" class="form-control" name="pictureURL" id="pictureURLId" onblur="displayPictureURL()"/><br />
            
            <!-- get sales link of the item -->
            <label for="salesLinkId">Link to Sales Site</label>
            <input type="text" class="form-control" name="salesLink" id="salesLinkId" /><br />
            
            <!-- sends the list id -->
            <input type="hidden" name="listId" id="wishlistId" value="${listId}" />
            
            <!-- submit form -->
            <button type="submit" class="btn btn-primary">Add Item</button><br />   
        </form>
        </div>
    </body>
</html>
