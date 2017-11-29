package modelo;

public class PlayerTO {


    private String nombre;
    private int vida;
    private int votos;
    private int seguidores;


    public PlayerTO(){}

    public PlayerTO(Player user){
        this.nombre = user.getNombre();
        this.vida = user.getVida();
        this.votos = user.getVotos();
        this.seguidores = user.getSeguidores();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
}
