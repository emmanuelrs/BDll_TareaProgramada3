package controlador;

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

@WebServlet("/facturacion")
public class facturacion extends HttpServlet{ 
    public facturacion(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String contextPath = request.getContextPath();
        String IdProducto = request.getParameter("IdProducto");
        String Descuento = request.getParameter("descuento");
        String Cantidad = request.getParameter("Cantidad");
        String IdPV = request.getParameter("IdPuntoVenta");
        int varId = IdProducto.length();
        int varDes = Descuento.length();
        int varCant = Cantidad.length();
        int varIdPV = IdPV.length();
        int fac = -1;
        listaProductos lista = listaProductos.getInstance();
        
        if(varDes == 0){
            int cant = Integer.parseInt(Cantidad);
            lista.setProducto(IdProducto, cant);
            List<productosVendidos> lista2 = lista.getLista();
            oracleConn conect;
            conect = new oracleConn();
            try {
                conect.ActualizarInventario(IdProducto, Cantidad);
            } catch (SQLException ex) {
                System.out.print("Error cargando a la lista");
                Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(lista2.size());
        }
        else{
        if(varId > 0){
            if(varCant > 0){
                int cant = Integer.parseInt(Cantidad);
                lista.setProducto(IdProducto, cant);
                List<productosVendidos> lista2 = lista.getLista();
                oracleConn conect;
                conect = new oracleConn();
                try {
                    conect.ActualizarInventario(IdProducto, Cantidad);
                } catch (SQLException ex) {
                System.out.print("Error cargando a la lista 2");
                    Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fac = conect.crearFactura(IdPV,Descuento);
                    System.out.print(fac);
                } catch (SQLException ex) {
                    System.out.print("Error creando factura");
                    Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                int i;
                for(i=1;i<lista2.size();i++) {
                productosVendidos p = lista2.get(i);
                    try {
                        conect.agregarProducto(Integer.toString(fac), IdProducto, Cantidad);
                    } catch (SQLException ex) {
                        System.out.print("Error cargando productos a la factuura");
                        Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
            }
            }
            else{
                try {
                    oracleConn conect;
                    conect = new oracleConn();
                    fac = conect.crearFactura(IdPV,Descuento);
                    } catch (SQLException ex) {
                        System.out.print("Error creando factura");
                        Logger.getLogger(newProduct.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    List<productosVendidos> lista2 = lista.getLista();
                    oracleConn conect;
                    conect = new oracleConn();
                    int i;
                    for(i=1;i<lista2.size();i++) {
                    productosVendidos p = lista2.get(i);
                        try {
                            conect.agregarProducto(Integer.toString(fac), IdProducto, Cantidad);
                        } catch (SQLException ex) {
                            System.out.print("Error cargando productos a la factuura");
                            Logger.getLogger(facturacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
        }
        response.sendRedirect(response.encodeRedirectURL("facturacion.jsp"));
    }  
}