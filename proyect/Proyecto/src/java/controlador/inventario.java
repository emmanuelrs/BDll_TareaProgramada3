package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/
public class inventario {
        //Atributos de la clase inventarios
    private String id;
    private String Producto;
    private String Descripcion;
    private String Precio;
    private String Marca;
    private String Categoria;
    private String Cantidad;
    private String minimo;
    private String bodega;
    //Setters and Getters
    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProducto() {
        return Producto;
    }
    public void setProducto(String Producto) {
        this.Producto = Producto;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public String getPrecio() {
        return Precio;
    }
    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    public String getCantidad() {
        return Cantidad;
    }
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }
    public String getMinimo() {
        return minimo;
    }
    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }
//constructor
    public inventario() {
        this.id = null;
        this.Producto = null;
        this.Descripcion = null;
        this.Precio = null;
        this.Marca = null;
        this.Categoria = null;
        this.Cantidad = null;
        this.minimo = null;
        this.bodega = null;
    }
}
