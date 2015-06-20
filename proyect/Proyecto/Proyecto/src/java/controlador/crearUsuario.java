/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                String usr = request.getParameter("userName");
                String pas = request.getParameter("pass");
                Integer lgtUSR = usr.length();
                Integer lgtPASS = pas.length();
                int ced = Integer.parseInt(cedula);
                oracleConn conect;
                conect = new oracleConn();
        if(lgtUSR == 0  & lgtPASS == 0){
           try {
                conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
            } catch (SQLException ex) {
                System.out.print("Error");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        try {
                conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
                conect.crearUsuario2(ced, pas, tipo, usr);
            } catch (SQLException ex) {
                System.out.print("Error2");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            } 
                response.sendRedirect(response.encodeRedirectURL("crearUsuario.jsp"));
    }
}
    

