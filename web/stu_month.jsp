<%-- 
    Document   : stu_month
    Created on : 13 Jul, 2015, 11:14:21 PM
    Author     : sonu1212
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="SHORTCUT ICON" HREF="images/logo.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Attendance</title>
        <style>
            a:link {color: blue;text-decoration: none}
            a:visited {color: blue;text-decoration: none}
            a:hover {color: green}
            p#q1 {position: absolute;left: 1200px;top: 0px;}
            p#id2:hover {background-color:grey;}
            p#id3:hover {background-color:grey;}
             p#q2 {position: absolute;left: 100px;top: 0px;}
            
            p#id2 {background-color:lightslategrey;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}
           a {text-decoration: none;color: white;}
           p#id1 {background-color:lightslategrey;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}
           
            p#id3 {background-color:lawngreen;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}
       
          table,td,th{border: 1px solid green;margin: 0;pxpadding: 0px;}
            table { border-collapse: collapse;}
             td {width: 260px;height: 35px;color:white;text-align: center;font-size: 15px;padding-top: 10px;margin-top: 0px;}
              th {width: 260px;height: 40px;color:white;text-align: center;font-size: 20px;padding-top: 10px;margin-top: 0px;}
             
             
             tr {background-color: highlighttext}
             
             
             
        </style>
    </head>
   <body style="background-color: lightgrey;margin: 0px">
         <%!
        String uid,uclass,uname;
        %>
         <% 
String uname=(String)session.getAttribute("name");
String uid=(String)session.getAttribute("id");
String uclass=(String)session.getAttribute("class");
session.setAttribute("name",uname);
session.setAttribute("id",uid);
session.setAttribute("class",uclass);
 if(uname == null) {
      response.sendRedirect("Logout.jsp");
   }
%>
        <div style="position: absolute;width:100%;background-color: graytext;text-align: center;padding: 0px;margin: 0px">
            <h3>Welcome <%=uname%></h3><p id="q1"><a href="Logout.jsp">Sign Out</a></p><p id="q2"><a href="stu_main.jsp">Home</a></p>
        </div><div style="position: absolute;width: 76%;top: 100px;left: 167px;height: 100px">
            
           
           <a href="stu_atten.jsp"> <p id="id2">TODAY</p></a>
                
           <a href="stu_patten.jsp"><p id="id2">YESTERDAY</p></a>
           <a href="stu_month.jsp"><p id="id3">MONTHLY / SEM</p></a>
        
            
           
