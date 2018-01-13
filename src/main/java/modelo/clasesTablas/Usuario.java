package modelo.clasesTablas;

public class Usuario extends  DAO{

    private final String nombre;
    private String password;
    private String correo;
    private int puntFinal;
    private String idMapa;

    // He eliminat "this.nombre = "xx"" de dins del constructor i inicialitzat la variable nombre com a null inicialment (amunt)
   /*public Usuario(){
       this.nombre = "xx";
    }*/




    public Usuario(){
        this.nombre = "x";
    }



    public Usuario(String usuario, String password, String correo) {
        nombre = usuario;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntFinal() {
        return puntFinal;
    }

    public void setPuntFinal(int puntFinal) {
        this.puntFinal = puntFinal;
    }
}
