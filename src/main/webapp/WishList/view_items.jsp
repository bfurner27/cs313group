<%-- 
    Document   : index
    Created on : Jun 29, 2015, 7:52:12 AM
    Author     : kim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession(false);
    session=request.getSession();
    if(session.getAttribute("id") == null)
    {
       // response.sendRedirect("WishList/index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>My Wishlist</title>
        
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
     <link rel="stylesheet" href="WishList/css/main.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

<div id="status"></div>
      <div id="wrapper">
        <h1>My Wishlist</h1>
        <div id="navBorder"
        <ul class="nav nav-pills">
          <li role="presentation" ><a href="../UserHomePage">My List</a></li>
          <li role="presentation" class="active"><a href="../Friends">Friends</a></li>
        </ul>
                     <ul class="nav nav-pills pull-right">
          Welcome ${user.name}!
          <img id="profilePhoto" src="${user.photoURL}">
        </ul>
        </div>
        <div class="emptySpace"></div>
        <div class="row">
            <div class="col-md-12">

                        <div class="emptySpaceLittle"></div>
            <c:forEach var="item" items="${items}"> 
            <ul class="media-list">
              <li class="media">
                <div class="media-left media-middle">
                  <a href="#">
                    <img width="64" height="64" class="media-object" src="${item.getImageUrl()}" alt="...">
                  </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading"><a href="${item.getUrl()}">${item.getTitle()}</a><button type="button" class="btn btn-danger btn-xs pull-right" aria-label="..."
                                                                                        onclick="location.href='WishList/addList.jsp'">
                      <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                    </button>
                  </h4>
                  ${item.getDescrition()}
                </div>
              </li>
            </ul>
            </c:forEach> 
                                        <button type="button" class="btn btn-primary pull-right" aria-label="Left Align" onclick="location.href='../RequestToCreateNewItem?listId='"${item.getId()}>
                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
            </div>

          </div>
      </div>
<div id="servletLoaded">false</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>