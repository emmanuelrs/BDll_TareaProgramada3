/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.oracleConn.conn;
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
import static javax.management.Query.and;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Emmanuel
 */

@WebServlet("/RESTOCK")
public class RESTOCK {
    public RESTOCK(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String IdProducto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String transaccionP = request.getParameter("selCombo");
        
        int idProduct = Integer.parseInt(IdProducto);
        int cantidadP = Integer.parseInt(cantidad);
        oracleConn conect;
        conect = new oracleConn();
        try{
            conect.reStockManual(idProduct, cantidadP, transaccionP);
            response.sendRedirect(response.encodeRedirectURL("RESTOCK.jsp"));
        }
        catch(SQLException e){
         System.out.println(e);
        }
        
        response.sendRedirect(response.encodeRedirectURL("RESTOCK.jsp"));
}}
