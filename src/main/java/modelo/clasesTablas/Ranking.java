package modelo.clasesTablas;

public class Ranking extends DAO{

    private final String idmapa;
    private String usuario;
    private int votos,seguidores;
    private double puntuaciontot;

    public Ranking(String idmapa) {
        this.idmapa = idmapa;
    }

    //GETTERS


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

    public double getPuntuaciontot() {
        return puntuaciontot;
    }

    //SETTERS


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public void setPuntuaciontot(double puntuaciontot) {
        this.puntuaciontot = puntuaciontot;
    }
}