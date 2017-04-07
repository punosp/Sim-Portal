/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonu1212
 */
public class stu_insert extends HttpServlet {
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
   boolean chk;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String uid,uclass,uname,usub,upsub;
            
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
String fname=request.getParameter("type");

        Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
         if(fname.equals("newtfill"))
         {
             
             String psub[]=usub.split("_");
             
             ps=con.prepareStatement("select ID,"+psub[0]+"_P,"+psub[0]+"_S1,"+psub[0]+"_S2 from "+uclass+" order by ID");
             rs=ps.executeQuery();
             String s1[]=new String[10];
             String s2[]=new String[10];
             String s3[]=new String[10];
             String s4[]=new String[10];
             String s5[]=new String[10];
             
             int count=0;
             
             while(rs.next())
             {
                 String c=rs.getString(1);
                 
                 if(!c.equals("TER") && !c.equals("TER_ID"))
                     
                 {
                   
                   s1[count]=rs.getString(1);
                   s3[count]=rs.getString(2);
                   s4[count]=rs.getString(3);
                   s5[count]=rs.getString(4);
                   
                   count++;
                 }
             }
             
         if(s4[count-2]!=null)
         {
            ps=con.prepareStatement("update "+uclass+" set "+psub[0]+"_P='"+(Integer.valueOf(s3[count-1])+1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[count-1])+1)+"' where ID='TOTAL'");   
         ps.executeUpdate();
         }
         else{
               ps=con.prepareStatement("update "+uclass+" set "+psub[0]+"_P='"+(Integer.valueOf(s3[count-1])+1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[count-1])+1)+"' where ID='TOTAL'");   
          ps.executeUpdate();
         }
         
               for(int i=0;i<count-2;i++)
             {
                 String j=String.valueOf(i);
                 s2[i]=(request.getParameter(j)).toUpperCase();
                if(s4[count-2]!=null)
                { if(s2[i].equalsIgnoreCase("P"))
                    {
                 ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                    }
                    if(s2[i].equalsIgnoreCase("A"))
                    {
                      ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"' where ID='"+s1[i]+"'");   
                     ps.executeUpdate();
                    }  
                }
                 else
                {               
                     if(s2[i].equalsIgnoreCase("P"))
                     {
                 ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                     }
                     if(s2[i].equalsIgnoreCase("A"))
                     {
                      ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"' where ID='"+s1[i]+"'");   
                 ps.executeUpdate();
                     }
                }
                out.println(s2[i]);
             }
              
             response.sendRedirect("stufill_atten.jsp");
            
         }
         if(fname.equals("edtfill"))
         {
               
             String psub[]=usub.split("_");
             
             ps=con.prepareStatement("select ID,"+psub[0]+"_P,"+psub[0]+"_S1,"+psub[0]+"_S2,"+usub+" from "+uclass+" order by ID");
             rs=ps.executeQuery();
            
             String s1[]=new String[10];
             String s2[]=new String[10];
             String s3[]=new String[10];
             String s4[]=new String[10];
             String s5[]=new String[10];
             String s6[]=new String[10];
             
             int count=0;
             
             while(rs.next())
             {
                 String c=rs.getString(1);
                 
                 if(!c.equals("TER") && !c.equals("TER_ID"))
                     
                 {
                   
                   s1[count]=rs.getString(1);
                   s3[count]=rs.getString(2);
                   s4[count]=rs.getString(3);
                   s5[count]=rs.getString(4);
                   s6[count]=rs.getString(5);
                   
                   count++;
                 }
             }
            
         
               for(int i=0;i<count-2;i++)
             {
                 String j=String.valueOf(i);
                 s2[i]=request.getParameter(j).toUpperCase();
                if(s4[count-2]!=null)
                {
                    if(s2[i].equalsIgnoreCase("P") && !(s2[i].equalsIgnoreCase(s6[i])))
                    {
                 ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                    }
                    if(s2[i].equalsIgnoreCase("A") && !(s2[i].equalsIgnoreCase(s6[i])))
                    {
                      ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])-1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[i])-1)+"' where ID='"+s1[i]+"'");   
                     ps.executeUpdate();
                    }
                }
                 else
                {               
                     if(s2[i].equalsIgnoreCase("P") && !(s2[i].equalsIgnoreCase(s6[i])))
                     {
                 ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                     }
                     if(s2[i].equalsIgnoreCase("A") && !(s2[i].equalsIgnoreCase(s6[i])))
                     {
                      ps=con.prepareStatement("update "+uclass+" set "+usub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])-1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[i])-1)+"' where ID='"+s1[i]+"'");   
                 ps.executeUpdate();
                     }
                }
                out.println(s2[i]);
             }
              
             response.sendRedirect("stufill_atten.jsp");
           
         }
         if(fname.equals("edyfill"))
         {
             
             String psub[]=usub.split("_");
             
             ps=con.prepareStatement("select ID,"+psub[0]+"_P,"+psub[0]+"_S1,"+psub[0]+"_S2,"+upsub+" from "+uclass+" order by ID");
             rs=ps.executeQuery();
             String s1[]=new String[10];
             String s2[]=new String[10];
             String s3[]=new String[10];
             String s4[]=new String[10];
             String s5[]=new String[10];
             String s6[]=new String[10];
             
             int count=0;
             
             while(rs.next())
             {
                 String c=rs.getString(1);
                 
                 if(!c.equals("TER") && !c.equals("TER_ID"))
                     
                 {
                   
                   s1[count]=rs.getString(1);
                   s3[count]=rs.getString(2);
                   s4[count]=rs.getString(3);
                   s5[count]=rs.getString(4);
                   s6[count]=rs.getString(5);
                   
                   count++;
                 }
             }
            
         
               for(int i=0;i<count-2;i++)
             {
                 String j=String.valueOf(i);
                 s2[i]=request.getParameter(j).toUpperCase();
                if(s4[count-2]!=null)
                {
                    if(s2[i].equalsIgnoreCase("P") && !(s2[i].equalsIgnoreCase(s6[i])))
                    {
                 ps=con.prepareStatement("update "+uclass+" set "+upsub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                    }
                    if(s2[i].equalsIgnoreCase("A") && !(s2[i].equalsIgnoreCase(s6[i])))
                    {
                      ps=con.prepareStatement("update "+uclass+" set "+upsub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])-1)+"',"+psub[0]+"_S1='"+(Integer.valueOf(s4[i])-1)+"' where ID='"+s1[i]+"'");   
                     ps.executeUpdate();
                    }
                }
                 else
                {               
                     if(s2[i].equalsIgnoreCase("P") && !(s2[i].equalsIgnoreCase(s6[i])))
                     {
                 ps=con.prepareStatement("update "+uclass+" set "+upsub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])+1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[i])+1)+"' where ID='"+s1[i]+"'");
                    ps.executeUpdate();
                     }
                     if(s2[i].equalsIgnoreCase("A") && !(s2[i].equalsIgnoreCase(s6[i])))
                     {
                      ps=con.prepareStatement("update "+uclass+" set "+upsub+"='"+s2[i]+"',"+psub[0]+"_P='"+(Integer.valueOf(s3[i])-1)+"',"+psub[0]+"_S2='"+(Integer.valueOf(s5[i])-1)+"' where ID='"+s1[i]+"'");   
                 ps.executeUpdate();
                     }
                }
                out.println(s2[i]);
             }
              
             response.sendRedirect("stufill_patten.jsp");
             
         }
            
           
          
            
        }
        catch(Exception e){}
        finally
        {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(stu_insert.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
