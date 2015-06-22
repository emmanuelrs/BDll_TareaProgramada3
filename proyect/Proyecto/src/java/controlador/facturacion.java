package controlador;

import static controlador.oracleConn.conn;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.and;
import oracle.jdbc.pool.OracleDataSource;

@WebServlet("/facturacion")
public class facturacion extends HttpServlet{ 
    public facturacion(){
        super();
    }
    int fac = -1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IdProducto = request.getParameter("IdProducto");
        String Descuento = request.getParameter("descuento");
        String Cantidad = request.getParameter("Cantidad");
        String IdPV = request.getParameter("IdPuntoVenta");        
        String select[] = request.getParameterValues("id");
        int varId = IdProducto.length();
        int varDes = Descuento.length();
        int varCant = Cantidad.length();
        int varIdPV = IdPV.length();
        
        oracleConn conect;
        conect = new oracleConn();
        
        
        if(select == null & varId > 0 & varCant > 0){
            int cant = Integer.parseInt(Cantidad);
            int pro = Integer.parseInt(IdProducto);
            conect = new oracleConn();
            
            try {
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
        else if (varId == 0 & varCant == 0 & select != null) {
            try {
                fac = conect.crearFactura(IdPV,Descuento);
            } catch (SQLException ex) {
                Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            conect.getPivot(fac, IdPV);
        }// else if 
        else if (varId > 0 & varCant > 0 & select != null) {
            int cant = Integer.parseInt(Cantidad);
            int pro = Integer.parseInt(IdProducto);
            conect = new oracleConn();
            try {
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
                fac = conect.crearFactura(IdPV,Descuento);
            } catch (SQLException ex) {
                Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            conect.getPivot(fac, IdPV);
        }//else if 2
        if(select == null & varId == 0 & varCant == 0){
            conect.resetPivot();
        } //else if 3
        response.sendRedirect(response.encodeRedirectURL("facturacion.jsp"));
    }
  public int getFac(){
      return fac;
  }  

}
