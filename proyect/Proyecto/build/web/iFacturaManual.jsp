<%-- 
    Document   : iFacturaManual
    Created on : Jun 21, 2015, 3:05:34 PM
    Author     : Emmanuel
--%>

<%@page import="controlador.contenidoFactura"%>
<%@page import="java.util.LinkedList"%>
<%@page import="controlador.oracleConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
    <title>iFacture</title>
    <link rel="stylesheet" href="css/Facturastyle.css" media="all" />
  </head>
  <body>
    <header class="clearfix">
      <div id="logo">
        <img src="img/logoFac.png">
      </div>
      <div id="company">
        <h2 class="name">FacturaTEC</h2>
        <div>San José, Costa Rica</div>
        <div>(506) 800-900-FacturaTÉ</div>
        <div><a href="mailto:company@example.com">staff@facturaTEC.com</a></div>
      </div>
      </div>
    </header>
    <main>
      <div id="details" class="clearfix">
        <div id="invoice">
          <h1>FACTURA</h1> <!-- Código java aqui -->
          <%
              oracleConn con = new oracleConn();
              out.println("<h1>"+"Número"+" "+con.IdFactura() + "</h1>");
          %>
          
        </div>
      </div>
      <table border="0" cellspacing="0" cellpadding="0">
        <thead>
          <tr>
            <th class="no">#</th>
            <th class="desc">DESCRICIÓN</th>
            <th class="unit">PRECIO POR UNIDAD</th>
            <th class="qty">CANTIDAD</th>
            <th class="total">TOTAL</th>
          </tr>
        </thead>
        <tbody> <!-- CÓDIGO JAVA-->
         <%
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
            %>
         
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2"></td>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">DESCUENTO %</td>
            
            <%
              oracleConn ora3 = new oracleConn();
              out.println("<td>" + ora3.totalDescuento()+"</td>");
            %>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">TOTAL A PAGAR</td>
            <% 
              String res = request.getParameter("idfact")!=null?request.getParameter("tab"):"";
              int idF = Integer.parseInt(res); 
              oracleConn ora2 = new oracleConn();
              out.println("<td> ₡" + ora2.totalPagarManual(idF)+"</td>");
            %>
           
          </tr>
        </tfoot>
      </table>
      <div id="thanks">¡MUCHAS GRACIAS!</div>
      <div id="notices">
        <div>NOTICE:</div>
        <div class="notice">GRACIAS POR UTILIZAR NUESTRO SOFTWARE DE VENTAS!</div>
        <footer>
      LA FACTURA ES VÁLIDA SOLO SI SE FIRMA POR ALGÚN MIEMBRO DEL STAFF!
    </footer>
      </div>
    </main>
    
  </body>
</html>
