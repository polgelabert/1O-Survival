package modelo.clasesTablas;

public class Ranking2 extends DAO{

    private String idMapa;
    private String usuario;
    private int votos,seguidores;
    private int puntuaciontot;



    public Ranking2() {}

    public Ranking2(String usuario){
        this.idMapa = "xxx";
        this.usuario = usuario;
        this.votos = 0;
        this.seguidores = 0;
        this.puntuaciontot = 0;
    }

    public Ranking2(String idMapa, String usuario, int votos, int seguidores, int puntuaciontot) {
        this.idMapa = idMapa;
        this.usuario = usuario;
        this.votos = votos;
        this.seguidores = seguidores;
        this.puntuaciontot = puntuaciontot;
    }

    //GETTERS



    public String getIdMapa() {
        return idMapa;
    }

    public String getIdmapa() {
        return idMapa;
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


    public void setIdMapa(String idMapa) {
        this.idMapa = idMapa;
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
