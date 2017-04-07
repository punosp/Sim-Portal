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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonu1212
 */
public class stu_logserv extends HttpServlet {
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
   boolean chk=false;
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session=request.getSession();
        try  {
            response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       String formname=request.getParameter("type");
       String uname="",uid="",uclass="",upass="";
              uid=request.getParameter("id");
            
            
             upass=request.getParameter("pass");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
            if(formname.equals("student"))
            {
           
            ps=con.prepareStatement("select * from STU_DETAILS");
             rs=ps.executeQuery();
               chk=false;
             
             
            while(rs.next())
             {
                 if(rs.getString(2).equalsIgnoreCase(uid)&&rs.getString(3).equals(upass)) 
                 {
                     chk=true;
                     uid=rs.getString(2);
                     uname=rs.getString(1);
                     uclass=rs.getString(6)+"_"+rs.getString(7)+"_"+rs.getString(5);
                     
                      
                  
           
                  break;
                 }
             }
            if(chk==true)
            {
                session.setAttribute("name",uname);
                session.setAttribute("id",uid);
                session.setAttribute("class",uclass);
                response.sendRedirect("stu_main.jsp"); 
                      //request.getRequestDispatcher("/stu_main.jsp").forward(request, response);
                  //flag=true;
            }
             if(chk==false)
             {
                  response.sendRedirect("stu_login.html"); 
             }
            
            
        }
             if(formname.equals("faculty"))
            {
           
            ps=con.prepareStatement("select * from FAC_DETAILS");
             rs=ps.executeQuery();
               chk=false;
             
             
            while(rs.next())
             {
                 if(rs.getString(2).equalsIgnoreCase(uid)&&rs.getString(3).equals(upass)) 
                 {
                     chk=true;
                     uid=rs.getString(2);
                     uname=rs.getString(1);
                    
                     
                      
                  
           
                  break;
                 }
             }
            if(chk==true)
            {
                session.setAttribute("name",uname);
                session.setAttribute("id",uid);
               
                response.sendRedirect("fac_main.jsp"); 
                      //request.getRequestDispatcher("/stu_main.jsp").forward(request, response);
                  //flag=true;
            }
             if(chk==false)
             {
                  response.sendRedirect("fac_login.html"); 
             }
            
            
        }
        }
         catch(Exception e){
        System.out.println(e);
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
