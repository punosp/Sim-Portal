package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stu_005fselect_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"SHORTCUT ICON\" HREF=\"images/logo.ico\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            p#q1 {position: absolute;left: 1200px;top: 0px;}\n");
      out.write("            a:link {color: blue;text-decoration: none}\n");
      out.write("            a:visited {color: blue;text-decoration: none}\n");
      out.write("            a:hover {color: green}\n");
      out.write("            option#ide1 {height: 50px}\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:gainsboro;margin: 0px\">\n");
      out.write("       ");
 
String uname=(String)session.getAttribute("name");
String uid=(String)session.getAttribute("id");
session.setAttribute("name",uname);
session.setAttribute("id",uid);

 if(uname == null) {
      response.sendRedirect("Logout_f.jsp");
   }

      out.write("\n");
      out.write("<div style=\"background-color:graytext; clear:both;\n");
      out.write("    margin: 0px;position:absolute;width:100%;\n");
      out.write("    padding:0px\"><h3 style=\"text-align: center\">Welcome ");
      out.print(uname);
      out.write("</h3><p id=\"q1\"><a href=\"Logout_f.jsp\">Sign Out</a></p></div>\n");
      out.write("    <div  style=\"position: absolute;top:200px\">        \n");
      out.write("        Batch: <select name=\"Batch\" style=\"background-color: graytext;-webkit-appearance: button;\n");
      out.write("    -moz-appearance: button;\n");
      out.write("    -webkit-user-select: none;\n");
      out.write("    -moz-user-select: none;\n");
      out.write("    -webkit-padding-end: 20px;\n");
      out.write("    -moz-padding-end: 20px;\n");
      out.write("    -webkit-padding-start: 2px;\n");
      out.write("    -moz-padding-start: 2px;\n");
      out.write("     border: 1px solid #AAA;\n");
      out.write("    border-radius: 2px;\n");
      out.write("    box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);\n");
      out.write("    color: whitesmoke;\n");
      out.write("    font-size: inherit;\n");
      out.write("    margin: 0;\n");
      out.write("    overflow: hidden;\n");
      out.write("    padding-top: 2px;\n");
      out.write("    padding-bottom: 2px;\n");
      out.write("    text-overflow: ellipsis;\n");
      out.write("    white-space: nowrap;\">\n");
      out.write("<option value=\"\"  style=\"display: none\">Please select the batch</option> \n");
      out.write("<option value=\"CSE\" id=\"ide1\">Computer Science Engineering</option>\n");
      out.write("<option value=\"IT\" id=\"ide1\">Information Technology</option>\n");
      out.write("<option value=\"ME\" id=\"ide1\">Mechanical  Engineering</option>\n");
      out.write("<option value=\"ECE\" id=\"ide1\">Electronics and Communication Engineering</option>\n");
      out.write("<option value=\"CE\" id=\"ide1\">Civil Engineering</option>\n");
      out.write("<option value=\"EE\" id=\"ide1\">Electrical Engineering</option>\n");
      out.write("<option value=\"PE\" id=\"ide1\">Petroleum Engineering</option>\n");
      out.write("</select>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
