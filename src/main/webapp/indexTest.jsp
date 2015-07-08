<%-- 
    Document   : index
    Created on : Jun 15, 2015, 4:32:59 PM
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1>Team Login</h1>
        <%
            if (session.getAttribute("failed") != null)
            {
                String isFailed = session.getAttribute("failed").toString();
                if (isFailed.equals("true")) {
                    out.println("<h1>Ultimate Failure</h1>");
                    out.println("<h1>" + session.getAttribute("path").toString() + "</h1>");
                }
            }
            
            
        %>
        <!-- add the href to the actual page that we are looking at -->
        <div class="fb-share-button" data-href="#" 
            data-layout="button_count"></div>
        <a href="Login">Login to facebook</a>
    </body>
</html>
