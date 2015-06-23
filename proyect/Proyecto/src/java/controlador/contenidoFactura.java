package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Esta clase guarda los datos del contenido de la factura para ser utilizando
//en la aplicación para imprmir la información obtenida desde la base de datos.

public class contenidoFactura {
    
    //Atributos de la clase
    public String nombreP;
    public String cantidad;
    public String precio;
    public String totalC;
    public String descripcion;
    
     //Constructor de la clase que pone los valores en null  

    public void setTotalC() {
        int totalInt = Integer.parseInt(getPrecio()) * Integer.parseInt(getCantidad());
        this.totalC = Integer.toString(totalInt);
    }
    //Método que calcula el total de la factura
    public String getTotalC() {
        
        return totalC;
    }
    // Setters and Getters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
  
    
    public contenidoFactura(){
        setNombreP(null);
        setCantidad(null);
    }
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    } 
}
