/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Emmanuel
 */
public class ventas {
    
    private String factura;
    private String nombre;
    private String apellido;
    private String puntoDeVenta;
    private String descuento;
    private String total;
    
    public ventas(){
        setFactura(null);
        setNombre(null);
        setApellido(null);
        setPuntoDeVenta(null);
        setDescuento(null);
        setTotal(null);
        
    }

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
