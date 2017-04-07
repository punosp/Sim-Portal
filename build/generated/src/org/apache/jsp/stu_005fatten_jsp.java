package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import controller.Provider;
import controller.ConnectionProvider;

public final class stu_005fatten_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    String pass,sign,sub,fac;
    String [] s1=new String[15];
    String [] s2=new String[15];
    String [] s6=new String[15];
    String [] s5=new String[15];
    
    Connection con = null;
     PreparedStatement ps = null;
     int j,i;
            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"SHORTCUT ICON\" HREF=\"images/logo.ico\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Attendance</title>\n");
      out.write("        <style>\n");
      out.write("            a:link {color: blue;text-decoration: none}\n");
      out.write("            a:visited {color: blue;text-decoration: none}\n");
      out.write("            a:hover {color: green}\n");
      out.write("            p#q1 {position: absolute;left: 1200px;top: 0px;}\n");
      out.write("            p#id2:hover {background-color:grey;}\n");
      out.write("            p#id3:hover {background-color:grey;}\n");
      out.write("              p#q2 {position: absolute;left: 100px;top: 0px;}\n");
      out.write("            p#id2 {background-color:lightslategrey;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}\n");
      out.write("           a {text-decoration: none;color: white;}\n");
      out.write("          p#id1 {float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 15px;padding-top: 10px;margin-top: 0px;}\n");
      out.write("             p#id3 {background-color:lawngreen;float: left;width: 341.5px;height: 55px;color:white;text-align: center;font-size: 30px;padding-top: 15px;margin-top: 0px;}\n");
      out.write("       \n");
      out.write("          table,td,th{border: 1px solid green;margin: 0;pxpadding: 0px;}\n");
      out.write("            table { border-collapse: collapse;}\n");
      out.write("             td {width: 347px;height: 35px;color:white;text-align: center;font-size: 15px;padding-top: 10px;margin-top: 0px;}\n");
      out.write("              th {width: 341.5px;height: 40px;color:white;text-align: center;font-size: 20px;padding-top: 10px;margin-top: 0px;}\n");
      out.write("           \n");
      out.write("             tr {background-color: highlighttext}\n");
      out.write("             \n");
      out.write("             \n");
      out.write("             \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: lightgrey;margin: 0px\">\n");
      out.write("       \n");
      out.write("        ");
 
String uname=(String)session.getAttribute("name");
 String uid=(String)session.getAttribute("id");
String uclass=(String)session.getAttribute("class");
session.setAttribute("id",uid);
session.setAttribute("class",uclass);
session.setAttribute("name",uname);

  
   if(uname == null) {
      response.sendRedirect("Logout.jsp");
   }



      out.write("\n");
      out.write("        <div style=\"position: absolute;width:100%;background-color: graytext;text-align: center;padding: 0px;margin: 0px\">\n");
      out.write("            <h3>Welcome ");
      out.print(uname);
      out.write("</h3><p id=\"q1\"><a href=\"Logout.jsp\">Sign Out</a></p><p id=\"q2\"><a href=\"stu_main.jsp\">Home</a></p>\n");
      out.write("        </div><div style=\"position: absolute;width: 76%;top: 100px;left: 167px;height: 100px\">\n");
      out.write("            \n");
      out.write("           \n");
      out.write("           <a href=\"stu_atten.jsp\"> <p id=\"id3\">TODAY</p></a>\n");
      out.write("                \n");
      out.write("           <a href=\"stu_patten.jsp\"><p id=\"id2\">YESTERDAY</p></a>\n");
      out.write("           <a href=\"stu_month.jsp\"><p id=\"id2\">MONTHLY / SEM</p></a>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("           \n");
      out.write("</div><div id=\"idv\" style=\"position: absolute;width: 77.7%;top: 200px;left: 156px;\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 
    try{
    response.setContentType("text/html");
     pass=request.getParameter("id");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sim","portal");
     // Connection con=ConnectionProvider.getCon();
       
   // Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    // ResultSet rs = stmt.executeQuery("select * from SEC_A  where id='13BTCSE1144' OR id='T_CSE_A'");
   
   
            ps=con.prepareStatement("select * from " +uclass+ " where id='"+uid+"' OR id = 'TER'");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            
          // s1[0]=rsmd.getColumnName(3);
          // s1[1]=rsmd.getColumnName(5);
          // s1[2]=rsmd.getColumnName(7);
            j=3;
            for(i=0;i<3;i++)
            {
               
                s1[i]=rsmd.getColumnName(j);
               
                j=j+2;
                
            }
            
          rs.next();
              
                
               
                   
                   j=3;
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
                    {
                        s6[i]="&#10008;";
                    }
                     }
                     if(s5[i]==null)
                     {
                         s6[i]="";
                     }
                   
                      
                    j=j+2;
                 }
                
                
              
               
               
                
               rs.next();
               
               
                   j=3;
                   for(i=0;i<3;i++)
            {
                s2[i]=rs.getString(j);
               
                j=j+2; 
               }
           con.close();
            
            pageContext.setAttribute("a0", s6[0]);
                 pageContext.setAttribute("a1", s6[1]);
                 pageContext.setAttribute("a2", s6[2]);
            
    }
    
    catch(Exception e)
    {}
    
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("               ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                   \n");
      out.write("               ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("               ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("              \n");
      out.write("               ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("               ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("            \n");
      out.write("          \n");
      out.write("        \n");
      out.write("              \n");
      out.write("    <table>\n");
      out.write("    <tr>\n");
      out.write("                <th>SUBJECT</th>\n");
      out.write("                \n");
      out.write("                <th>PRESENT(<b id=\"idd1\">&#10004;</b>) / ABSENT(<b  id=\"idd2\">&#10008;</b>)</th>\n");
      out.write("                <th>FACULTY</th>  \n");
      out.write("</tr>\n");
      out.write(" <tr>\n");
      out.write("                <td>");
      out.print(s1[0]);
      out.write("</td>\n");
      out.write("                \n");
      out.write("                <td><b id=\"iid0\">");
      out.print(s6[0]);
      out.write("</b></td>\n");
      out.write("                <td>");
      out.print(s2[0]);
      out.write("</td>  \n");
      out.write("</tr>\n");
      out.write("     <tr>\n");
      out.write("                <td>");
      out.print(s1[1]);
      out.write("</td>\n");
      out.write("                \n");
      out.write("                <td><b id=\"iid1\">");
      out.print(s6[1]);
      out.write("</b></td>\n");
      out.write("                <td>");
      out.print(s2[1]);
      out.write("</td>  \n");
      out.write("</tr>\n");
      out.write("     <tr>\n");
      out.write("                <td>");
      out.print(s1[2]);
      out.write("</td>\n");
      out.write("                \n");
      out.write("                <td><b id =\"iid2\">");
      out.print(s6[2]);
      out.write("</b></td>\n");
      out.write("                <td>");
      out.print(s2[2]);
      out.write("</td>  \n");
      out.write("     </tr>\n");
      out.write("    </table>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("        \n");
      out.write("        \n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a0.equals('&#10004;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("        <style> b#iid0 {color: lawngreen}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a0.equals('&#10008;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("                   <style> b#iid0 {color: red}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a1.equals('&#10004;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("              <style> b#iid1 {color: lawngreen}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a1.equals('&#10008;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("              <style> b#iid1 {color: red}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a2.equals('&#10004;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \n");
        out.write("              <style> b#iid2 {color: lawngreen}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageScope.a2.equals('&#10008;')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("              <style> b#iid2 {color: red}</style>\n");
        out.write("          ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }
}
