
package controlador;

public class contenidoFactura {
    
    public String nombreP;
    public String cantidad;
    public String precio;
    public String totalC;
    public String descripcion;

    public void setTotalC() {
        int totalInt = Integer.parseInt(getPrecio()) * Integer.parseInt(getCantidad());
        this.totalC = Integer.toString(totalInt);
    }
    
    public String getTotalC() {
        
        return totalC;
    }

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
