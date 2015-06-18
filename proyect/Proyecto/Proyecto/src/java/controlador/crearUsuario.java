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
import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author Emmanuel
 */
@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
    public crearUsuario(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                
                String nombreUsuario = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String cedula = request.getParameter("cedula");
                String pais = request.getParameter("pais");
                String provincia = request.getParameter("provincia");
                String canton = request.getParameter("canton");
                String direccion = request.getParameter("direccion");
                String numero = request.getParameter("telefono");
                String tipo = request.getParameter("tipo");
                String email = request.getParameter("email");
                oracleConn conect;
                conect = new oracleConn();

        try {
            conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

                response.sendRedirect(response.encodeRedirectURL("crearUsuario.jsp"));
    }
    
   
    
}
