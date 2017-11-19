package controlador;

import controlador.excepciones.*;
import modelo.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneOctoberManagerImpl implements OneOctoberManager {


    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());

    private static OneOctoberManagerImpl instance;
    private Map <String, Player> mapPlayer;
    private Map <String, Objeto> mapObjeto;

    private OneOctoberManagerImpl(){
        this.mapPlayer = new HashMap();
        this.mapObjeto = new HashMap();}

    public static OneOctoberManagerImpl getInstance(){                 // Tiene que ser estático ??
        if(instance == null) {
            instance = new OneOctoberManagerImpl();
            log.info("Se ha instanciado controlador.OneOctoberManagerImpl por primera vez.");
        }
        return  instance;
    }


// Comprobar parametros de entrada dentro o fuera la funcion?
// Eliminar usuario/objeto -> si hay excepcion -> tiene que return false? o false + excepcion?
// JSONService: POST crearUsuarioInJSON parameter en argumento.


    /**
     * Comprueba nombre de usuario (isUser) y lo añade a mapPlayer (addUser).
     * @param user
     * @return true si se crea el usuario correctamente.
     * @throws UsuarioYaExisteException
     */
    public boolean crearUsuario(Player user) throws UsuarioYaExisteException {

        if(isUser(user.getNombre())) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        addUser(user);

        return true;                                                        // return true ya que operacion ok
    }

    /**
     * @param nombreUser
     * @return Player
     * @throws UsuarioNoExisteException
     */
    public Player consultarUsuario (String nombreUser) throws UsuarioNoExisteException {

        log.info("Inicio consultarUsuario: " + nombreUser);
        Player user = getUser(nombreUser);
        if( user == null) throw new UsuarioNoExisteException();

        log.info("Fin consultarUsuario: " + nombreUser + " con éxito.");
        return user;
    }

    /**
     * @return Lista de Players.
     * @throws ListaUsuariosVaciaException
     */
    public List<Player> consultarListaUsuarios() throws ListaUsuariosVaciaException {

        List<Player> listaPlayers = new ArrayList<>();
        if (!listaPlayers.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();

        return listaPlayers;
    }

    /**
     * modifica usuario user (sobreescribiendolo) con los atributos de user2
     * @param nombreUser nombre del usuario a sobreescribir
     * @param user2 usuario con las modificaciones que queremos hacer
     * @throws UsuarioNoExisteException
     */
    public void modificarUsuario (String nombreUser, Player user2) throws UsuarioNoExisteException{

        Player user = getUser(nombreUser);
        user.modificarUsuario(user2);
    }

    /**
     * Elinima usuario: comprueba que user existe (isUserVoid) y lo elimina.
     * @param nombreUser
     * @return true si eliminado
     * @throws UsuarioNoExisteException
     */
    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        isUserVoid(nombreUser);
        removeUser(nombreUser);
        return true;
    }

    /**
     * @param nombreUsuario
     * @param objeto
     * @throws UsuarioNoExisteException
     */
    public void anadirObjetoAUsuario (String nombreUsuario, Objeto objeto) throws UsuarioNoExisteException {

        Player user = getUser(nombreUsuario);
        user.insertarObjeto(objeto);
    }

    /**
     * @param nombreUser
     * @param nombreObjeto
     * @return Objeto de un Usuario
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    public Objeto consultarObjetoDeUsuario(String nombreUser, String nombreObjeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        Player usuario = getUser(nombreUser);
        Objeto objeto = usuario.getObjeto(nombreObjeto);

        return objeto;

    }

    /**
     * @param nombre
     * @return ListaObjetos de un usuario
     * @throws UsuarioSinObjetosException
     * @throws UsuarioNoExisteException
     */
    public List<Objeto> consultarListaObjetosDeUsuario (String nombre) throws UsuarioSinObjetosException, UsuarioNoExisteException {

        Player user = getUser(nombre);
        List<Objeto> listaObjetos = user.getInventarioUser().getListaObjetos();
        if (listaObjetos == null || listaObjetos.size() == 0) throw new UsuarioSinObjetosException();

        return listaObjetos;
    }

    /**
     * @param nombreUser
     * @param nombreObjeto
     * @return true si se elimina objeto correctamente.
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    public boolean eliminarObjetoDeUsuario(String nombreUser, String nombreObjeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        Player user = getUser(nombreUser);
        Objeto objeto = user.getObjeto(nombreObjeto);
        removeObjeto(user,objeto);
        return true;
    }





    /////     /////

    private void addUser (Player user){
        mapPlayer.put(user.getNombre(), user);
    }

    private Player getUser(String nombreUser) throws UsuarioNoExisteException{

        if (!mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
        return mapPlayer.get(nombreUser);
    }

    /**
     * Compara únicamente los nombres de Usuario de la lista.
     * @param listaPlayer
     * @return true si listas son iguales.
     */
    public boolean listaUserEsIgual (List<Player> listaPlayer){
        int cont = 0;
        for (Player p : listaPlayer){
            String nombreUser = p.getNombre();
            if(nombreUser.equals(this.mapPlayer.get(nombreUser).getNombre())){
                cont = cont + 1;
            }
        }
        if(cont == listaPlayer.size()) return true;
        return false;
    }

    private void removeUser(String nombreUser) {
        mapPlayer.remove(nombreUser);
    }

    private void removeObjeto(Player user, Objeto objeto) {
        user.getInventarioUser().getListaObjetos().remove(objeto);
    }

    private boolean isUser (String nombreUser) { return (mapPlayer.containsKey(nombreUser)); }

    private void isUserVoid (String nombreUser) throws UsuarioNoExisteException {
        if(!mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
    }

    public void reset() {
        this.instance = null;
    }


}
