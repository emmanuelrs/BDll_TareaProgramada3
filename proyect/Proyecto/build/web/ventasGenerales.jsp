<%-- 
    Document   : ventasGenerales
    Created on : Jun 21, 2015, 2:01:09 PM
    Author     : Emmanuel
--%>

<%@page import="controlador.ventas"%>
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
    <link href="css/provedorCSS.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="datables/media/css/jquery.dataTables.css">
        
	<script type="text/javascript" language="javascript" src="datables//media/js/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="datables//media/js/jquery.dataTables.js"></script>
        <script>
            $(document).ready(function() {
            $('#example').DataTable();} );
        </script>
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
                    <li><a class="page-scroll" href="verPuntoVenta.jsp">Puntos de Venta</a></li>
                    <li><a class="page-scroll" href="puntoVenta.jsp">Crear Punto de Venta</a></li>
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
              <li><a href="iFactura.jsp">Ver Factura</a></li>
            </ul>
          </div>
            
        </div><!--/sidebar-->
        <h1>VENTAS GENERALES Y POR PUNTO DE VENTA</h1>
        
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
</html>
