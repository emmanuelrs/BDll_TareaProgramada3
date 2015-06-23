
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Clase de punto de venta, almacena los datos de punto de ventas
//Para ser utilizados en la aplicación para guardarlos y mostrarlos en pantalla.
public class PuntosVenta {
    String nombre;

    public PuntosVenta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
