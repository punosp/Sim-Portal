package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stu_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:gainsboro;margin: 0px\">\n");
      out.write("       ");
 
String sess=(String)session.getAttribute("name");
session.setAttribute("uname",sess);

      out.write("\n");
      out.write("<div style=\"background-color:graytext; clear:both;\n");
      out.write("    text-align:center;margin: 0px;position:absolute;width:100%;\n");
      out.write("    padding:0px\"><h3>Welcome ");
      out.print(sess);
      out.write("</h3></div><div style=\"position: absolute;top:100px;background-color: lightgray;height:350px;width:428px;margin-right: 10px;margin-left: 15px\">\n");
      out.write("        <a href=\"stu_atten.jsp\"><p style=\"text-align: center;font-family: algerian;\">Attendance</p>\n");
      out.write("            <image src=\"images/class.png\" alt=\"HTML tutorial\" style=\"width:428px;height:300px;border:0;\">\n");
      out.write("        </a>\n");
      out.write("           \n");
      out.write("    </div><div style=\"position: absolute;top: 100px;background-color: lightgreen;height:350px;width:428px;left:458px\">\n");
      out.write("        <a href=\"stu_atten.jsp\"><p style=\"text-align: center;font-family: algerian;\">Time Table</p>\n");
      out.write("            <image src=\"images/atten.png\" alt=\"HTML tutorial\" style=\"width:428px;height:300px;border:0\">\n");
      out.write("        </a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div><div style=\"position: absolute;top: 100px;background-color:lightblue;height:350px;width:428px;left: 906px\">\n");
      out.write("        <a href=\"http://localhost:23755/project/home.html\"><p style=\"text-align: center;font-family: algerian\">Library</p>\n");
      out.write("            <image src=\"images/lib.png\" alt=\"HTML tutorial\" style=\"width:428px;height:300px;border:0\">\n");
      out.write("        </a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div><div style=\"position: absolute;background-color: lightsalmon;height:350px;width:428px;left: 10px;top: 480px\">\n");
      out.write("        \n");
      out.write("        <a href=\"http://www.dituniversity.edu.in/newsdetail.aspx?nid=454&mpgid=8&1pgid=224\"><p style=\"text-align: center;font-family: algerian\">News</p>\n");
      out.write("            <image src=\"images/news.png\" alt=\"HTML tutorial\" style=\"width:428px;height:300px;border:0\">\n");
      out.write("        </a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div><div style=\"position:absolute;left:700px;top:500px;width:300px;height: 300px\">\n");
      out.write("        \n");
      out.write("        <ul style=\"font-family: algerian;text-align: center;color: green;line-height: 30px;padding-top: 50px\">\n");
      out.write("            <li>100% attendance is recommended</li><br><br>\n");
      out.write("            <li>75% attendance is necessary to appear in Examination</li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("    \n");
      out.write("    </div><div style=\"position: absolute;top:880px;width: 100%;background-color:cyan\">\n");
      out.write("          <h5 style=\"font-family: algerian;color:blue\"><marquee behaviour=\"slide\" direction=\"right\">&copy; DIT University, India 2015. All Rights Reserved</marquee></h5>\n");
      out.write("            \n");
      out.write("                <h4 style=\"font-family: algerian;color:blue;text-align: center\">English(US)</h4>\n");
      out.write("       \n");
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
