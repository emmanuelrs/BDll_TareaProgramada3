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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>iFacture - Usuario</title>\n");
      out.write("    <meta name=\"generator\" content=\"Bootply\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/crearUserCSS.css\" rel=\"stylesheet\">\n");
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
      out.write("                   <!-- <li><a class=\"page-scroll\" href=\"facturacion.jsp\">Facturación</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"inventario.jsp\">Inventario</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"reportes.jsp\">Reportes</a></li>\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"respaldo.jsp\">Respaldo</a></li> -->\n");
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
      out.write("        <img class=\"divimg\" src=\"img/user.png\">\n");
      out.write("        <div class=\"col-xs-18 col-sm-9\" data-spy=\"scroll\" data-target=\"#sidebar-nav\">\n");
      out.write("            <br/>\n");
      out.write("            <h2> Agregar un nuevo Proveedor/Cliente </h2>\n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("        <form action=\"crearUsuario\" class=\"ui form segment\"  method=\"post\"> \n");
      out.write("            <label for=\"male\">Nombre</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\"  NAME = \"nombre\" TYPE = \"text\" id=\"nombre\" required> <br/>\n");
      out.write("            <label for=\"male\">Apellido</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"apellido\" TYPE = \"text\" id=\"apellido\" required> <br/>\n");
      out.write("            <label for=\"male\">Cédula</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"cedula\" TYPE = \"number\" id=\"cedula\" required> <br/>\n");
      out.write("            <label for=\"male\">País</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\" NAME = \"pais\" TYPE = \"text\" id=\"pais\" required > <br/>\n");
      out.write("            <label for=\"male\">Provincia</label> <br/>                   \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"provincia\" TYPE = \"text\" id=\"provincia\" required> <br/>\n");
      out.write("            <label for=\"male\">Canton</label> <br/> \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"canton\" TYPE = \"text\" id=\"canton\" required> <br/>\n");
      out.write("            <label for=\"male\">Dirección Exacta</label> <br/> \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"direccion\" TYPE = \"text\" id=\"direccion\" required> <br/>\n");
      out.write("            <label for=\"male\">Email</label> <br/>\n");
      out.write("                <INPUT class =\"tb1\"  NAME = \"email\" TYPE = \"text\" id=\"email\" required> <br/>\n");
      out.write("            <label for=\"male\">Número de Teléfono</label> <br/> \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"telefono\" TYPE = \"number\" id=\"telefono\" required> <br/>\n");
      out.write("            <label for=\"male\">Tipo</label> <br/> \n");
      out.write("                <SELECT class =\"tb1\" NAME=\"selCombo\" SIZE=1 onChange=\"this.form);\"> \n");
      out.write("                    <OPTION VALUE=\"ADMINISTRADOR\">Administrador</OPTION>\n");
      out.write("                    <OPTION VALUE=\"VENDEDOR\">Vendedor</OPTION>\n");
      out.write("                    <OPTION VALUE=\"CLIENTE\">Cliente</OPTION>\n");
      out.write("                    <OPTION VALUE=\"PROVEEDOR\">Proveedor</OPTION> \n");
      out.write("                </SELECT> <br/>\n");
      out.write("                <br/>\n");
      out.write("            <label for=\"male\">Si el tipo de Usuario es Vendedor o Administrador favor rellenar los siguientes campos</label> <br/> \n");
      out.write("            <label for=\"male\">UserName</label> <br/> \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"userName\" TYPE = \"text\" id=\"userName\"> <br/>\n");
      out.write("            <label for=\"male\">Password</label> <br/> \n");
      out.write("                <INPUT class =\"tb1\" NAME = \"pass\" TYPE = \"password\" id=\"pass\"> <br/>\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"Crear\">\n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("    </\n");
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
