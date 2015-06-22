package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.Persona;
import java.util.LinkedList;
import controlador.bodega;
import controlador.oracleConn;
import controlador.oracleConn;

public final class newProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <li><a class=\"page-scroll\" href=\"bodega.jsp\">Bodegas</a></li>\r\n");
      out.write("                    <li><a class=\"page-scroll\" href=\"crearBodega.jsp\">Crear Bodega</a></li>\r\n");
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
      out.write("        <div class=\"col-xs-12 col-sm-9\" data-spy=\"scroll\" data-target=\"#sidebar-nav\">\r\n");
      out.write("            <br/>\r\n");
      out.write("            <h2> Ingresar Nuevo Producto </h2>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <img class=\"divimg\" src=\"img/productos.png\">\r\n");
      out.write("        <form action=\"newProduct\" class=\"ui form segment\"  method=\"post\"> \r\n");
      out.write("            <label for=\"male\">Nombre del producto: </label> <br/>\r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"nombre\" TYPE = \"text\" id=\"nombre\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Descripcion del producto: </label> <br/>\r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"descripcion\" TYPE = \"text\" id=\"descripcion\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Precio: </label> <br/>                   \r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"precio\" TYPE = \"text\" id=\"precio\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Marca: </label> <br/> \r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"marca\" TYPE = \"text\" id=\"marca\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Tipo de producto: </label> <br/> \r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"categoria\" TYPE = \"text\" id=\"categoria\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Total de Unidades: </label> <br/> \r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"cantidad\" TYPE = \"text\" id=\"cantidad\" required> <br/>\r\n");
      out.write("            <label for=\"male\">Minimo para Reordenar:</label> <br/>  \r\n");
      out.write("                <INPUT class=\"tb1\" NAME = \"minimo\" TYPE = \"text\" id=\"minimo\" required> <br/>           \r\n");
      out.write("            <label for=\"male\">Bodega donde se encuentra:</label> <br/>  \r\n");
      out.write("                <SELECT class =\"tb1\" NAME=\"NOMBRE_BODEGA\" SIZE=1 onChange=\"this.form);\">\r\n");
      out.write("                    ");
 LinkedList<bodega> lista = oracleConn.getBodega();
                    for (int i=0;i<lista.size();i++){
                    out.println("<option value =" + lista.get(i).getNombre()+ ">" + lista.get(i).getNombre() + "</option>");
                    }
                    
      out.write("\r\n");
      out.write("                </select> <br/>\r\n");
      out.write("            <label for=\"male\">Cedula del provedor:</label> <br/>  \r\n");
      out.write("                <SELECT class =\"tb1\" NAME=\"ced\" SIZE=1 onChange=\"this.form);\">\r\n");
      out.write("                    ");
 LinkedList<Persona> listaP = oracleConn.getPersona();
                    for (int i=0;i<listaP.size();i++){
                    out.println("<option value =" + listaP.get(i).getCed()+ ">" + listaP.get(i).getNombre() + " " + listaP.get(i).getApellido() + "</option>");
                    }
                    
      out.write("\r\n");
      out.write("                </select> <br/>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <input class=\"myButton\" type=\"submit\" value=\"submit\"> </form>\r\n");
      out.write("</\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
