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
        String s1[]=new String[70];
        String s2[]=new String[70];
        String s3[]=new String[70];
        String s4[]=new String[70];
        String s5[]=new String[70];
        float i1[]=new float[70];
         float i2[]=new float[70];
          float i3[]=new float[70];
        
         
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
            
           
            <a href="stufill_atten.jsp"> <p id="id2">TODAY</p></a>
                
           <a href="stufill_patten.jsp"><p id="id2">YESTERDAY</p></a>
           <a href="stu_smonth.jsp"><p id="id3">MONTHLY / SEM</p></a>
        
            
           
        </div><div style="position: absolute;width: 50%;top: 200px;left: 628px;">
            
        </div><div style="position: absolute;width: 77.7%;top: 250px;left: 175px;">
   
    
 
      <%
    try{
        
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
     // Connection con=ConnectionProvider.getCon();
       
   // Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    // ResultSet rs = stmt.executeQuery("select * from SEC_A  where id='13BTCSE1144' OR id='T_CSE_A'");
            String sp[]=usub.split("_");
            String sub1=sp[0];
   
            ps=con.prepareStatement("select NAME,"+sub1+"_P,"+sub1+"_S1,"+sub1+"_S2,ID from "+uclass+" where ID<> 'A/IA' and ID<>'TER' and ID<>'TER_ID' order by ID");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
          
            
            i=0;
            
            while(rs.next())
            {
                s1[i]=rs.getString(1);
                s2[i]=rs.getString(2);
                s3[i]=rs.getString(3);
                s4[i]=rs.getString(4);
                s5[i]=rs.getString(5);
                i++;
            }
            for(j=0;j<i-1;j++)
            {
                if(s2[i-1]!=null)
                {
                    if(s2[j]!=null)
                i1[j]=(Float.valueOf(s2[j])/Float.valueOf(s2[i-1]))*100.00f;
                     else
                        i1[j]=0f;
                     if(s3[j]!=null)
                i2[j]=(Float.valueOf(s3[j])/Float.valueOf(s3[i-1]))*100.00f;
                     else
                         i2[0]=0f;
                if(s4[i-1]!=null)
                {
                    if(s4[j]!=null)
                i3[j]=(Float.valueOf(s4[j])/Float.valueOf(s4[i-1]))*100.00f;
                    else
                        i3[j]=0f;
                }
                }
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th rowspan='2'>NAME</th>");
             out.println("<th colspan='2'>SESSIONAL I</th>");
              out.println("<th colspan='2'>SESSIONAL II</th>");
               out.println("<th colspan='2'>SEMESTER</th>");
            
            out.println("</tr>");
               out.println("<tr>");
            out.println("<td>Present/Total</td>");
             out.println("<td>% Attendance</td>");
              out.println("<td>Present/Total</td>");
             out.println("<td>% Attendance</td>");
              out.println("<td>Present/Total</td>");
             out.println("<td>% Attendance</td>");            
            out.println("</tr>");
            
            for(j=0;j<i-1;j++)
            {
                 out.println("<tr>");
            
               {
                   
                    out.print("<td>"+s1[j]+"</td>"); 
                     out.print("<td>"+s3[j]+"/"+s3[i-1]+"</td>");
                     if(i2[j]<75)
                      out.print("<td style='color:red'>"+i2[j]+"</td>");
                     else
                           out.print("<td style='color:lawngreen'>"+i2[j]+"</td>");
                       out.print("<td>"+s4[j]+"/"+s4[i-1]+"</td>");
                       if(i3[j]<75)
                        out.print("<td style='color:red'>"+i3[j]+"</td>");
                       else
                            out.print("<td style='color:lawngreen'>"+i3[j]+"</td>");
                         out.print("<td>"+s2[j]+"/"+s2[i-1]+"</td>");
                         if(i1[j]<75)
                          out.print("<td style='color:red'>"+i1[j]+"</td>");
                         else
                             out.print("<td style='color:lawngreen'>"+i1[j]+"</td>"); 
                             
                  
               }
               
               {
                   
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



