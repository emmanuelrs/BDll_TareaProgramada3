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

@WebServlet("/crearBodega")
public class crearBodega extends HttpServlet{
    
    public crearBodega(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
                String nombreBodega = request.getParameter("nombre");
                String pais = request.getParameter("pais");
                String provincia = request.getParameter("provincia");
                String canton = request.getParameter("canton");
                String direccion = request.getParameter("direccion");
                String numero = request.getParameter("telefono");
                oracleConn conect;
                conect = new oracleConn();

        try {
            conect.crearBodega(nombreBodega,pais,provincia,canton,direccion,numero);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(response.encodeRedirectURL("crearBodega.jsp"));
    }
     
}
    
