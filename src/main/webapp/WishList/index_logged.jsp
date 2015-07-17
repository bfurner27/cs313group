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
        <div id="fb-root"></div>
        <script>
            (function(d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4&appId=482401615251513";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>

<div id="status"></div>
      <div id="wrapper">
        <h1>My Wishlist</h1>
        <div id="navBorder"
        <ul class="nav nav-pills">
          <li role="presentation" class="active"><a href="www.aple.com">My List</a></li>
          <li role="presentation"><a href="../Friends">Friends</a></li>
        </ul>
                     <ul class="nav nav-pills pull-right">
          Welcome ${user.name}!
          <img id="profilePhoto" src="${user.photoURL}">
        </ul>
        </div>
        <div class="emptySpace"></div>
        <div class="row">
            <div class="col-md-7">
        <!-- Facebook link so that they can post their page to Facebook -->
        <p>${listURL}</p>
        <div class="fb-share-button" data-href="${listURL}" 
            data-layout="button_count"></div>
                <button type="button" class="btn btn-primary pull-right" aria-label="Left Align" onclick="location.href='RequestToCreateNewItem?listId=${initialListId}'">
                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
                        <div class="emptySpaceLittle2"></div>
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
                                                                                        >
                      <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                    </button>
                  </h4>
                  ${item.getDescrition()}
                </div>
              </li>
            </ul>
            </c:forEach> 
            </div>
            
            <div class="col-md-5">
                
                <div id="espace">                <button type="button" onclick="location.href='WishList/addList.jsp'" class="btn btn-primary pull-right" aria-label="Left Align">
                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
                </div>
                <c:forEach var="item" items="${items2}"> 
            <ul class="media-list">
              <li class="media">
                <div class="media-body">
                    <h4 class="media-heading"><a href="LoadFromListServlet?id=${item.getId()}">${item.getDisplayName()}</a><button type="button" class="btn btn-danger btn-xs pull-right" aria-label="...">
                      <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                    </button></h4>
                  ${item.getDescription()}
                </div>
              </li>
            </ul>
                </c:forEach>
                
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