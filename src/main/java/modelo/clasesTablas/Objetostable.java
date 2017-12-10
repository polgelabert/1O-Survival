package modelo.clasesTablas;


import java.awt.*;

public class Objetostable extends DAO {

    private final String nombre;
    private String descripcion;
    private int peso;
    private String tamanoObjCeldaMap;

    public Objetostable(String nombre, String descripcion, int peso, Point tam){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.peso=peso;
        this.tamanoObjCeldaMap=tam.toString();//puntoToString(tam);
    }

    public String puntoToString(Point tam){
        return tam.getX()+","+tam.getY();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPeso() {
        return peso;
    }

    public String getTamanoObjCeldaMap() {
        return tamanoObjCeldaMap;
    }
}
