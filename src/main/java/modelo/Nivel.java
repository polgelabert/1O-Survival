package modelo;


import java.util.ArrayList;

public class Nivel {

    private int idMapa;
    private int vida;
    private int seguidores;
    private int votos;
    private Inventario inventarioUser;


    public Nivel(){ }

    public Nivel(int idMapa, int vida) {
        this.idMapa = idMapa;
        this.vida = vida;
        this.seguidores = 0;
        this.votos = 0;
        this.inventarioUser = new Inventario(100, new ArrayList<Objeto>());
    }


    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idNivel) {
        this.idMapa = idNivel;
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

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Inventario getInventarioUser() {
        return inventarioUser;
    }

    public void setInventarioUser(Inventario inventarioUser) {
        this.inventarioUser = inventarioUser;
    }
}
