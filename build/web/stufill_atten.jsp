<%-- 
    Document   : stufill_atten
    Created on : 19 Jul, 2015, 10:51:31 PM
    Author     : sonu1212
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
           
             
             tr {background-color: highlighttext}
             
             
             
        </style>
    </head>
   <body style="background-color: lightgrey;margin: 0px">
        <%!
       String uid,uclass,uname,usub,upsub;
        String s1[][]=new String[20][2];
         
    Connection con = null;
     PreparedStatement ps = null;
     int j,i;
        %>
          <% 
      uname=(String)session.getAttribute("name");
      uid=(String)session.getAttribute("id");
      uclass=(String)session.getAttribute("class");
      usub=(String)session.getAttribute("sub");
       upsub=(String)session.getAttribute("psub");
session.setAttribute("name",uname);
session.setAttribute("id",uid);
session.setAttribute("class",uclass);
session.setAttribute("psub", upsub);
session.setAttribute("sub", usub);

 if(uname == null) {
      response.sendRedirect("Logout_f.jsp");
 }
      %>
        <div style="position: absolute;width:100%;background-color: graytext;text-align: center;padding: 0px;margin: 0px">
            <h3>Welcome <%=uname%></h3><p id="q1"><a href="Logout_f.jsp">Sign Out</a></p>
        </div><div style="position: absolute;width: 76%;top: 100px;left: 167px;height: 100px">
            
           
            <a href="stufill_atten.jsp"> <p id="id3">TODAY</p></a>
                
           <a href="stufill_patten.jsp"><p id="id2">YESTERDAY</p></a>
           <a href="stu_smonth.jsp"><p id="id2">MONTHLY / SEM</p></a>
        
            
           
        </div><div style="position: absolute;width: 50%;top: 200px;left: 628px;">
            <a href="stu_ntfill.jsp"><input type="button" value="NEW"></input></a>
             <a href="stu_tfill.jsp"><input type="button" value="EDIT"></input></a>
        </div><div style="position: absolute;width: 77.7%;top: 250px;left: 175px;">
   
    
 
      <%
    try{
        
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
     // Connection con=ConnectionProvider.getCon();
       
   // Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    // ResultSet rs = stmt.executeQuery("select * from SEC_A  where id='13BTCSE1144' OR id='T_CSE_A'");
   
   
            ps=con.prepareStatement("select NAME,"+usub+",ID from "+uclass+" order by ID");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            i=0;
            
            while(rs.next())
            {
                j=0;
                if(rs.getString(1).equals("ACTIVE/INACTIVE"))
                {
                    break;
                }
                else
                {
                    s1[i][j]=rs.getString(1);
                    s1[i][j+1]=rs.getString(2);
                    i++;
                }
            }
            out.println("<table>");
            for(int k=0;k<i;k++)
            {
                 out.println("<tr>");
                for(j=0;j<2;j++)
                {
                      if(s1[k][j]!=null)
                    out.print("<td style=' width:500px'>"+s1[k][j]+"</td>"); 
                     else
                       out.print("<td style=' width:500px'></td>"); 
                    
                }
                out.println("</tr>");
            }
            out.println("</table>");
        
        }
        catch(Exception e)
        {}
    finally
    {
        con.close();
    }
      
        
   
%>
</div>
    </body>
</html>
