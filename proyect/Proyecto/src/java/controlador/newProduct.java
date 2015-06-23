package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/
//Imports necesarios para la clase
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//SebServlet y el constructor de la clase
@WebServlet("/newProduct")
public class newProduct extends HttpServlet {
    
    public newProduct(){
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
				//Lee los datos que vienen en pantalla
		String producto = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
                String marca = request.getParameter("marca");
                String categoria = request.getParameter("categoria");
                String cantidad = request.getParameter("cantidad");
                String minimo = request.getParameter("minimo");
                String bodega = request.getParameter("NOMBRE_BODEGA");
                String cedu = request.getParameter("ced");
                int ced = Integer.parseInt(cedu);
                producto = producto.toUpperCase();
                descripcion = descripcion.toUpperCase();
                marca = marca.toUpperCase();
                categoria = categoria.toUpperCase();
                bodega = bodega.toUpperCase();
                oracleConn conect;
                conect = new oracleConn();

        try {
                        //Llama al procedimiento que agrega los productos a la base de datos
            conect.insertarProducto(producto, descripcion, precio, marca, categoria, cantidad, minimo, bodega, ced);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
                response.sendRedirect(response.encodeRedirectURL("inventario.jsp"));
    }
}
