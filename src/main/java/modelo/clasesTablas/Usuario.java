package modelo.clasesTablas;

import java.io.Serializable;

public class Usuario extends  DAO{

    private final String nombre;
    private String password;
    private String correo;
    private int puntFinal;
    private String idMapa;

   public Usuario(){
        this.nombre="xx";
    }


    public Usuario(String usuario, String password, String correo) {
        this.nombre = usuario;
        this.password = password;
        this.correo = correo;
        this.puntFinal= 0;

    }

    public String getNombre() {
        return nombre;
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
