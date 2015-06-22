
<%@page import="controlador.PuntosVenta"%>
<%@page import="controlador.inventario"%>
<%@page import="java.util.LinkedList"%>
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
    <link href="css/FacturacionCSS.css" rel="stylesheet">
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
                <a class="navbar-brand page-scroll" href="index2USR.jsp">iFacture</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="page-scroll" href="verPuntoVentaUSR.jsp">Puntos de Venta</a></li>
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
              <li><a href="facturacionUSR.jsp">Facturación</a></li>
              <li><a href="inventarioUSR.jsp">Inventario</a></li>
              <li><a href="reportesUSR.jsp">Reportes</a></li>
              <li><a href="respaldoUSR.jsp">Respaldo</a></li>
              <li><a href="iFacturaUSR.jsp">Ver Factura</a></li>
            </ul>
          </div>
        </div><!--/sidebar-->
        <div class="col-xs-12 col-sm-9" data-spy="scroll" data-target="#sidebar-nav">
            <br/>
            <h2> Realizar Venta </h2>
            <br/>
            <img class="divimg" src="img/user.png">
        <form action="facturacionUSR" class="ui form segment"  method="post"> 
            <label for="male">Id Producto</label> <br/> 
                <INPUT class ="tb1" NAME = "IdProducto" TYPE = "number" id="IdProducto"> <br/>
            <label for="male">Cantidad</label> <br/> 
                <INPUT class ="tb1" NAME = "Cantidad" TYPE = "number" id="Cantidad"> <br/>
            <input class="myButton" type="submit" value="Agregar"> 
            <br/>
            <label for="male">Punto de Venta</label> <br/> 
                <SELECT class ="tb1" NAME="IdPuntoVenta" SIZE=1 onChange="this.form);">
                    <% LinkedList<PuntosVenta> listaPV = oracleConn.getNombrePuntoVenta();
                    for (int i=0;i<listaPV.size();i++){
                    out.println("<option value =" + listaPV.get(i).getNombre()+ ">" + listaPV.get(i).getNombre() +"</option>");
                    }
                    %>
                </select> <br/>
            <label for="male">%de descuento</label> <br/> 
                <SELECT class ="tb1" NAME="descuento" SIZE=1 onChange="this.form);"> 
                    <OPTION VALUE="0">0%</OPTION>
                    <OPTION VALUE="10">10%</OPTION>
                    <OPTION VALUE="20">20%</OPTION>
                    <OPTION VALUE="30">30%</OPTION>
                    <OPTION VALUE="40">40%</OPTION>
                    <OPTION VALUE="50">50%</OPTION>
                    <OPTION VALUE="60">60%</OPTION>
                    <OPTION VALUE="70">70%</OPTION>
                    <OPTION VALUE="80">80%</OPTION>
                    <OPTION VALUE="90">90%</OPTION>
                    <OPTION VALUE="100">100%</OPTION>
                </SELECT> <br/>
                <label for="male">Cedula del Cliente</label> <br/> 
                <INPUT class ="tb1" NAME = "Cedula" TYPE = "number" id="Cedula"> <br/>
                <input type="checkbox" name="id" value="id"> Confirmar Venta<BR>
            <input class="myButton" type="submit" value="Vender"><input class="myButton" type="submit" value="Cancelar Venta">
        </form>
            
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

</html>
