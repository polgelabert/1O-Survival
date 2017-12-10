package modelo.IA;


import java.awt.*;
import java.awt.geom.Point2D;

public class IAs {

    //private int id;
    //private String tipo;

    private String idIa;
    private int velocidad;
    private int numeroMaxEnMapa;
    private Point posicion;


    public IAs(String idIa, int velocidad, int numeroMaxEnMapa, Point posicion) {
        this.idIa = idIa;
        this.velocidad = velocidad;
        this.numeroMaxEnMapa = numeroMaxEnMapa;
        this.posicion = posicion;
    }

    public String getIdIa() {
        return idIa;
    }
    public void setIdIa(String idIa) {
        this.idIa = idIa;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getNumeroMaxEnMapa() {
        return numeroMaxEnMapa;
    }
    public void setNumeroMaxEnMapa(int numeroMaxEnMapa) {
        this.numeroMaxEnMapa = numeroMaxEnMapa;
    }
    public Point getPosicion() {
        return posicion;
    }
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }



    public void mover(){

    }





}