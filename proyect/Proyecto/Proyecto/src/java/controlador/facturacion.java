package controlador;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/facturacion")
public class facturacion extends HttpServlet{ 
    public facturacion(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String contextPath = request.getContextPath();
        String IdProducto = request.getParameter("IdProducto");
        String Descuento = request.getParameter("descuento");
        String Cantidad = request.getParameter("Cantidad");
        
        if(Descuento.length() == 0){
            int cant = Integer.parseInt(Cantidad);
            listaProductos lista = new listaProductos();
            lista.setProducto(IdProducto, cant);
            List<productosVendidos> lista2 = lista.getlista();
            oracleConn conect;
            conect = new oracleConn();
            try {
                conect.ActualizarInventario(IdProducto, Cantidad);
            } catch (SQLException ex) {
                System.out.print("Error");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(lista2.size());
        }
        else{
            System.out.print("no cargue la lista");
            oracleConn conect;
            conect = new oracleConn();
            /*try {
                conect.crearFactura(IdPuntoVenta,Descuento);
            } catch (SQLException ex) {
                System.out.print("Error");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }  */
        }
        response.sendRedirect(response.encodeRedirectURL("facturacion.jsp"));
    }  
}