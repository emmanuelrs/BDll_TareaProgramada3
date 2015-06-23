
package controlador;
/*
Elaborado por: Emmanuel Rosales Salas, Luis Serrano y Cristiam Flores Nuñez
Bases de Datos 2.
*/
//Esta clase guarda la información de la base de datos conrrespondiente a los
//teléfonos que se van a utilizar los objetos para la impresión en la aplicación
//en su respectiva pantalla.
public class tel {
    //Atributos
    private String id;
    private String telelfono;
    //Setters and Getters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTelelfono() {
        return telelfono;
    }
    public void setTelelfono(String telelfono) {
        this.telelfono = telelfono;
    } 

    public tel() {
        this.id = null;
        this.telelfono = null;
    }
}
