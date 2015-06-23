package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/
import java.util.*;
//Esta clase guarda la lista de los productos que posee una compra,
//se utiliza para realizar un ciclo en la lógica de la aplicación que vaya
//imprimiendo los datos de los productos en la factura.
public class listaProductos {
        //Atributos de la clase lista productos
    private static listaProductos instance;
    private  List<productosVendidos> productos;
   //Setters and Getters
    //Constructor de la clase
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
