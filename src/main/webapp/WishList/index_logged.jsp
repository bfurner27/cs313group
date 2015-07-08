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
        response.sendRedirect("WishList/index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>
        
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
      <script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
     alert('connected!');
     // testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '{your-app-id}',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.2' // use version 2.2
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<div id="status"></div>
      <div id="wrapper">
        <h1>My Wishlist</h1>
        <div id="navBorder"
        <ul class="nav nav-pills">
          <li role="presentation" class="active"><a href="#">Home</a></li>
          <li role="presentation"><a href="#">My List</a></li>
          <li role="presentation"><a href="#">Friends</a></li>
        </ul>
                     <ul class="nav nav-pills pull-right">
          Welcome, ${sessionScope.id}!
        </ul>
        </div>
        <div class="emptySpace"></div>
        <div class="row">
            <div class="col-md-7">
                <button type="button" class="btn btn-primary">
                    Post to Facebook
                </button>
                <button type="button" class="btn btn-primary pull-right" aria-label="Left Align">
                  <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
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
                    <h4 class="media-heading"><a href="#">${item.getTitle()}</a><button type="button" class="btn btn-danger btn-xs pull-right" aria-label="...">
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
                
                <div id="espace">                <button type="button" class="btn btn-primary pull-right" aria-label="Left Align">
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