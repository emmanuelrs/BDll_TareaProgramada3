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

@WebServlet("/crearPuntoVenta")
public class crearPuntoVenta extends HttpServlet{
    public crearPuntoVenta(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                String nombrePV = request.getParameter("nombre");
                String pais = request.getParameter("pais");
                String provincia = request.getParameter("provincia");
                String canton = request.getParameter("Canton");
                String direccion = request.getParameter("direccion");
                String numero = request.getParameter("telefono");
                oracleConn conect;
                conect = new oracleConn();
        try {
            conect.crearPuntoVenta(nombrePV,pais,provincia,canton,direccion,numero);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
                response.sendRedirect(response.encodeRedirectURL("verPuntoVenta.jsp"));
    }
}
