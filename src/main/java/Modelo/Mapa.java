package Modelo;

public class Mapa {


    private String [][] malla;
    private int idMalla;


    public Mapa(String[][] malla, Integer idMalla) {
        this.malla = malla;
        this.idMalla = idMalla;
    }


    public String[][] getMalla() {
        return malla;
    }

    public void setMalla(String[][] malla) {
        this.malla = malla;
    }

    public int getIdMalla() {
        return idMalla;
    }

    public void setIdMalla(Integer idMalla) {
        this.idMalla = idMalla;
    }
}
