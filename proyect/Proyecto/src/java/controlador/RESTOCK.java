
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Clase de punto de venta, almacena los datos de punto de ventas
//Para ser utilizados en la aplicación para guardarlos y mostrarlos en pantalla.

// Imports necesarios.
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Llamado al WebServlet
@WebServlet("/RESTOCK")

//Esta clase realiza el 'restock' manual de los productos cuando el usuario 
// lo desee, existe dentro del la aplicación una función que hace el restock
//automáticamente cuando un producto sea menor o igual al minínimo.

public class RESTOCK extends HttpServlet {
    //Constructor de la clase que extiende de HtpServlet
    public RESTOCK(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Utilizando el request.getParameter el Servlet lee datos en la aplicación
        // para ser utilizados en la lógica del mismo
        String IdProducto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String transaccionP = request.getParameter("selCombo");
        System.out.print("id Product > " + IdProducto + "cantidad > " +cantidad + "tipo transaccion > " + transaccionP);
        //Convierte los Strings de lee en ints ya que así se necesita
        int idProduct = Integer.parseInt(IdProducto);
        int cantidadP = Integer.parseInt(cantidad);
        // Conexión con la base de datos Oracle 12c
        oracleConn conect;
        conect = new oracleConn();
        try{
             //Llamado al procedimiento para hacer los pedidos manualmente
            conect.reStockManual(idProduct, cantidadP, transaccionP);
            response.sendRedirect(response.encodeRedirectURL("RESTOCK.jsp"));
        }
        catch(SQLException | IOException e){
         System.out.println(e);
        }
    }
}
