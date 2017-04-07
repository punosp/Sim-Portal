<%-- 
    Document   : stu_main
    Created on : 11 Jul, 2015, 1:05:31 PM
    Author     : sonu1212
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="SHORTCUT ICON" HREF="images/logo.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            p#q1 {position: absolute;left: 1200px;top: 0px;}
            p#q2 {position: absolute;left: 1000px;top: 0px;}
            a:link {color: blue;text-decoration: none}
            a:visited {color: blue;text-decoration: none}
            a:hover {color: green}
            
            
        </style>
        <title>FAC_MAIN</title>
       
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
    padding:0px"><h3 style="text-align: center">Welcome <%=uname%></h3><p id="q1"><a href="Logout_f.jsp">Sign Out</a></p><p id="q2"><a href="passchange.jsp">Change Password</a></p></div><div style="position: absolute;top:100px;background-color: lightgray;height:350px;width:428px;margin-right: 10px;margin-left: 15px">
        <a href="stu_select.jsp"><p style="text-align: center;font-family: algerian;">Attendance</p>
            <image src="images/class.png" alt="HTML tutorial" style="width:428px;height:300px;border:0;">
        </a>
           
    </div><div style="position: absolute;top: 100px;background-color: lightgreen;height:350px;width:428px;left:458px">
        <a href="stufill_atten.jsp"><p style="text-align: center;font-family: algerian;">Time Table</p>
            <image src="images/atten.png" alt="HTML tutorial" style="width:428px;height:300px;border:0">
        </a>
        
        
    </div><div style="position: absolute;top: 100px;background-color:lightblue;height:350px;width:428px;left: 906px">
        <a href="http://localhost:23755/LMS/home.html"><p style="text-align: center;font-family: algerian">Library</p>
            <image src="images/lib.png" alt="HTML tutorial" style="width:428px;height:300px;border:0">
        </a>
        
        
    </div><div style="position: absolute;background-color: lightsalmon;height:350px;width:428px;left: 10px;top: 480px">
        
        <a href="http://www.dituniversity.edu.in/newsdetail.aspx?nid=454&mpgid=8&1pgid=224"><p style="text-align: center;font-family: algerian">News</p>
            <image src="images/news.png" alt="HTML tutorial" style="width:428px;height:300px;border:0">
        </a>
        
        
    </div><div style="position:absolute;left:700px;top:500px;width:300px;height: 300px">
        
        <ul style="font-family: algerian;text-align: center;color: green;line-height: 30px;padding-top: 50px">
            <li>100% attendance is recommended</li><br><br>
            <li>75% attendance is necessary to appear in Examination</li>
            
        </ul>
    
    </div><div style="position: absolute;top:880px;width: 100%;background-color:gray">
          <h5 style="font-family: algerian;color:blue"><marquee behaviour="slide" direction="right">&copy; DIT University, India 2015. All Rights Reserved</marquee></h5>
            
                <h4 style="font-family: algerian;color:blue;text-align: center">English(US)</h4>
       
    </div>
    </body>
</html>
