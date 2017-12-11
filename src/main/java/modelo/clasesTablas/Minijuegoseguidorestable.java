package modelo.clasesTablas;

import java.util.Random;

public class Minijuegoseguidorestable extends DAO {

    private String tema;
    private final int idminijuegoseguidorestable;
    private String pregunta, respuesta,respuesta1, respuesta2, respuesta3,respuesta4;

    public Minijuegoseguidorestable(String oficio) {
        this.tema = oficio;
        Random generator=new Random();
        //int id=generator.nextInt(20);
        int id=1;
        switch (tema) {
            default:
                break;
            case "Art":
                id=id+20;
                break;
            case "His":
                id=id+40;
                break;
            case "Entr":
                id=id+60;
                break;
            case "CiNa":
                id=id+80;
                break;
            case "Dep":
                id=id+100;
                break;
        }
        this.idminijuegoseguidorestable=id;
    }

    public String[][] datos(){

        String[][] cosas=new String[2][4];
        cosas[0][0]=tema;
        cosas[0][1]=pregunta;
        cosas[0][2]=respuesta;
        cosas[1][0]=respuesta1;
        cosas[1][1]=respuesta2;
        cosas[1][2]=respuesta3;
        cosas[1][3]=respuesta4;
        return cosas;
    }

    //GETTES SETTES


    public String getTema() {
        return tema;
    }

    public int getIdminijuegoseguidorestable() {
        return idminijuegoseguidorestable;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }
}
