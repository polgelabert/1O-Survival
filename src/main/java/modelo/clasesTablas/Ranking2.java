package modelo.clasesTablas;

public class Ranking2 extends DAO{

    private String idmapa;
    private String usuario;
    private int votos,seguidores;
    private int puntuaciontot;
    private int response;


    public Ranking2() {}

    public Ranking2(String usuario){
        this.idmapa = "xxx";
        this.usuario = usuario;
        this.votos = 0;
        this.seguidores = 0;
        this.puntuaciontot = 0;
        this.response = 0;
    }

    public Ranking2(String idmapa, String usuario, int votos, int seguidores, int puntuaciontot) {
        this.idmapa = idmapa;
        this.usuario = usuario;
        this.votos = votos;
        this.seguidores = seguidores;
        this.puntuaciontot = puntuaciontot;
        this.response = 0;
    }

    //GETTERS


    public int getResponse() {
        return response;
    }


    public String getIdmapa() {
        return idmapa;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getVotos() {
        return votos;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public int getPuntuaciontot() {
        return puntuaciontot;
    }

    //SETTERS


    public void setResponse(int response) {
        this.response = response;
    }

    public void setIdmapa(String idMapa) {
        this.idmapa = idMapa;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public void setPuntuaciontot(int puntuaciontot) {
        this.puntuaciontot = puntuaciontot;
    }
}
