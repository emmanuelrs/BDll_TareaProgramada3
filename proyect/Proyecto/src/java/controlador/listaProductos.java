package controlador;


import java.util.*;

public class listaProductos {
    private static listaProductos instance;
    private  List<productosVendidos> productos;

    private listaProductos() {
    }

    public static listaProductos  getInstance(){
        if(instance == null){
            instance = new listaProductos();
        }
        return instance;  
    }
    
    public void setProducto(String id, int cant){
        productosVendidos product = new productosVendidos(id, cant);
        productos.add(product);
    } 
    
    public int getsize(){
        return productos.size();
    }

    public List<productosVendidos> getLista(){
        return productos;
    }
}
