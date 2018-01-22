package modelo.clasesTablas;

public class Ranking extends DAO{

    private String idmapa;
    private final String usuario;
    private int votos,seguidores;
    private int puntuaciontot;



    public Ranking(String usuario) {
        this.usuario = usuario;
    }

    public Ranking(String idmapa, String usuario, int votos, int seguidores, int puntuaciontot) {
        this.idmapa = idmapa;
        this.usuario = usuario;
        this.votos = votos;
        this.seguidores = seguidores;
        this.puntuaciontot = puntuaciontot;
    }




    //GETTERS


    public String getIdMapa() {
        return idmapa;
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


    public void setIdmapa(String idMapa) {
        this.idmapa = idMapa;
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




    public void copyRank(Ranking2 rank2) {
        this.setIdmapa(rank2.getIdmapa());
        this.setVotos(rank2.getVotos());
        this.setSeguidores(rank2.getSeguidores());
        this.setPuntuaciontot(rank2.getPuntuaciontot());
    }
}
