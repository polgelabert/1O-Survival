package modelo.clasesTablas;

public class Logintable {

    private final String usuario;
    private String password;
    private final String correo;
    private int puntFinal;
    private String idMapa;

    public Logintable(String usuario, String password, String correo) {
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.puntFinal= 0;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(String idMapa) {
        this.idMapa = idMapa;
    }
}
