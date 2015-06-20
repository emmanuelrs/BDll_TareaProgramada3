<%-- 
    Document   : newProduct
    Created on : 16-jun-2015, 21:54:32
    Author     : LUIS
--%>


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
    <link href="css/crearUserCSS.css" rel="stylesheet">
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
                <a class="navbar-brand page-scroll" href="index.jsp">iFacture</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="page-scroll" href="bodega.jsp">Bodegas</a></li>
                    <li><a class="page-scroll" href="crearBodega.jsp">Crear Bodega</a></li>
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
            <h2> Ingresar Nuevo Producto </h2>
            <br/>
            <img class="divimg" src="img/productos.png">
        <form action="newProduct" class="ui form segment"  method="post"> 
            <label for="male">Nombre del producto: </label> <br/>
                <INPUT class="tb1" NAME = "nombre" TYPE = "text" id="nombre" > <br/>
            <label for="male">Descripcion del producto: </label> <br/>
                <INPUT class="tb1" NAME = "descripcion" TYPE = "text" id="descripcion" > <br/>
            <label for="male">Precio: </label> <br/>                   
                <INPUT class="tb1" NAME = "precio" TYPE = "text" id="precio"> <br/>
            <label for="male">Marca: </label> <br/> 
                <INPUT class="tb1" NAME = "marca" TYPE = "text" id="marca"> <br/>
            <label for="male">Tipo de producto: </label> <br/> 
                <INPUT class="tb1" NAME = "categoria" TYPE = "text" id="categoria"> <br/>
            <label for="male">Total de Unidades: </label> <br/> 
                <INPUT class="tb1" NAME = "cantidad" TYPE = "text" id="cantidad"> <br/>
            <label for="male">Minimo para Reordenar:</label> <br/>  
                <INPUT class="tb1" NAME = "minimo" TYPE = "text" id="minimo"> <br/>           
            <label for="male">Bodega donde se encuentra:</label> <br/>  
                <INPUT class="tb1" NAME = "NOMBRE_BODEGA" TYPE = "text" id="NOMBRE_BODEGA"> <br/>
            <label for="male">Cedula del provedor:</label> <br/>  
                <INPUT class="tb1" NAME = "ced" TYPE = "text" id="ced"> <br/>
            <br/>
            <input class="myButton" type="submit" value="submit"> </form>
</
</html>
