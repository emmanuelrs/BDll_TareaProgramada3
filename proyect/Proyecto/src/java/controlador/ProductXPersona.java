
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

// Esta clase guarda los datos de el producto que se compra por persona
// se utiliza en la aplicación para guardar los datos que vienen de la base
// y que sean mostrados en la aplicación web.

public class ProductXPersona {
    
//Atributos respectivos para la clase
    
String PRODUCTO = "";
String DESCRIPCION = "";
String PRECIOUNITARIO = "";
String MARCA = "";
String CATEGORIA = "";
String ID_FACTURA = "";
String CANTIDAD = "";
String TOTAL = "";

//Métodos de la clase necesarios.
    public ProductXPersona() {
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getPRECIOUNITARIO() {
        return PRECIOUNITARIO;
    }

    public void setPRECIOUNITARIO(String PRECIOUNITARIO) {
        this.PRECIOUNITARIO = PRECIOUNITARIO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getID_FACTURA() {
        return ID_FACTURA;
    }

    public void setID_FACTURA(String ID_FACTURA) {
        this.ID_FACTURA = ID_FACTURA;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL() {
        int entero = Integer.parseInt(CANTIDAD);
        int entero1 = Integer.parseInt(PRECIOUNITARIO);
        int entero2 = entero * entero1;
        this.TOTAL = Integer.toString(entero2);
    }
  
}
