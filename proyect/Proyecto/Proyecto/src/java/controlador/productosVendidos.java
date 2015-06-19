package controlador;

public class productosVendidos {
    private final String producto;
    private final Integer cantidad;

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
