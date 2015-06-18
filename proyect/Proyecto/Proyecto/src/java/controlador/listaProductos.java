package controlador;


import java.util.*;

public class listaProductos {
    private static List<productosVendidos> productos;
    private static Boolean instancia = false;

    public listaProductos() {
    }

    public List<productosVendidos> getlista(){
        if(instancia == false){
            instancia = true;
            productos = new ArrayList<productosVendidos>();
            return productos;
        }
        return productos;  
    }
    public void setProducto(String id, int cant){
        productosVendidos product = new productosVendidos(id, cant);
        if(instancia == false){
            instancia = true;
            productos = new ArrayList<productosVendidos>();
            productos.add(product);
        }
        productos.add(product);
    } 
}
