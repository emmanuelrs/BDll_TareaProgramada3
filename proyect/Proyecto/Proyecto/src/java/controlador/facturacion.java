/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/facturacion")
public class facturacion extends HttpServlet{ 
    public facturacion(){
        super();
    }
    /*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
		String factura = request.getParameter("numFactura");
		String Idproducto = request.getParameter("IdProducto");
		String cantidad = request.getParameter("Cantidad");
                oracleConn conect;
                conect = new oracleConn();
        try {
            conect.agregarProducto(factura, Idproducto, cantidad);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
    }*/
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String contextPath = request.getContextPath();
        String IdPuntoVenta = request.getParameter("IdPV");
        String Descuento = request.getParameter("descuento");
        oracleConn conect;
        conect = new oracleConn();
        try {
            conect.crearFactura(IdPuntoVenta,Descuento);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
                response.sendRedirect(response.encodeRedirectURL("facturacion.jsp"));
    }  
}