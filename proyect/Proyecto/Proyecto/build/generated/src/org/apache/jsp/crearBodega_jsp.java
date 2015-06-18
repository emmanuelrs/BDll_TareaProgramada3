package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearBodega_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>iFacture</title>\n");
      out.write("    <meta name=\"generator\" content=\"Bootply\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/crearBodegaCSS.css\" rel=\"stylesheet\">\n");
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
      out.write("                <a class=\"navbar-brand page-scroll\" href=\"index.jsp\">iFacture</a>\n");
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
      out.write("            <h2> Crear nueva Bodega </h2>\n");
      out.write("            <br/>\n");
      out.write("            <img class=\"divimg\" src=\"img/bodega.jpg\">\n");
      out.write("        <form action=\"newProduct\" class=\"ui form segment\"  method=\"post\"> \n");
      out.write("            <label for=\"male\">Nombre de la Bodega: </label> <br/>\n");
      out.write("                <INPUT NAME = \"nombre\" TYPE = \"text\" id=\"nombre\" > <br/>\n");
      out.write("            <label for=\"male\">País </label> <br/>\n");
      out.write("                <INPUT NAME = \"pais\" TYPE = \"text\" id=\"pais\" > <br/>\n");
      out.write("            <label for=\"male\">Provincia </label> <br/>                   \n");
      out.write("                <INPUT NAME = \"provincia\" TYPE = \"text\" id=\"provincia\"> <br/>\n");
      out.write("            <label for=\"male\">Canton </label> <br/> \n");
      out.write("                <INPUT NAME = \"canton\" TYPE = \"text\" id=\"canton\"> <br/>\n");
      out.write("            <label for=\"male\">Dirección Exacta</label> <br/> \n");
      out.write("                <INPUT NAME = \"direccion\" TYPE = \"text\" id=\"direccion\"> <br/>\n");
      out.write("            <label for=\"male\">Número de Teléfono</label> <br/> \n");
      out.write("                <INPUT NAME = \"telefono\" TYPE = \"text\" id=\"telefono\"> <br/>          \n");
      out.write("            <br/>\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"Crear\"> </form>\n");
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
