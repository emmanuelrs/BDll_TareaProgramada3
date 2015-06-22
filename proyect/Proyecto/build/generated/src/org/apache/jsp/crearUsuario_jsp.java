package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class crearUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>iFacture - Usuario</title>\r\n");
      out.write("    <meta name=\"generator\" content=\"Bootply\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/crearUserCSS.css\" rel=\"stylesheet\">\r\n");
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
      out.write("                   <!-- <li><a class=\"page-scroll\" href=\"facturacion.jsp\">Facturación</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"inventario.jsp\">Inventario</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"reportes.jsp\">Reportes</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"respaldo.jsp\">Respaldo</a></li> -->\r\n");
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
      out.write("        \r\n");
      out.write("        </div><!--/sidebar-->\r\n");
      out.write("        <img class=\"divimg\" src=\"img/user.png\">\r\n");
      out.write("        <div class=\"col-xs-18 col-sm-9\" data-spy=\"scroll\" data-target=\"#sidebar-nav\">\r\n");
      out.write("            <br/>\r\n");
      out.write("            <h2> Agregar un nuevo Proveedor/Cliente </h2>\r\n");
      out.write("            <br/>\r\n");
      out.write("            \r\n");
      out.write("        <form action=\"crearUsuario\" class=\"ui form segment\"  method=\"post\"> \r\n");
      out.write("            <label for=\"male\">Nombre</label> <br/>\r\n");
      out.write("                <INPUT class =\"tb1\"  NAME = \"nombre\" TYPE = \"text\" id=\"nombre\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Apellido</label> <br/>\r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"apellido\" TYPE = \"text\" id=\"apellido\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Cédula</label> <br/>\r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"cedula\" TYPE = \"text\" id=\"cedula\" required> <br/>\r\n");
      out.write("            <label for=\"male\">País</label> <br/>\r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"pais\" TYPE = \"text\" id=\"pais\" required > <br/>\r\n");
      out.write("            <label for=\"male\">Provincia</label> <br/>                   \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"provincia\" TYPE = \"text\" id=\"provincia\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Canton</label> <br/> \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"canton\" TYPE = \"text\" id=\"canton\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Dirección Exacta</label> <br/> \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"direccion\" TYPE = \"text\" id=\"direccion\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Email</label> <br/>\r\n");
      out.write("                <INPUT class =\"tb1\"  NAME = \"email\" TYPE = \"text\" id=\"email\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Número de Teléfono</label> <br/> \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"telefono\" TYPE = \"text\" id=\"telefono\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Tipo</label> <br/> \r\n");
      out.write("                <SELECT class =\"tb1\" NAME=\"selCombo\" SIZE=1 onChange=\"this.form);\"> \r\n");
      out.write("                    <OPTION VALUE=\"ADMINISTRADOR\">Administrador</OPTION>\r\n");
      out.write("                    <OPTION VALUE=\"VENDEDOR\">Vendedor</OPTION>\r\n");
      out.write("                    <OPTION VALUE=\"CLIENTE\">Cliente</OPTION>\r\n");
      out.write("                    <OPTION VALUE=\"PROVEEDOR\">Proveedor</OPTION> \r\n");
      out.write("                </SELECT> <br/>\r\n");
      out.write("                <label for=\"male\">Si el tipo de Usuario es Vendedor o Administrador favor rellenar los siguientes campos</label> <br/> \r\n");
      out.write("            <label for=\"male\">UserName</label> <br/> \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"userName\" TYPE = \"text\" id=\"userName\"> <br/>\r\n");
      out.write("            <label for=\"male\">Password</label> <br/> \r\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"pass\" TYPE = \"password\" id=\"pass\"> <br/>\r\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"Crear\">\r\n");
      out.write("           \r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
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
