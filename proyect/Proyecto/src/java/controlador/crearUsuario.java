
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Imports necerios para la clase
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//WebServlet y el constructor de la clase
@WebServlet("/crearUsuario")
public class crearUsuario extends HttpServlet {
    public crearUsuario(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                //Lee los datos que se reciben desde la aplicación Web
                String nombreUsuario = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String cedula = request.getParameter("cedula");
                String pais = request.getParameter("pais");
                String provincia = request.getParameter("provincia");
                String canton = request.getParameter("canton");
                String direccion = request.getParameter("direccion");
                String numero = request.getParameter("telefono");
                String tipo = request.getParameter("selCombo");
                String email = request.getParameter("email");
                String usr = request.getParameter("userName");
                String pas = request.getParameter("pass");
                Integer lgtUSR = usr.length();
                Integer lgtPASS = pas.length();
                int ced = Integer.parseInt(cedula);
                //Conexión con la  base de datos Oracle
                oracleConn conect;
                conect = new oracleConn();
        if(lgtUSR == 0  & lgtPASS == 0){
           try {
                //Si se regstra un usuario sin username o password se llama a esta
               //función para registrar el usuario.
                conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
            } catch (SQLException ex) {
                System.out.print("Error");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        try {
                //Si el usuario envía un username y password aparte de crearlo
                //también se le crea un user para el uso de la aplicación
                conect.crearUsuario(nombreUsuario,cedula,apellido, pais, provincia,canton,direccion,email,numero,tipo);
                conect.crearUsuario2(ced, pas, tipo, usr);
            } catch (SQLException ex) {
                System.out.print("Error2");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            } 
                response.sendRedirect(response.encodeRedirectURL("crearUsuario.jsp"));
    }
}
    

