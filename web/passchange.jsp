<%-- 
    Document   : passchange
    Created on : 24 Aug, 2015, 11:55:52 PM
    Author     : sonu1212
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="SHORTCUT ICON" HREF="images/logo.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CHANGE PASSWORD</title>
    </head>
    <body style="background-color:gainsboro;margin: 0px">
         <% 
String uname=(String)session.getAttribute("name");
String uid=(String)session.getAttribute("id");
session.setAttribute("name",uname);
session.setAttribute("id",uid);

 if(uname == null) {
      response.sendRedirect("Logout_f.jsp");
   }
%>
        <div style="background-color:graytext; clear:both;
    margin: 0px;position:absolute;width:100%;
    padding:0px"><h3 style="text-align: center">Welcome <%=uname%></h3></div>
    <div style="position: absolute;top:880px;width: 100%;background-color:gray">
          <h5 style="font-family: algerian;color:blue"><marquee behaviour="slide" direction="right">&copy; DIT University, India 2015. All Rights Reserved</marquee></h5>
            
                <h4 style="font-family: algerian;color:blue;text-align: center">English(US)</h4>
       
    </div>
    </body>
</html>
