<%-- 
    Document   : registrarUser
    Created on : Jun 20, 2015, 8:06:14 AM
    Author     : Emmanuel
--%>

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
                <a class="navbar-brand page-scroll" href="index2.jsp">iFacture - Registrarse</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    
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
          
          </div>
        
        </div><!--/sidebar-->
        <div class="col-xs-12 col-sm-9" data-spy="scroll" data-target="#sidebar-nav">
            <br/>
            <h2> REGISTRARSE </h2>
            <br/>
            <img class="divimg" src="img/user.png">
        <form action="registrarUser" class="ui form segment"  method="post"> 
            <label for="male">CEDULA</label> <br/>
                <INPUT class="tb1" NAME = "cedula" TYPE = "text" id="cedula" > <br/>
            <label for="male">NOMBRE DE USUARIO</label> <br/>
                <INPUT class="tb1" NAME = "userName" TYPE = "text" id="userName" > <br/>
            <label for="male">CONTRASEÑA</label> <br/>                   
                <INPUT class="tb1" NAME = "contraseña" TYPE = "password" id="contraseña"> <br/>
            <label for="male">TIPO</label> <br/> 
                <INPUT class="tb1" NAME = "tipo" TYPE = "text" id="tipo"> <br/>
            <input class="myButton" type="submit" value="submit"> </form>
</html>