</div><div style="position: absolute;width: 77.7%;top: 200px;left: 156px;">
    <%!
    String pass,sign,sub,fac;
    String [] s1=new String[15];
    String [] s2=new String[15];
    String [] s3=new String[15];
    String [] s4=new String[15];
    String [] s5=new String[15];
    String [] s6=new String[15];
    String [] s7=new String[15];
    String [] s8=new String[15];
     String [] i1=new String[15];
    String [] i2=new String[15];
    String [] i3=new String[15];
    
   
   // boolean chk=true;
    Connection con = null;
     Statement stmt = null;
     int j,i;
            %>
    <% 
    try{
    response.setContentType("text/html");
     pass=request.getParameter("id");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY);
                     ResultSet rs = stmt.executeQuery("select * from "+uclass+"  where id='"+uid+"' OR id='TER' or id= 'TOTAL' or id='A/IA' order by id");
   
           // ps=con.prepareStatement("select * from SEC_A  where id='13BTCSE1144' OR id='T_CSE_A'");
           // ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            
            j=3;
            for(i=0;i<3;i++)
            {
                s1[i]=rsmd.getColumnName(j);
               
                j=j+2;
            }
            
            
            
       /*  rs.absolute(2);
         if(rs.getString(12).equals("ACTIVE"))
             chk=true;
         if(rs.getString(13).equals("ACTIVE"))
             chk=false;*/
         
         
         rs.absolute(4);
         j=9;
               for(i=0;i<3;i++)
               {
                   s3[i]=rs.getString(j);
                   j++;
               }
             /*  if(chk==false)
               {
                   j=13;
               }
               else
                   j=12;*/
               j=12;
               for(i=0;i<3;i++)
               {
                   s4[i]=rs.getString(j);
                   s5[i]=rs.getString(j+1);
                   j=j+2;
               }
               
               
               
                rs.absolute(1);
         j=9;
               for(i=0;i<3;i++)
               {
                   s6[i]=rs.getString(j);
                   j++;
               }
            /*   if(chk==false)
               {
                   j=13;
               }
               else
                   j=12;*/
               j=12;
               for(i=0;i<3;i++)
               {
                  
                   s7[i]=rs.getString(j);   
                    s8[i]=rs.getString(j+1);   
                   j=j+2;
               }
               for(i=0;i<3;i++)
               {
                  float e1=Float.parseFloat(s3[i]);
                  float e2=Float.parseFloat(s4[i]);
                  float e3=Float.parseFloat(s5[i]);
                  float e4=Float.parseFloat(s6[i]);
                   float e5=Float.parseFloat(s7[i]);
                    float e6=Float.parseFloat(s8[i]);
                  if(e1!=0)
                  i1[i]= String.valueOf((e4/e1)*100);
                   if(e1==0)
                  i1[i]= " ";
                  if(e2!=0)
                      i2[i]= String.valueOf((e5/e2)*100);
                   if(e2==0)
                  i2[i]= " ";
                  if(e3!=0)
                      i3[i]= String.valueOf((e6/e3)*100);
                   if(e3==0)
                  i3[i]= " ";
                   
                   
               }
               rs.absolute(3);
               
                   j=3;
                   for(i=0;i<3;i++)
            {
                s2[i]=rs.getString(j);
               
                j=j+2; 
               }
                   pageContext.setAttribute("a0", i1[0]);
                 pageContext.setAttribute("a1", i1[1]);
                 pageContext.setAttribute("a2", i1[2]);
                  pageContext.setAttribute("b0", i2[0]);
                 pageContext.setAttribute("b1", i2[1]);
                 pageContext.setAttribute("b2", i2[2]);
                  pageContext.setAttribute("c0", i3[0]);
                 pageContext.setAttribute("c1", i3[1]);
                 pageContext.setAttribute("c2", i3[2]);
            
            
            
    }
    
    catch(Exception e)
    {}
    finally
    {
        con.close();
    }
    %>
    <c:if test="${Float(pageScope.a0) >= 75}">  
        <style> b#iid0 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.a0) < 75}">  
                   <style> b#iid0 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.a1) >= 75}">  
              <style> b#iid1 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.a1) < 75}">  
              <style> b#iid1 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.a2) >= 75}"> 
              <style> b#iid2 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.a2) < 75}">
              <style> b#iid2 {color: red}</style>
          </c:if> 
              <c:if test="${Float(pageScope.b0) >= 75}">  
        <style> b#iie0 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.b0) < 75}">  
                   <style> b#iie0 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.b1) >= 75}">  
              <style> b#iie1 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.b1) < 75}">  
              <style> b#iie1 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.b2) >= 75}"> 
              <style> b#iie2 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.b2) < 75}">
              <style> b#iie2 {color: red}</style>
          </c:if>
              <c:if test="${Float(pageScope.c0) >= 75}">  
        <style> b#iif0 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.c0) < 75}">  
                   <style> b#iif0 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.c1) >= 75}">  
              <style> b#iif1 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.c1) < 75}">  
              <style> b#iif1 {color: red}</style>
          </c:if>
          <c:if test="${Float(pageScope.c2) >= 75}"> 
              <style> b#iif2 {color: lawngreen}</style>
          </c:if>
               <c:if test="${Float(pageScope.c2) < 75}">
              <style> b#iif2 {color: red}</style>
          </c:if>
    <table>
    <tr>
        <th rowspan="2">SUBJECT</th>
                
        <th colspan="2">SESSIONAL I</th>
        <th colspan="2">SESSIONAL 2</th>
        <th colspan="2">SEMESTER</th>
</tr>
 <tr>
                <td>Present/Total</td>
                 <td>% Attendance</td>
                  <td>Present/Total</td>
                   <td>% Attendance</td>
                 <td>Present/Total</td>
                  <td>% Attendance</td>
                  
                
                 
</tr>
     <tr>
                <td><%=s1[0]%></td>
                 <td><%=s7[0]%>/<%=s4[0]%></td>
                 <td><b id="iie0"><%=i2[0]%>%</b></td>
                   <td><%=s8[0]%>/<%=s5[0]%></td>
                   <td><b id="iif0"><%=i3[0]%>%</b></td>
                  <td><%=s6[0]%>/<%=s3[0]%></td>
                  <td> <b id="iid0"><%=i1[0]%>%</b></td>
                
</tr>
     <tr>
                <td><%=s1[1]%></td>
                 <td><%=s7[1]%>/<%=s4[1]%></td>
                 <td><b id="iie1"><%=i2[1]%>%</b></td>
                   <td><%=s8[1]%>/<%=s5[1]%></td>
                   <td><b id="iif1"><%=i3[1]%>%</b></td>
                  <td><%=s6[1]%>/<%=s3[1]%></td>
                  <td><b id="iid1"><%=i1[1]%>%</b></td>
                  
     </tr>
     <tr>
                 <td><%=s1[2]%></td>
                 <td><%=s7[2]%>/<%=s4[2]%></td>
                 <td><b id="iie2"><%=i2[2]%>%</b></td>
                   <td><%=s8[2]%>/<%=s5[2]%></td>
                   <td><b id="iif2"><%=i3[2]%>%</b></td>
                  <td><%=s6[2]%>/<%=s3[2]%></td>
                  <td><b id="iid2"><%=i1[2]%>%</b></td>
                  
     </tr>
     
    </table>
    
    
    
</div>
        
        
    </body>
</html>
