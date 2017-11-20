package modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {


    private int pesoMax;
    private List<Objeto> listaObjetos;


    public Inventario(){}

    public Inventario(int pesoMax){
        this.pesoMax = pesoMax;
        this.listaObjetos = new ArrayList<Objeto>();
    }

    public Inventario(int pesoMax, List<Objeto> listaObjetos) {
        this.pesoMax = pesoMax;
        this.listaObjetos = listaObjetos;
    }
    public Boolean añadirObjeto(Objeto o){
        boolean añadido;
        int pesoActual=0;
        if(listaObjetos==null){

            listaObjetos=new ArrayList<>();

        }

        for(Objeto obj: listaObjetos){
            pesoActual = pesoActual + obj.getPeso();

        }
        if(pesoActual + o.getPeso() <= this.pesoMax){
            listaObjetos.add(o);
            añadido = true;

        }
        else{
            añadido = false;

        }

        return añadido;
    }
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
    }


}