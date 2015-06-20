/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emmanuel
 */
@WebServlet("/registrarUser")
public class registrarUser extends HttpServlet{
    public registrarUser(){
        super();
    }
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                
                String cedula = request.getParameter("cedula");
                String userName = request.getParameter("userName");
                String contrasena = request.getParameter("constraseña");
                String tipo = request.getParameter("tipo");
               
                int ced = Integer.parseInt(cedula);
                oracleConn conect;
                conect = new oracleConn();
                try{
                    conect.agregarUser(ced, contrasena, tipo, userName);
                }
                catch(Exception e){
                    System.out.println(e);
                    
                }
    }
}
