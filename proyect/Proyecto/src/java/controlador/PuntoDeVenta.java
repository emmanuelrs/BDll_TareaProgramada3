package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

//Clase de punto de venta, almacena los datos de punto de ventas
//Para ser utilizados en la aplicación para guardarlos y mostrarlos en pantalla.
public class PuntoDeVenta {
    
     // Atributos necesarios para el funcionamiento de la clase.
    
    private String Id;
    private String nombre;
    private String Pais;
    private String Provincia;
    private String Canton;
    private String Direccion;
    private String telefono;

    //Métodos de la clase y su constructor.
    //Setters and Getters.
    
    public PuntoDeVenta() {
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
    
    public String getId() {
        return Id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getProvincia() {
        return Provincia;
    }
    public String getCanton() {
        return Canton;
    }
    public String getDireccion() {
        return Direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setId(String id) {
        this.Id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }
    public void setCanton(String Canton) {
        this.Canton = Canton;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    } 
}
