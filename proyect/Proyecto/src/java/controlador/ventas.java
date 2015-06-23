
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Esta clase guarda los datos de la base de datos que corresponden a las ventas
// con el fin de utiizar los objetos en la aplicación para mostrarlos en
//pantalla
public class ventas {
        //Atributos
    private String factura;
    private String nombre;
    private String apellido;
    private String puntoDeVenta;
    private String descuento;
    private String total;
    //Constructor de la clase
    public ventas(){
        setFactura(null);
        setNombre(null);
        setApellido(null);
        setPuntoDeVenta(null);
        setDescuento(null);
        setTotal(null);   
    }
//Setters and Getters.
    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuntoDeVenta() {
        return puntoDeVenta;
    }

    public void setPuntoDeVenta(String puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }  
}
