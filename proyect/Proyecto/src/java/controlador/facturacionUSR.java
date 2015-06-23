package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Imports necerios para la clase
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//WebServlet y el constructor de la clase
@WebServlet("/facturacionUSR")
public class facturacionUSR extends HttpServlet{ 
    public facturacionUSR(){
        super();
    }
    int fac = -1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lee los datos que se reciben desde la aplicación Web  
        String IdProducto = request.getParameter("IdProducto");
        String Descuento = request.getParameter("descuento");
        String Cantidad = request.getParameter("Cantidad");
        String IdPV = request.getParameter("IdPuntoVenta");        
        String select[] = request.getParameterValues("id");
        String cedu = request.getParameter("Cedula"); 
        int varId = IdProducto.length();
        int varDes = Descuento.length();
        int varCant = Cantidad.length();
        int varIdPV = IdPV.length();
        System.out.println(cedu);
        System.out.println(IdPV);
        //Conexión con la  base de datos Oracle
        oracleConn conect;
        conect = new oracleConn();
        
        /*Si los datos de los productos y la cantidad son mayores a cero y el
        check de aceptar compra esta en null, agrega el producto a la tabla
        pivot para realizar una acumulación de productos antes de crear la factura
        */
        if(select == null & varId > 0 & varCant > 0){
            int cant = Integer.parseInt(Cantidad);
            int pro = Integer.parseInt(IdProducto);
            conect = new oracleConn();
            
            try {
                 //Ejecuta la función respectiva para ir creando los productos
                //y su cantidad 
                conect.agregarPivot(pro,cant);
                conect.ActualizarInventario(IdProducto, Cantidad);
                int stock = conect.verificaStock(pro);
                if(stock == 1){
                    System.out.println("SI");
                    conect.reStock(pro, cant);
                    
                }
                else{
                    System.out.println("NO");
                }
                
            } catch (SQLException ex) {
                System.out.print("Error cargando a la lista");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //if varDes
        //Si los productos están en cero y el check de confirmar compra está en
        //true se crea la factura con los productos previamente agregados
        else if (varId == 0 & varCant == 0 & select != null) {
            try {
                fac = conect.crearFactura(IdPV,Descuento, cedu);
            } catch (SQLException ex) {
                Logger.getLogger(facturacionUSR.class.getName()).log(Level.SEVERE, null, ex);
            }
            conect.getPivot(fac, IdPV);
        }// else if 
        //Si las variables son mayores a cero y el check de confirmar compra es 
        //diferente de null se realiza la compra con los productos que se hayan
        //agregado previamente o sino con el que se agrego en el momentos de 
        //ejecutar la compra.
        else if (varId > 0 & varCant > 0 & select != null) {
            int cant = Integer.parseInt(Cantidad);
            int pro = Integer.parseInt(IdProducto);
            conect = new oracleConn();
            try {
                //Llama las funciones respectivas para actualizar inventario
                //guardar los productos y crear la factura.
                conect.agregarPivot(pro,cant);
                conect.ActualizarInventario(IdProducto, Cantidad);
                int stock = conect.verificaStock(pro);
                if(stock == 1){
                    System.out.println("SI");
                    conect.reStock(pro, cant);
                }
                else{
                    System.out.println("NO");
                }
            } catch (SQLException ex) {
                System.out.print("Error cargando a la lista");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fac = conect.crearFactura(IdPV,Descuento,cedu);
            } catch (SQLException ex) {
                Logger.getLogger(facturacionUSR.class.getName()).log(Level.SEVERE, null, ex);
            }
            conect.getPivot(fac, IdPV);
        }//else if 2
        //Si el check de confirmar compra y los valores estan en null se resetea
        //el pivot
        if(select == null & varId == 0 & varCant == 0){
            conect.resetPivot();
        } //else if 3
        response.sendRedirect(response.encodeRedirectURL("facturacionUSR.jsp"));
    }
  public int getFac(){
      return fac;
  }  

}
