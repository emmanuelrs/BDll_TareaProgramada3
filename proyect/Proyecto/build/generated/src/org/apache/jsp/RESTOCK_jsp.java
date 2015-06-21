package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;
import controlador.inventario;
import controlador.oracleConn;

public final class RESTOCK_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>iFacture</title>\n");
      out.write("    <meta name=\"generator\" content=\"Bootply\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/restockCSS.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"datables/media/css/jquery.dataTables.css\">\n");
      out.write("        \n");
      out.write("\t<script type=\"text/javascript\" language=\"javascript\" src=\"datables//media/js/jquery.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" language=\"javascript\" src=\"datables//media/js/jquery.dataTables.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function() {\n");
      out.write("            $('#example').DataTable();} );\n");
      out.write("        </script>\n");
      out.write("</head>\n");
      out.write("<body id=\"page-top\">\n");
      out.write("    <nav id=\"mainNav\" class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand page-scroll\" href=\"index2.jsp\">iFacture</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"facturacion.jsp\">Facturación</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"inventario.jsp\">Inventario</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"reportes.jsp\">Reportes</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"respaldo.jsp\">Respaldo</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container-fluid -->\n");
      out.write("    </nav>\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("      <div class=\"row row-offcanvas row-offcanvas-left\">\n");
      out.write("        <!--sidebar-->\n");
      out.write("        <div class=\"col-xs-6 col-sm-3 sidebar-offcanvas\" id=\"sidebar\" role=\"navigation\">\n");
      out.write("          <div data-spy=\"affix\" data-offset-top=\"15\" data-offset-bottom=\"45\">\n");
      out.write("            <ul class=\"nav\" id=\"sidebar-nav\">\n");
      out.write("              <li><a href=\"facturacion.jsp\">Facturación</a></li>\n");
      out.write("              <li><a href=\"inventario.jsp\">Inventario</a></li>\n");
      out.write("              <li><a href=\"reportes.jsp\">Reportes</a></li>\n");
      out.write("              <li><a href=\"respaldo.jsp\">Respaldo</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        \n");
      out.write("        </div><!--/sidebar-->\n");
      out.write("        <div class=\"col-xs-12 col-sm-9\" data-spy=\"scroll\" data-target=\"#sidebar-nav\">\n");
      out.write("            <br/>\n");
      out.write("            <h2> RESTOCK!</h2>\n");
      out.write("            <br/>\n");
      out.write("            <img class=\"divimg\" src=\"img/restock.jpg\">\n");
      out.write("        <form action=\"crearUsuario\" class=\"ui form segment\"  method=\"post\"> \n");
      out.write("            <label for=\"male\">ID PRODUCTO</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\"  NAME = \"nombre\" TYPE = \"text\" id=\"nombre\"> <br/>\n");
      out.write("            <label for=\"male\">CANTIDAD</label> <br/>\n");
      out.write("            <INPUT class =\"tb1\" NAME = \"apellido\" TYPE = \"text\" id=\"apellido\" > <br/>\n");
      out.write("            <label for=\"male\">Tipo Transacción</label> <br/> \n");
      out.write("                <SELECT class =\"tb1\" NAME=\"selCombo\" SIZE=1 onChange=\"this.form);\"> \n");
      out.write("                    <OPTION VALUE=\"CREDITO\">CRÉDITO</OPTION>\n");
      out.write("                    <OPTION VALUE=\"DEBITO\">DÉBITO</OPTION>\n");
      out.write("                </SELECT> <br/>\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"RE-STOCK\">\n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("              <table id=\"example\" class=\"display\" cellspacing=\"0\" width=\"100%\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("            <td>id  </td>\n");
      out.write("            <td>Producto  </td>\n");
      out.write("            <td>Descripcion  </td>\n");
      out.write("            <td>Precio  </td>\n");
      out.write("            <td>Marca  </td>\n");
      out.write("            <td>Categoria  </td>\n");
      out.write("            <td>Cantidad  </td>\n");
      out.write("            <td>Minimo  </td>\n");
      out.write("            <td>Bodega  </td>\n");
      out.write("            </tr>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("     \n");
      out.write("        ");

        oracleConn con = new oracleConn();
        LinkedList<inventario> lista = con.getInventario();
        for (int i=0;i<lista.size();i++)
        {
        out.println("<tr>");
        out.println("<td>"+lista.get(i).getId()+"</td>");
        out.println("<td>"+lista.get(i).getProducto()+"</td>");
        out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
        out.println("<td>"+lista.get(i).getPrecio()+"</td>");
        out.println("<td>"+lista.get(i).getMarca()+"</td>");
        out.println("<td>"+lista.get(i).getCategoria()+"</td>");
        out.println("<td>"+lista.get(i).getCantidad()+"</td>");
        out.println("<td>"+lista.get(i).getMinimo()+"</td>");
        out.println("<td>"+lista.get(i).getBodega()+"</td>");
        out.println("</tr>");
        }
        
      out.write("\n");
      out.write("        </tbody>\n");
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
