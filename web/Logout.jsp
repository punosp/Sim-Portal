<%-- 
    Document   : Logout.jsp
    Created on : 17 Jul, 2015, 12:19:04 AM
    Author     : sonu1212
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="SHORTCUT ICON" HREF="images/logo.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>STUDENT LOGOUT</title>
        <style>
            b {color:red}
            </style>
           
    </head>
   
  <%
       
        
         if(session.isNew()) 
          {
             
          }
         else
         {
        
         
        session.invalidate();
         }
         
         

  
         
        %>
        
        
      
        <jsp:include page="stu_login.html"/>
        
        
    </body>
</html>
