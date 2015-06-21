package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;
import controlador.ProductXPersona;
import controlador.oracleConn;

public final class compraXcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>iFacture</title>\r\n");
      out.write("    <meta name=\"generator\" content=\"Bootply\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/FacturacionCSS.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"datables/media/css/jquery.dataTables.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\" language=\"javascript\" src=\"datables//media/js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" language=\"javascript\" src=\"datables//media/js/jquery.dataTables.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("            $('#example').DataTable();} );\r\n");
      out.write("        </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("    <nav id=\"mainNav\" class=\"navbar navbar-default navbar-fixed-top\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <a class=\"navbar-brand page-scroll\" href=\"index2.jsp\">iFacture</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"facturacion.jsp\">Facturación</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"inventario.jsp\">Inventario</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"reportes.jsp\">Reportes</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"respaldo.jsp\">Respaldo</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.navbar-collapse -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.container-fluid -->\r\n");
      out.write("    </nav>\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("      <div class=\"row row-offcanvas row-offcanvas-left\">\r\n");
      out.write("        <!--sidebar-->\r\n");
      out.write("        <div class=\"col-xs-6 col-sm-3 sidebar-offcanvas\" id=\"sidebar\" role=\"navigation\">\r\n");
      out.write("          <div data-spy=\"affix\" data-offset-top=\"15\" data-offset-bottom=\"45\">\r\n");
      out.write("            <ul class=\"nav\" id=\"sidebar-nav\">\r\n");
      out.write("              <li><a href=\"facturacion.jsp\">Facturación</a></li>\r\n");
      out.write("              <li><a href=\"inventario.jsp\">Inventario</a></li>\r\n");
      out.write("              <li><a href=\"reportes.jsp\">Reportes</a></li>\r\n");
      out.write("              <li><a href=\"respaldo.jsp\">Respaldo</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div><!--/sidebar-->\r\n");
      out.write("               <div class=\"col-xs-12 col-sm-9\" data-spy=\"scroll\" data-target=\"#sidebar-nav\">\r\n");
      out.write("            <br/>\r\n");
      out.write("            <h2> Productos comprados por cliente </h2>\r\n");
      out.write("            <br/>\r\n");
      out.write("        <form action=\"compraXcliente\" class=\"ui form segment\"  method=\"post\"> \r\n");
      out.write("            <label for=\"male\">Cedula del Cliente</label> <br/> \r\n");
      out.write("            <INPUT class =\"tb1\" NAME = \"ced\" TYPE = \"text\" id=\"ced\" required> <br/>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"Consultar\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <br/> \r\n");
      out.write("        <label for=\"male\">\r\n");
      out.write("             ");

              try{
              String res = request.getParameter("tab")!=null?request.getParameter("tab"):"";
              String[] tab = res.split(";");
              String table = tab[1];
              out.println(table); 
              }
              catch (Exception e){
                  out.println(":-(");                  
              }
            
      out.write("\r\n");
      out.write("        </label> <br/> \r\n");
      out.write("        <br/>\r\n");
      out.write("        <table id=\"example\" class=\"display\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("            <td>Producto  </td>\r\n");
      out.write("            <td>Descripcion  </td>\r\n");
      out.write("            <td>Precio unitario  </td>\r\n");
      out.write("            <td>Marca  </td>\r\n");
      out.write("            <td>Categoria  </td>\r\n");
      out.write("            <td>Id Factura </td>\r\n");
      out.write("            <td>Cantidad  </td>\r\n");
      out.write("            <td>Total </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        ");
 
              String res = request.getParameter("tab")!=null?request.getParameter("tab"):"";
              String[] tab = res.split(";");
              String table = tab[0];
             out.println(table);
             /*for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
            System.out.println(i);
                }*/
            
      out.write("\r\n");
      out.write("         \r\n");
      out.write("        </table>\r\n");
      out.write("</html>");
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
