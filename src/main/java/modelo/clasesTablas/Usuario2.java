package modelo.clasesTablas;

public class Usuario2 extends  DAO{

    private String nombre;
    private String password;
    private String correo;
    private int puntFinal;
    private String idMapa;
    private int response = 0;



    public Usuario2(){ }

    public Usuario2(String nombre){
        this.nombre = nombre;
        this.password = "xxx";
        this.correo = "xxx";
        this.response = 0;
    }

    public Usuario2(String nombre, String password, String correo) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.puntFinal= 0;
    }

    //Constructor que copia toda la informacion del Usuario al nuevo Usuario2.
    public Usuario2(String nombre, String password, String correo, int puntFinal, String idMapa) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.puntFinal = 0;
        this.puntFinal = puntFinal;
        this.idMapa = idMapa;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

///// METODO COPIAR USUARIO //////

    public void copyUser(Usuario userDAO){

            this.setNombre(userDAO.getNombre());
            this.setPassword(userDAO.getPassword());
            this.setCorreo(userDAO.getCorreo());
            this.setPuntFinal(userDAO.getPuntFinal());
            this.setIdMapa(userDAO.getIdMapa());
    }


}
