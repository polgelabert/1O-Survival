package modelo;

public final class PlayerTO {


    private String nombre;
    private int puntuacionTotal;
    private int seguidores;


    public PlayerTO(){}

    public PlayerTO(Usuario user){
        this.nombre = user.getNombre();
        this.puntuacionTotal = user.getPuntuacionTotal();
        this.seguidores = user.getMiNivel().getSeguidores();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
}
