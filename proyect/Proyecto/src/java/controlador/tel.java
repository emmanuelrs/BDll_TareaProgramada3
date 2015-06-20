
package controlador;

public class tel {
    private String id;
    private String telelfono;
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
