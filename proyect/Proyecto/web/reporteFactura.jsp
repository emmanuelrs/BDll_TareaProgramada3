
<%@page import="controlador.ventas"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="controlador.oracleConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>iFacture</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/FacturacionCSS.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="datables/media/css/jquery.dataTables.css">
    
    <script type="text/javascript" language="javascript" src="datables//media/js/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="datables//media/js/jquery.dataTables.js"></script>
        <script>
            $(document).ready(function() {
            $('#example').DataTable();} );
        </script>
</head>
<body id="page-top">
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="index2.jsp">iFacture</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                   <!-- <li><a class="page-scroll" href="facturacion.jsp">Facturación</a></li>
                    <li><a class="page-scroll" href="inventario.jsp">Inventario</a></li>
                    <li><a class="page-scroll" href="reportes.jsp">Reportes</a></li>
                    <li><a class="page-scroll" href="respaldo.jsp">Respaldo</a></li> -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
      <div class="container-fluid">
      <div class="row row-offcanvas row-offcanvas-left">
        <!--sidebar-->
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div data-spy="affix" data-offset-top="15" data-offset-bottom="45">
            <ul class="nav" id="sidebar-nav">
              <li><a href="facturacion.jsp">Facturación</a></li>
              <li><a href="inventario.jsp">Inventario</a></li>
              <li><a href="reportes.jsp">Reportes</a></li>
              <li><a href="respaldo.jsp">Respaldo</a></li>
            </ul>
          </div>
        </div><!--/sidebar-->
               <div class="col-xs-12 col-sm-9" data-spy="scroll" data-target="#sidebar-nav">
            <br/>
            <h2>Facturas</h2>
            <br/>
        <form action="reporteFactura" class="ui form segment"  method="post"> 
            <label for="male">ID de la Factura</label> <br/> 
            <INPUT class ="tb1" NAME = "idFactura" TYPE = "number" id="idFactura" required> <br/>
            <br/>
            <input class="myButton" type="submit" value="Ver detalles de la Factura">
        </form>
        <br/> 
        <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
            <td>FACTURA</td>
            <td>NOMBRE</td>
            <td>APELLIDO</td>
            <td>PUNTO DE VENTA</td>
            <td>DESCUENTO</td>
            <td>TOTAL</td>
            </tr>
        </thead>
        <tbody>
     
        <%
        oracleConn con = new oracleConn();
        LinkedList<ventas> lista = con.ventasGeneralesXPV();
        for (int i=0;i<lista.size();i++)
        {
        out.println("<tr>");
        out.println("<td>"+lista.get(i).getFactura()+"</td>");
        out.println("<td>"+lista.get(i).getNombre()+"</td>");
        out.println("<td>"+lista.get(i).getApellido()+"</td>");
        out.println("<td>"+lista.get(i).getPuntoDeVenta()+"</td>");
        out.println("<td>"+lista.get(i).getDescuento()+"</td>");
        out.println("<td>"+lista.get(i).getTotal()+"</td>");
        
        out.println("</tr>");
        }
        %>
        </tbody>
        </table>
        <h3><%//= request.getParameter("nom")!=null?request.getParameter("nom"):""%> </h3>
        <br/> 
    </
</html>
