<%-- 
    Document   : stu_select
    Created on : 20 Jul, 2015, 9:44:37 AM
    Author     : sonu1212
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="SHORTCUT ICON" HREF="images/logo.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Select Class</title>
        <style>
            p#q1 {position: absolute;left: 1200px;top: 0px;}
            a:link {color: blue;text-decoration: none}
            a:visited {color: blue;text-decoration: none}
            a:hover {color: green}
            
            select {background-color: graytext;-webkit-appearance: button;
    -moz-appearance: button;
    -webkit-user-select: none;
    -moz-user-select: none;
    -webkit-padding-end: 20px;
    -moz-padding-end: 20px;
    -webkit-padding-start: 2px;
    -moz-padding-start: 2px;
     border: 1px solid #AAA;
    border-radius: 2px;
    box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
    color: whitesmoke;
    font-size: inherit;
    margin: 0;
    overflow: hidden;
    padding-top: 2px;
    padding-bottom: 2px;
    text-overflow: ellipsis;
    white-space: nowrap;}
            
            
        </style>
        
       
    </head>
    <body style="background-color:royalblue;margin: 0px">
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
    padding:0px"><h3 style="text-align: center">Welcome <%=uname%></h3><p id="q1"><a href="Logout_f.jsp">Sign Out</a></p></div>
    <form action="class_vali" name="vali">
    <div  style="position: absolute;top:200px;left: 100px">        
        <p style="color: red">Batch: <select name="batch" required >
<option value=""  style="display: none">Please select the branch</option> 
<option value="CSE" id="ide1">Computer Science Engineering</option>
<option value="IT" id="ide1">Information Technology</option>
<option value="ME" id="ide1">Mechanical  Engineering</option>
<option value="ECE" id="ide1">Electronics and Communication Engineering</option>
<option value="CE" id="ide1">Civil Engineering</option>
<option value="EE" id="ide1">Electrical Engineering</option>
<option value="PE" id="ide1">Petroleum Engineering</option>
            </select></p>
    </div><div style="position: absolute;top:200px;left:600px">
        <p style="color: red"> Semester: <select name="sem" required>
        <option value="" style="display: none">Please select the semester</option>
        <option value="1">I</option>
        <option value="2">II</option>
        <option value="3">III</option>
        <option value="4">IV</option>
        <option value="5">V</option>
        <option value="6">VI</option>
        <option value="7">VII</option>
        <option value="8">VIII</option>
           </select></p>
    </div>
    <div style="position: absolute;top:200px;left:1000px">
        <p style="color: red"> Section: <select name="sec" required>
        <option value="" style="display: none">Please select the section</option>
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
        <option value="D">D</option>
        <option value="E">E</option>
           </select></p>
    </div><div style="position:absolute;top :300px;left: 630px">
        <input type="submit">
    </form>
    </body>
</html>
