package modelo.clasesTablas;

import modelo.Punto;

public class Objetostable extends DAO {

    private final String nombre;
    private String descripcion;
    private int peso;
    private String tamanoObjCeldaMap;

    public Objetostable(String nombre, String descripcion, int peso, Punto tam){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.peso=peso;
        this.tamanoObjCeldaMap=puntoToString(tam);
    }

    public String puntoToString(Punto tam){
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
