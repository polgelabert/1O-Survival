package modelo.clasesTablas;

import modelo.Objeto;

import javax.json.Json;
import java.util.ArrayList;

public class Niveltable extends DAO{

    private final String idmapa;
    //Introducir haciendo Select con DAO
    private int pesomax;
    private ArrayList<Objeto> objetosmapa;
    private String policias,transeuntes,votantes;

    public Niveltable(String idmapa)
    {
        this.idmapa=idmapa;
        this.objetosmapa=new ArrayList<Objeto>();
    }

    public String getIdmapa() {
        return idmapa;
    }

    public int getPesomax() {
        return pesomax;
    }

    //USAR PARA EL DAO
    public Json getObjetosmapa() {
        //Convertir en JSON
        return null;
    }

    //USAR PROGRAMA
    public ArrayList<Objeto> getObjetosMapa() {
        return objetosmapa;
    }

    public String getPolicias() {
        return policias;
    }

    public String getTranseuntes() {
        return transeuntes;
    }

    public String getVotantes() {
        return votantes;
    }

    //SETTERS


    public void setPesomax(int pesomax) {
        this.pesomax = pesomax;
    }

    public ArrayList<Objeto> fromJson(Json objetosmapa)
    {
        //Destransformar el Json que pillamos de la tabla
        return null;

    }
    //Usar en DAO
    public void setObjetosmapa(Json objetosmapa) {
        this.objetosmapa = fromJson(objetosmapa);
    }


    //usar en el codigo
    public void setObjetosMapa(ArrayList<Objeto> objetosmapa){
        this.objetosmapa=objetosmapa;
    }

    public void setPolicias(String policias) {
        this.policias = policias;
    }

    public void setTranseuntes(String transeuntes) {
        this.transeuntes = transeuntes;
    }

    public void setVotantes(String votantes) {
        this.votantes = votantes;
    }
}

