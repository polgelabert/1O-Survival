
package modelo;

public class Objeto {


    private String nombreObjeto;
    private String descripcionObjeto;
    private int peso;
    private int tamanoObjCelda;
    private Punto posicionObjeto;


    public Objeto() {}

    public Objeto(String nombreObjeto, String descripcionObjeto, int peso, int tamanoObjCelda) {
        this.nombreObjeto = nombreObjeto;
        this.descripcionObjeto = descripcionObjeto;
        this.peso = peso;
        this.tamanoObjCelda = tamanoObjCelda;
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

    public int getTamanoObjCelda() {
        return tamanoObjCelda;
    }

    public void setTamanoObjCelda(int tamanoObjCelda) {
        this.tamanoObjCelda = tamanoObjCelda;
    }

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



    /////    /////

    /**
     *
     * @param o
     * @return true si objeto e sigual
     */
    public boolean objetoEsIgual(Objeto o) {

        boolean resp = false;

        if (o.nombreObjeto == this.nombreObjeto && o.descripcionObjeto == this.descripcionObjeto && o.peso == this.peso && o.tamanoObjCelda == this.tamanoObjCelda && o.posicionObjeto.x == this.posicionObjeto.x && o.posicionObjeto.y == this.posicionObjeto.y ) {
            resp = true;
        }

        return resp;
    }


}
