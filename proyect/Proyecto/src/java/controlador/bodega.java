
package controlador;

public class bodega {
    private String id;
    private String nombre;
    private String pais;
    private String provincia;
    private String canton;
    private String direccion;
    private String telefono;

    public bodega() {
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPais() {
        return pais;
    }
    public String getProvincia() {
        return provincia;
    }
    public String getCanton() {
        return canton;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public void setCanton(String canton) {
        this.canton = canton;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
