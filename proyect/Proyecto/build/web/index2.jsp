<%-- 
    Document   : index
    Created on : 16-jun-2015, 21:55:43
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>FacturaTEC</title>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">
    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/animate.min.css" type="text/css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">
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
                <a class="navbar-brand page-scroll" href="#page-top">iFacture</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="page-scroll" href="facturacion.jsp">Facturación</a></li>
                    <li><a class="page-scroll" href="inventario.jsp">Inventario</a></li>
                    <li><a class="page-scroll" href="reportes.jsp">Reportes</a></li>
                    <li><a class="page-scroll" href="respaldo.jsp">Respaldo</a></li>
                    <li><a class="page-scroll" href="crearUsuario.jsp">Crear Usuario</a></li>
                    <li><a class="page-scroll" href="infoProvedores.jsp">Provedores</a></li>
                    <li><a class="page-scroll" href="index.jsp">Cerrar Sesion</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Sistema de Facturación y Reportes </h1>
                
                <p></p>
                <a href="index2.jsp" class="btn btn-primary btn-xl page-scroll">Inicio</a>
            </div>
        </div>
    </header>
    
    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Inicio iFacture!</h2>
                <a href="facturacion.jsp" class="btn btn-default btn-xl wow tada">Facturación</a>
                <a href="inventario.jsp" class="btn btn-default btn-xl wow tada">Inventario</a>
                <a href="reportes.jsp" class="btn btn-default btn-xl wow tada">Reportes</a>
                <a href="respaldo.jsp" class="btn btn-default btn-xl wow tada">Respaldo</a>
                <a href="infoProvedores.jsp" class="btn btn-default btn-xl wow tada">Proveedores</a>
            </div>
        </div>
    </aside>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/wow.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>
</body>
</html>
