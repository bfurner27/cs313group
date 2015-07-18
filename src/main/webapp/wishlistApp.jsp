<%-- 
    Document   : wishlistApp
    Created on : Jul 18, 2015, 3:36:37 PM
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
        <div class="jumbotron" style="width: 90%; margin: 0 auto; margin-top: 20px">
            <h1 style="text-align:center; margin-top: 5px; margin-bottom: 10px"> Facebook Wishlist </h1>
            <div style="width: 90%; margin: 0 auto;">
                <div id="myCarousel" class="carousel slide" data-ride="carousel" style="">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="images/MyList.JPG" alt="Share All The Things You Want" title="Share All The Things You Want">
                            <div class="carousel-caption">
                                <h3 style="color: black">What do you want?</h3>
                                <p style="color: black">Share All The Things You Want With Friends On Facebook.</p>
                            </div>
                        </div>

                        <div class="item">
                            <img src="images/Lists.JPG" alt="Create Multiple Wishlists" title="Create Multiple Wishlists">
                            <div class="carousel-caption">
                                <h3 style="color: black">More Than One</h3>
                                <p style="color: black">Make list for whatever you want (Christmas, Birthday, Wedding).</p>
                            </div>
                        </div>

                        <div class="item">
                            <img src="images/Friends.JPG" alt="View Friends Wishlists" title="View Friends Wishlists">
                            <div class="carousel-caption">
                                <h3 style="color: black">Share With Friends</h3>
                                <p style="color: black">See lists that your friends have made.</p>
                            </div>
                        </div>

                        <div class="item">
                            <img src="images/FriendsList.jpg" alt="View Friends Wishlists" title="View Friends Wishlists">
                            <div class="carousel-caption">
                                <h3 style="color: black">See What Friends Want</h3>
                                <p style="color: black">View your friends wishlist and claim items you are going to get.</p>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <h2>Description</h2>
                <p style="margin-left: 30px">
                    Is your birthday or Christmas coming up? Is everyone in your family asking you what you want?<br/>
                    This is the app for you!<br/>
                    This app allows you to put together a list of all the things you want (or don't want... if thats the kind of thing you do)
                    into one place then share it on your Facebook wall for your friends and family to see. They will be able to mark things as
                    claimed so that other people wont go and buy you the same thing twice.
                </p>
                <a href="http://javagroup-cs313group.rhcloud.com/" style="font-size: 30px">Try It Now!</a>
            </div>
        </div>
        <div class="jumbotron" style="width: 90%; margin: 0 auto; margin-top: 15px">
            <div style="width: 90%; margin: 0 auto;">
                <h2>Features</h2>
                <ul style="font-size: 20px">
                    <li>Create Multiple Lists</li>
                    <li>Share Your List on Facebook</li>
                    <li>View Friends Lists</li>
                    <li>Claim Items From Friends Lists <br/> (So No One Else Goes Out And Gets Them That)</li>
                    <li>Edit Your Items</li>
                    <li>Add Items To Your List</li>
                    <li>Add Custom Images For Each Item</li>
                </ul>
            </div>
        </div>
        <div class="jumbotron" style="width: 90%; margin: 0 auto; margin-top: 15px">
            <div style="width: 90%; margin: 0 auto;">
                <h2>Coming Soon</h2>
                <ul style="font-size: 20px">
                    <li>Custom Images For Lists</li>
                    <li>Arrange Items In List How You Want</li>
                    <li>Sort Lists/Items In A List</li>
                    <li>Filter Items Based On:
                        <ul>
                            <li>Date Added</li>
                            <li>Price</li>
                            <li>Name</li>
                            <li>Importance</li>
                            <li>Claimed/Unclaimed</li>
                        </ul>
                    </li>
                    <li>Choose Which Friends Can View Your List</li>
                </ul>
            </div>
        </div>

    </body>
</html>
