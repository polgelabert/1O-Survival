
package modelo;

public class Objeto {


    private String nombreObjeto;
    private String descripcionObjeto;
    private int peso;
    //private int tamanoObjCelda;
    private Punto tamanoObjCeldaMap;
    private Punto posicionObjeto;
    private String idObjMapa;

    public Objeto() {}


    /////  GETS Y SETS  /////

    public void setTamanoObjCeldaMap(Punto tamanoObjCeldaMap) {
        this.tamanoObjCeldaMap = tamanoObjCeldaMap;
    }

    public Punto getTamanoObjCeldaMap() {
        return tamanoObjCeldaMap;
    }

    public String getIdObjMapa() {
        return idObjMapa;
    }

    public void setIdObjMapa(String idObjMapa) {

        this.idObjMapa = idObjMapa;
    }

    public Objeto(String nombreObjeto, String descripcionObjeto, int peso, int tamanoObjCelda) {
        this.nombreObjeto = nombreObjeto;
        this.descripcionObjeto = descripcionObjeto;
        this.peso = peso;
        //this.tamanoObjCelda = tamanoObjCelda;

        this.posicionObjeto = new Punto();
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    /*
    public int getTamanoObjCelda() {
        return tamanoObjCelda;
    }


    public void setTamanoObjCelda(int tamanoObjCelda) {
        this.tamanoObjCelda = tamanoObjCelda;
    }
    */

    public Punto getPosicionObjeto() {
        return posicionObjeto;
    }

    public void setPosicionObjeto(Punto posicionObjeto) {
        this.posicionObjeto = posicionObjeto;
    }

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }


}
