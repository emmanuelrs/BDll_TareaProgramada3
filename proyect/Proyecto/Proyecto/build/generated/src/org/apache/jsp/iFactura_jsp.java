package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class iFactura_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("          <h1>INVOICE 3-2-1</h1> <!-- Código java aqui -->\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("        <thead>\n");
      out.write("          <tr>\n");
      out.write("            <th class=\"no\">#</th>\n");
      out.write("            <th class=\"desc\">DESCRIPCIÓN</th>\n");
      out.write("            <th class=\"unit\">PRECIO</th>\n");
      out.write("            <th class=\"qty\">CANTIDAD</th>\n");
      out.write("            <th class=\"total\">TOTAL</th>\n");
      out.write("          </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody> <!-- CÓDIGO JAVA-->\n");
      out.write("          <tr>\n");
      out.write("            <td class=\"no\">01</td>\n");
      out.write("            <td class=\"desc\"><h3>Website Design</h3>Creating a recognizable design solution based on the company's existing visual identity</td>\n");
      out.write("            <td class=\"unit\">$40.00</td>\n");
      out.write("            <td class=\"qty\">30</td>\n");
      out.write("            <td class=\"total\">$1,200.00</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td class=\"no\">02</td>\n");
      out.write("            <td class=\"desc\"><h3>Website Development</h3>Developing a Content Management System-based Website</td>\n");
      out.write("            <td class=\"unit\">$40.00</td>\n");
      out.write("            <td class=\"qty\">80</td>\n");
      out.write("            <td class=\"total\">$3,200.00</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td class=\"no\">03</td>\n");
      out.write("            <td class=\"desc\"><h3>Search Engines Optimization</h3>Optimize the site for search engines (SEO)</td>\n");
      out.write("            <td class=\"unit\">$40.00</td>\n");
      out.write("            <td class=\"qty\">20</td>\n");
      out.write("            <td class=\"total\">$800.00</td>\n");
      out.write("          </tr>\n");
      out.write("        </tbody>\n");
      out.write("        <tfoot>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("            <td colspan=\"2\">SUBTOTAL</td>\n");
      out.write("            <td>$5,200.00</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("            <td colspan=\"2\">DESCUENTO %</td>\n");
      out.write("            <td>$1,300.00</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td colspan=\"2\"></td>\n");
      out.write("            <td colspan=\"2\">TOTAL A PAGAR</td>\n");
      out.write("            <td>$6,500.00</td>\n");
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
