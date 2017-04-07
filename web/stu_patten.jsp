<%-- 
    Document   : stu_patten
    Created on : 14 Jul, 2015, 11:46:25 PM
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
            
            p#id2 {background-color:lightslategrey;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}
           a {text-decoration: none;color: white;}
          p#id1 {float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 15px;padding-top: 10px;margin-top: 0px;}
             p#id3 {background-color:lawngreen;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}
       
          table,td,th{border: 1px solid green;margin: 0;pxpadding: 0px;}
            table { border-collapse: collapse;}
             td {width: 347px;height: 35px;color:white;text-align: center;font-size: 15px;padding-top: 10px;margin-top: 0px;}
              th {width: 341.5px;height: 40px;color:white;text-align: center;font-size: 20px;padding-top: 10px;margin-top: 0px;}
             p#q2 {position: absolute;left: 100px;top: 0px;}
             
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
                
           <a href="stu_patten.jsp"><p id="id3">YESTERDAY</p></a>
           <a href="stu_month.jsp"><p id="id2">MONTHLY / SEM</p></a>
        
            
           
</div><div style="position: absolute;width: 77.7%;top: 200px;left: 156px;">
    <%!
    String pass,sign,sub,fac;
    String [] s1=new String[15];
    String [] s2=new String[15];
    String [] s6=new String[15];
    String [] s5=new String[15];
     String psub[]=new String[16];
    
   
    Connection con = null;
     PreparedStatement ps = null;
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
                     ResultSet rs = stmt.executeQuery("select * from "+uclass+"  where id='"+uid+"' OR id='TER'");
   
           // ps=con.prepareStatement("select * from SEC_A  where id='13BTCSE1144' OR id='T_CSE_A'");
           // ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            
            j=4;
            for(i=0;i<3;i++)
            {
                s1[i]=rsmd.getColumnName(j);
               
                j=j+2;
                 String  p1sub[]=s1[i].split("_");
                psub[i]=p1sub[0];
                if(psub[i].equalsIgnoreCase("DA4120"))
                    s1[i]="OPERATING SYSTEM";
                 if(psub[i].equalsIgnoreCase("DA4020"))
                    s1[i]="LINUX";
                  if(psub[i].equalsIgnoreCase("DA4030"))
                    s1[i]="WEB TECH.";
            }
            
    
         rs.next();
               
                   
                   j=4;
                 for(i=0;i<3;i++)
                 {
                   s5[i]=rs.getString(j);
                   if(s5[i]!=null)
                   {
                    if(s5[i].equals("P"))
                    {
                       s6[i]="&#10004;"; 
                    }
                   if(s5[i].equals("A"))
                        s6[i]="&#10008;";
                   }
                   if(s5[i]==null)
                       s6[i]="";
                   
                    j=j+2;
                  
                 }
               
               rs.next();
                
              
               
                   j=3;
                   for(i=0;i<3;i++)
            {
                s2[i]=rs.getString(j);
               
                j=j+2; 
               }
            pageContext.setAttribute("a0", s6[0]);
                 pageContext.setAttribute("a1", s6[1]);
                 pageContext.setAttribute("a2", s6[2]);
          
    }
    
    catch(Exception e)
    {}
    finally
            {
                con.close();
            }
    %>
     <c:if test="${pageScope.a0.equals('&#10004;')}">  
        <style> b#iid0 {color: lawngreen}</style>
          </c:if>
               <c:if test="${pageScope.a0.equals('&#10008;')}">  
                   <style> b#iid0 {color: red}</style>
          </c:if>
               <c:if test="${pageScope.a1.equals('&#10004;')}">  
              <style> b#iid1 {color: lawngreen}</style>
          </c:if>
               <c:if test="${pageScope.a1.equals('&#10008;')}">  
              <style> b#iid1 {color: red}</style>
          </c:if>
               <c:if test="${pageScope.a2.equals('&#10004;')}"> 
              <style> b#iid2 {color: lawngreen}</style>
          </c:if>
               <c:if test="${pageScope.a2.equals('&#10008;')}">
              <style> b#iid2 {color: red}</style>
          </c:if> 
    <table>
    <tr>
                <th>SUBJECT</th>
                
                <th>PRESENT<b>(&#10004;)</b> / ABSENT<b  id="id4">(&#10008;)</b></th>
                <th>FACULTY</th>  
</tr>
 <tr>
                <td><%=s1[0]%></td>
                
                <td><b id="iid0"><%=s6[0]%></b></td>
                <td><%=s2[0]%></td>  
</tr>
     <tr>
                <td><%=s1[1]%></td>
                
                 <td><b id="iid1"><%=s6[1]%></b></td>
                <td><%=s2[1]%></td>  
</tr>
     <tr>
                <td><%=s1[2]%></td>
                
                 <td><b id="iid2"><%=s6[2]%></b></td>
                <td><%=s2[2]%></td>  
     </tr>
    </table>
    
    
    
</div>
        
        
    </body>
</html>
