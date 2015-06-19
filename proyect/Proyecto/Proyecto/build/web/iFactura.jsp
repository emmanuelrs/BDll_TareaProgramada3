<%-- 
    Document   : iFactura
    Created on : Jun 19, 2015, 5:16:25 PM
    Author     : Emmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
          <h1>1</h1>
        </div>
      </div>
      <table border="0" cellspacing="0" cellpadding="0">
        <thead>
          <tr>
            <th class="no">#</th>
            <th class="desc">DESCRIPCIÓN</th>
            <th class="unit">PRECIO</th>
            <th class="qty">CANTIDAD</th>
            <th class="total">TOTAL</th>
          </tr>
        </thead>
        <tbody> <!-- CÓDIGO JAVA-->
          <tr>
            <td class="no">01</td>
            <td class="desc"><h3>Website Design</h3>Creating a recognizable design solution based on the company's existing visual identity</td>
            <td class="unit">$40.00</td>
            <td class="qty">30</td>
            <td class="total">$1,200.00</td>
          </tr>
          <tr>
            <td class="no">02</td>
            <td class="desc"><h3>Website Development</h3>Developing a Content Management System-based Website</td>
            <td class="unit">$40.00</td>
            <td class="qty">80</td>
            <td class="total">$3,200.00</td>
          </tr>
          <tr>
            <td class="no">03</td>
            <td class="desc"><h3>Search Engines Optimization</h3>Optimize the site for search engines (SEO)</td>
            <td class="unit">$40.00</td>
            <td class="qty">20</td>
            <td class="total">$800.00</td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">SUBTOTAL</td>
            <td>$5,200.00</td>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">DESCUENTO %</td>
            <td>$1,300.00</td>
          </tr>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">TOTAL A PAGAR</td>
            <td>$6,500.00</td>
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
