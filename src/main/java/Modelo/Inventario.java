package Modelo;

import java.util.List;

public class Inventario {


    private int pesoMax;
    private List<Objeto> listaObjetos;


    public Inventario(int pesoMax, List<Objeto> listaObjetos) {
        this.pesoMax = pesoMax;
        this.listaObjetos = listaObjetos;
    }


    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }


}