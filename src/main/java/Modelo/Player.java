package Modelo;


public class Player {


    private String nombre;
    private int vida;
    private int seguidores;
    private Punto posicionActual;
    private int mapaActual;

    public Player (){}
    public Player(String nombre, int vida, int seguidores, Punto posicionActual) {
        this.nombre = nombre;
        this.vida = vida;
        this.seguidores = seguidores;
        this.posicionActual = posicionActual;
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

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public Punto getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Punto posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getMapaActual() {
        return mapaActual;
    }

    public void setMapaActual(int mapaActual) {
        this.mapaActual = mapaActual;
    }





}
