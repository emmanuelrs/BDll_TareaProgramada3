package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.contenidoFactura;
import java.util.LinkedList;
import controlador.oracleConn;

public final class iFacturaManual_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>iFacture</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/Facturastyle.css\" media=\"all\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <header class=\"clearfix\">\n");
      out.write("      <div id=\"logo\">\n");
      out.write("        <img src=\"img/logoFac.png\">\n");
      out.write("      </div>\n");
      out.write("      <div id=\"company\">\n");
      out.write("        <h2 class=\"name\">FacturaTEC</h2>\n");
      out.write("        <div>San José, Costa Rica</div>\n");
      out.write("        <div>(506) 800-900-FacturaTÉ</div>\n");
      out.write("        <div><a href=\"mailto:company@example.com\">staff@facturaTEC.com</a></div>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("    <main>\n");
      out.write("      <div id=\"details\" class=\"clearfix\">\n");
      out.write("        <div id=\"invoice\">\n");
      out.write("          <h1>FACTURA</h1> <!-- Código java aqui -->\n");
      out.write("          ");

              oracleConn con = new oracleConn();
              out.println("<h1>"+"Número"+" "+con.IdFactura() + "</h1>");
          
      out.write("\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("        <thead>\n");
      out.write("          <tr>\n");
      out.write("            <th class=\"no\">#</th>\n");
      out.write("            <th class=\"desc\">DESCRICIÓN</th>\n");
      out.write("            <th class=\"unit\">PRECIO POR UNIDAD</th>\n");
      out.write("            <th class=\"qty\">CANTIDAD</th>\n");
      out.write("            <th class=\"total\">TOTAL</th>\n");
      out.write("          </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody> <!-- CÓDIGO JAVA-->\n");
      out.write("         ");

              oracleConn ora1 = new oracleConn();
              LinkedList<contenidoFactura> listaP = con.getProductosFactura();
              for(int i = 0; i < listaP.size();i ++){
                  out.println("<tr>");
                  out.println("<td class='no'>"+(i+1)+"</td>");
                  out.println("<td class='desc'><h3>"+listaP.get(i).getNombreP()+"</h3>"+listaP.get(i).getDescripcion()+"</td>");
                  out.println("<td class='unit'>"+"₡"+listaP.get(i).getPrecio()+"</td>");
                  out.println("<td class='qty'>"+listaP.get(i).getCantidad()+"</td>");
                  out.println("<td class='total'>"+"₡"+listaP.get(i).getTotalC()+"</td>");
                  out.println("</tr>");
                  }
            
      out.write("\n");
      out.write("         \n");
      out.write("        </tbody>\n");
      out.write("        <tfoot>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("            <td colspan=\"2\">DESCUENTO %</td>\n");
      out.write("            ");

              oracleConn ora3 = new oracleConn();
              out.println("<td>" + ora3.totalDescuento()+"</td>");
            
      out.write("\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("            <td colspan=\"2\">TOTAL A PAGAR</td>\n");
      out.write("            ");

              oracleConn ora2 = new oracleConn();
              out.println("<td> ₡" + ora2.totalPagarManual(4)+"</td>");
            
      out.write("\n");
      out.write("          </tr>\n");
      out.write("        </tfoot>\n");
      out.write("      </table>\n");
      out.write("      <div id=\"thanks\">¡MUCHAS GRACIAS!</div>\n");
      out.write("      <div id=\"notices\">\n");
      out.write("        <div>NOTICE:</div>\n");
      out.write("        <div class=\"notice\">GRACIAS POR UTILIZAR NUESTRO SOFTWARE DE VENTAS!</div>\n");
      out.write("        <footer>\n");
      out.write("      LA FACTURA ES VÁLIDA SOLO SI SE FIRMA POR ALGÚN MIEMBRO DEL STAFF!\n");
      out.write("    </footer>\n");
      out.write("      </div>\n");
      out.write("    </main>\n");
      out.write("    \n");
      out.write("  </body>\n");
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
