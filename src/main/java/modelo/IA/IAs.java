package modelo.IA;


import controlador.OneOctoberManagerImpl;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.geom.Point2D;

public class IAs {

    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());
    //private int id;
    //private String tipo;

    private String idIa;
    private int velocidad;
    private int numeroMaxEnMapa;
    private Point posicion;
    private Point posObjetivo;

    public IAs(String idIa, int velocidad, int numeroMaxEnMapa, Point posicion, Point posObjetivo) {
        this.idIa = idIa;
        this.velocidad = velocidad;
        this.numeroMaxEnMapa = numeroMaxEnMapa;
        this.posicion = posicion;
        this.posObjetivo = posObjetivo;
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
    public Point getPosObjetivo() {
        return posObjetivo;
    }
    public void setPosObjetivo(Point posObjetivo) {
        this.posObjetivo = posObjetivo;
    }

    public void mover() {
        double distancia = getPosicion().distance(getPosObjetivo());
        double min = 1000;
        Point act = new Point();
        int[] vecPos = {1, -1, 0, 0};
        // de les quatre celes del voltant, miro quina es la que esta mes aprop del objectiu
        for (int i = 0; i < 4; i++) {
            Point p = new Point((int) getPosicion().getX() + vecPos[i], (int) getPosicion().getY() + vecPos[vecPos.length-1-i]);
            if(getPosObjetivo().distance(p) < min ) {
                min = getPosObjetivo().distance(p);
                act.setLocation(p);
            }
        }
        // si m'ho ha calculat bé, actualitzo posicio
        if(!act.equals(new Point()))
            setPosicion(act);
        else
            log.error("No calcula laproxima cela");

/*
        // de les quatre celes del voltant, miro quina es la que esta mes aprop del objectiu
        double min = 0;
        Point act = new Point();
        if(getPosObjetivo().distance(new Point((int) getPosicion().getX() + 1, (int) getPosicion().getY())) < min) {
            Point p = new Point((int) getPosicion().getX() + 1, (int) getPosicion().getY());
            min = getPosObjetivo().distance(p);
            act.setLocation(p);
        }
        if (getPosObjetivo().distance(new Point((int) getPosicion().getX() - 1, (int) getPosicion().getY())) < min) {
            Point p = new Point((int) getPosicion().getX() - 1, (int) getPosicion().getY());
            min = getPosObjetivo().distance(new Point((int) getPosicion().getX() - 1, (int) getPosicion().getY()));
            act.setLocation(p);
        }
        if (getPosObjetivo().distance(new Point((int) getPosicion().getX(), (int) getPosicion().getY() + 1)) < min){
            Point p = new Point((int) getPosicion().getX(), (int) getPosicion().getY() + 1);
            min = getPosObjetivo().distance(p);
            act.setLocation(p);
        }
        if(getPosObjetivo().distance(new Point((int)getPosicion().getX(),(int)getPosicion().getY()-1)) < min) {
            Point p = new Point((int) getPosicion().getX(), (int) getPosicion().getY() - 1);
            min = getPosObjetivo().distance(p);
            act.setLocation(p);
        }*/


    }





}