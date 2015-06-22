
<%@page import="java.util.LinkedList"%>
<%@page import="controlador.PuntoDeVenta"%>
<%@page import="controlador.oracleConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>iFacture</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/crearUserCSS.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="datables/media/css/jquery.dataTables.css">
        

    
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
            <h2> Crear Punto de Venta </h2>
            <br/>
        <form action="crearPuntoVenta" class="ui form segment"  method="post"> 
            <label for="male">Nombre del punto de veta: </label> <br/>
                <INPUT class="tb1" NAME = "nombre" TYPE = "text" id="nombre" required> <br/>
            <label for="male">Pais: </label> <br/>
                <INPUT class="tb1" NAME = "pais" TYPE = "text" id="pais" required> <br/>
            <label for="male">Provincia: </label> <br/>                   
                <INPUT class="tb1" NAME = "provincia" TYPE = "text" id="provincia" required> <br/>
            <label for="male">Canton: </label> <br/> 
                <INPUT class="tb1" NAME = "Canton" TYPE = "text" id="Canton" required> <br/>
            <label for="male">Direccion exacta: </label> <br/> 
                <INPUT class="tb1" NAME = "direccion" TYPE = "text" id="direccion" required> <br/>
            <label for="male">Numero Telefono: </label> <br/> 
                <INPUT class="tb1" NAME = "telefono" TYPE = "number" id="telefono" required> <br/>
            <br/>
            <input class="myButton" type="submit" value="Crear"> </form>
        </div>
       
</
</html>