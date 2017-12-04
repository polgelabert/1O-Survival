
package modelo;

import controlador.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public final class Player {


    private String nombre;
    private int vida;
    private int votos;
    private int seguidores;
    private Inventario inventarioUser;
    //private Punto posicionActual;
    private int mapaActual;


    public Player (){}
    public Player(String nombre, int vida, int votos, int seguidores) {
        this.nombre = nombre;
        this.vida = vida;
        this.votos = votos;
        this.seguidores = seguidores;
        this.inventarioUser = new Inventario(100, new ArrayList<Objeto>());
      //  this.posicionActual = new Punto();
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }
/*
    public Punto getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Punto posicionActual) {
        this.posicionActual = posicionActual;
    }
*/
    public int getMapaActual() {
        return mapaActual;
    }

    public void setMapaActual(int mapaActual) {
        this.mapaActual = mapaActual;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Inventario getInventarioUser() {
        return inventarioUser;
    }

    public void setInventarioUser(Inventario inventarioUser) {
        this.inventarioUser = inventarioUser;
    }



/////   Metodos   /////




        /**
         * @param player
         * @return boolean
         * Comprueba si dos players son iguales. No se compara ni posicionActual ni mapaActual
         */
       /* public boolean usuarioEsIgual(Player player) {//NO ENTIENDO EN QUE NOS BENEFICIA ESTE METODO Y LA FORMA EN LA QUE ESTA HECHO
                            //Usar equals para comparar strings
            if (player.nombre.equals(this.nombre) && player.vida == this.vida && player.votos == this.votos && player.seguidores == this.seguidores) {

                for(Objeto o : player.getInventarioUser().getListaObjetos()) {
                    for(int i=0; i< player.getInventarioUser().getListaObjetos().size(); i++){
                        //if (o.getNombreObjeto() == this.getInventarioUser().getListaObjetos().get(i).getNombreObjeto() && o.getDescripcionObjeto() == this.getInventarioUser().getListaObjetos().get(i).getDescripcionObjeto() && o.getPeso() == this.getInventarioUser().getListaObjetos().get(i).getPeso() && o.getTamanoObjCelda() == this.getInventarioUser().getListaObjetos().get(i).getTamanoObjCelda() && o.getPosicionObjeto() == this.getInventarioUser().getListaObjetos().get(i).getPosicionObjeto()) return true;
                        if (o.getNombreObjeto() == this.getInventarioUser().getListaObjetos().get(i).getNombreObjeto() && o.getDescripcionObjeto() == this.getInventarioUser().getListaObjetos().get(i).getDescripcionObjeto() && o.getPeso() == this.getInventarioUser().getListaObjetos().get(i).getPeso() && o.getTamanoObjCelda() == this.getInventarioUser().getListaObjetos().get(i).getTamanoObjCelda() && o.getPosicionObjeto().x == this.getInventarioUser().getListaObjetos().get(i).getPosicionObjeto().x && o.getPosicionObjeto().y == this.getInventarioUser().getListaObjetos().get(i).getPosicionObjeto().y ) return true;
                    }
                }
                return false;

            } else {
                return false;
            }
        }*/

    /**
     * @param user
     * Modifica un usuario sobreescribiendo todos sus atributos.
     */
    /*public void modificarUsuario(Player user) {

        this.nombre = user.nombre;
        this.vida = user.vida;
        this.votos = user.votos;
        this.seguidores = user.seguidores;
        this.inventarioUser = user.inventarioUser;
        this.posicionActual = user.posicionActual;
    }*/





    /**
     * Compara dos listas de usuarios
     * @param listaObjConsult
     * @return true si son iguales
     */
    /*public boolean listaEsIgual (List<Objeto> listaObjConsult){
//Mas de lo mismo, de que nos sirve comparar dos inventario? :O
        boolean resp = false;
        int m = 0;
        if(listaObjConsult.size()==inventarioUser.getListaObjetos().size()){
//aun si quereis hacer el metodo, un primer paso es mirar si son igual de largas las listas(?) te ahorras errores y comparar 2 listas que si no son igual de largas no seran iguales
            for (int n = 0; n< listaObjConsult.size(); n++) {

                if (listaObjConsult.get(m).getNombreObjeto() == this.getInventarioUser().getListaObjetos().get(m).getNombreObjeto() && listaObjConsult.get(m).getDescripcionObjeto() == this.getInventarioUser().getListaObjetos().get(m).getDescripcionObjeto() && listaObjConsult.get(m).getPeso() == this.getInventarioUser().getListaObjetos().get(m).getPeso() && listaObjConsult.get(m).getTamanoObjCelda() == this.getInventarioUser().getListaObjetos().get(m).getTamanoObjCelda() && listaObjConsult.get(m).getPosicionObjeto().x == this.getInventarioUser().getListaObjetos().get(m).getPosicionObjeto().x && listaObjConsult.get(m).getPosicionObjeto().y == this.getInventarioUser().getListaObjetos().get(m).getPosicionObjeto().y) {
                    resp = true;
                } else {
                    m = m+1;
                }
            }
        }

        return resp;
    }*/




}