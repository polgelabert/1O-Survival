
package modelo;


public final class Usuario {


    private String nombre;
    private String contrasena;
    private String correo;
    private Nivel miNivel;
    private int puntuacionTotal;




    public Usuario(){}
    public Usuario(String nombre, String contrasena, String correo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.puntuacionTotal = 0;
        this.miNivel = new Nivel();
      //  this.posicionActual = new Punto();
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    /*
        public Punto getPosicionActual() {
            return posicionActual;
        }

        public void setPosicionActual(Punto posicionActual) {
            this.posicionActual = posicionActual;
        }
    */

    public Nivel getMiNivel() {
        return miNivel;
    }

    public void setMiNivel(Nivel miNivel) {
        this.miNivel = miNivel;
    }


/////   Metodos   /////




        /**
         * @param player
         * @return boolean
         * Comprueba si dos players son iguales. No se compara ni posicionActual ni mapaActual
         */
       /* public boolean usuarioEsIgual(Usuario player) {//NO ENTIENDO EN QUE NOS BENEFICIA ESTE METODO Y LA FORMA EN LA QUE ESTA HECHO
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
    /*public void modificarUsuario(Usuario user) {

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