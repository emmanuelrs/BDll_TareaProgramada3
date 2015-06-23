
package controlador;

/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/

public class Persona {
     
    //Esta clase se encuentra dedicada para guardar los datos con respecto
    //a los proveedores y clientes.
    
    
    // Atributos
    Integer ced;
    String Nombre;
    String Apellido;
    String cedula;
    String email;
    String Telefono;
    String direccion;
    
    public Persona(){
        //Constructor inicializa todos los atributos en null
        setNombre(null);
        setApellido(null);
        setCedula(null);
        setEmail(null);
        setTelefono(null);
        setDireccion(null);
    }
 // Métodos de Setters and Getters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public Integer getCed() {
        return ced;
    }

    public void setCed(Integer ced) {
        this.ced = ced;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
