
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/
//Imports necesarios
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrarUser")
public class registrarUser extends HttpServlet{
    public registrarUser(){
        super();
    }
    //Esta clase recibe los datos que son enviados por el usuario mediante la aplicación
    //realiza la conexión con la base de datos y ejecuta un procedimiento para
    //agregar el nuevo usuario.
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
