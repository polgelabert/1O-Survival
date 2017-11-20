package modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {


    private int pesoMax,pesoActual;
    private List<Objeto> listaObjetos;


    public Inventario(){}

    public Inventario(int pesoMax){
        this.pesoMax = pesoMax;
        this.pesoActual=0;
        this.listaObjetos = new ArrayList<Objeto>();
    }

    public Inventario(int pesoMax, List<Objeto> listaObjetos) {
        this.pesoMax = pesoMax;
        this.listaObjetos = listaObjetos;
        this.pesoActual=0;
        for(Objeto o:listaObjetos){
            pesoActual=pesoActual+o.getPeso();
        }
    }
    public Boolean añadirObjeto(Objeto o){
        boolean añadido;
        if(listaObjetos==null){

            listaObjetos=new ArrayList<Objeto>();
            this.pesoActual=0;
        }
        /*
        for(Objeto obj: listaObjetos){
            pesoActual = pesoActual + obj.getPeso();

        }
        */
        if(pesoActual + o.getPeso() <= this.pesoMax){
            listaObjetos.add(o);
            añadido = true;

        }
        else{
            añadido = false;
        }

        return añadido;
    }
    //POR QUE SE LLAMA SACAROBJETO SI DEVUELVE UN BOOL Y NO UN OBJETO? COMO ELIMINAR OBJETO AUN PASA
    public Boolean sacarObjeto(Objeto b){

        boolean encontrado = false;
        for(Objeto o: listaObjetos){
            if (b==o)
            {
                encontrado = true;
                listaObjetos.remove(o);
                break;

            }

        }
        return encontrado;

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
        this.pesoActual=0;
        for(Objeto o:listaObjetos){
            pesoActual=pesoActual+o.getPeso();
        }
    }


}