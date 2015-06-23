package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Esta clase almacena los productos que han sido vendidos para luego utilizarlos
//en la aplicación para imprimir en pantalla
public class productosVendidos {
    //Atributos
    private final String producto;
    private final Integer cantidad;
//Métodos de la clase!
    public productosVendidos(String producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
