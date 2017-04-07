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
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class class_vali extends HttpServlet {
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
   boolean chk;
   String uclass,upsub,usub;
   

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session=request.getSession();
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String resources[]=new String[3];
            resources[0]=request.getParameter("batch");
             resources[1]=request.getParameter("sem");
              resources[2]=request.getParameter("sec");
              String uname=(String)session.getAttribute("name");
String uid=(String)session.getAttribute("id");
session.setAttribute("name",uname);
session.setAttribute("id",uid);

 if(uname == null) {
      response.sendRedirect("Logout_f.jsp");
   }
        Class.forName("oracle.jdbc.driver.OracleDriver");
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
           if(resources[0]!="" && resources[1]!="" && resources[2]!="")
           {
              ps=con.prepareStatement("select * from " +resources[0]+"_"+resources[2]+"_"+resources[1]+" where id='TER'");
             rs=ps.executeQuery();  
              ResultSetMetaData rsmd = rs.getMetaData();
             rs.next();
             chk=false;
             for(int i =4;i<=8;i=i+2)
             {
                 if(rs.getString(i).equals(uid))
                 {
                     upsub=rsmd.getColumnName(i);
                     usub=rsmd.getColumnName(i-1);
                     chk=true;
                     uclass=resources[0]+"_"+resources[2]+"_"+resources[1];
                 }
                
             }
           }
           if(chk==true)
            {
                 session.setAttribute("psub",upsub);
                 session.setAttribute("sub",usub);
                session.setAttribute("class",uclass);
                response.sendRedirect("stufill_atten.jsp"); 
                      //request.getRequestDispatcher("/stu_main.jsp").forward(request, response);
                  //flag=true;
            }
             if(chk==false)
             {
                  response.sendRedirect("stu_select.jsp"); 
             }
            
            con.close();
       
        }
         
        
        catch(Exception e){}
        
      
        
                
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
