<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import = "controlador.oracleConn"%> 
<%@ page import = "controlador.inventario"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>iFacture</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/inventarioCss.css" rel="stylesheet">
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
                    <li><a class="page-scroll" href="newProduct.jsp">Nuevo Producto</a></li>
                    <li><a class="page-scroll" href="bodega.jsp">Bodegas</a></li>
                    <li><a class="page-scroll" href="crearBodega.jsp">Crear Bodega</a></li>
                    <li><a class="page-scroll" href="RESTOCK.jsp">RESTOCK</a></li>
                    
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
              <li><a href="RESTOCK.jsp">RESTOCK</a></li>
            </ul>
          </div>
        </div><!--/sidebar-->
        <h1>Inventario</h1>
        <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
            <td>id  </td>
            <td>Producto  </td>
            <td>Descripcion  </td>
            <td>Precio  </td>
            <td>Marca  </td>
            <td>Categoria  </td>
            <td>Cantidad  </td>
            <td>Minimo  </td>
            <td>Bodega  </td>
            </tr>
            </tr>
        </thead>
        <tbody>
     
        <%
        oracleConn con = new oracleConn();
        LinkedList<inventario> lista = con.getInventario();
        for (int i=0;i<lista.size();i++)
        {
        out.println("<tr>");
        out.println("<td>"+lista.get(i).getId()+"</td>");
        out.println("<td>"+lista.get(i).getProducto()+"</td>");
        out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
        out.println("<td>"+lista.get(i).getPrecio()+"</td>");
        out.println("<td>"+lista.get(i).getMarca()+"</td>");
        out.println("<td>"+lista.get(i).getCategoria()+"</td>");
        out.println("<td>"+lista.get(i).getCantidad()+"</td>");
        out.println("<td>"+lista.get(i).getMinimo()+"</td>");
        out.println("<td>"+lista.get(i).getBodega()+"</td>");
        out.println("</tr>");
        }
        %>
        </tbody>
        </table>
      </
</html>
