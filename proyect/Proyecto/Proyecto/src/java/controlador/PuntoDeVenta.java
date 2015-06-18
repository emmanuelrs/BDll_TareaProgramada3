package controlador;

public class PuntoDeVenta {
    private String Id;
    private String nombre;
    private String Pais;
    private String Provincia;
    private String Canton;
    private String Direccion;
    private String telefono;

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
