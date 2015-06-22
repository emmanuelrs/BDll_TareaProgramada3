
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RESTOCK")
public class RESTOCK extends HttpServlet {
    public RESTOCK(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String IdProducto = request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        String transaccionP = request.getParameter("selCombo");
        System.out.print("id Product > " + IdProducto + "cantidad > " +cantidad + "tipo transaccion > " + transaccionP);
        int idProduct = Integer.parseInt(IdProducto);
        int cantidadP = Integer.parseInt(cantidad);
        oracleConn conect;
        conect = new oracleConn();
        try{
            conect.reStockManual(idProduct, cantidadP, transaccionP);
            response.sendRedirect(response.encodeRedirectURL("RESTOCK.jsp"));
        }
        catch(SQLException | IOException e){
         System.out.println(e);
        }
    }
}
