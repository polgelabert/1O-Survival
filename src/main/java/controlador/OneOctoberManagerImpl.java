package controlador;

import controlador.excepciones.*;
import modelo.*;
import modelo.mapa.Mapa;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneOctoberManagerImpl implements OneOctoberManager {


    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());

    private static OneOctoberManagerImpl instance;
    private Map <String, Player> mapPlayer;
    // PUSE UN MAPA DE OBJETOS (mapObjeto) QUE SERIA COMO UNA DATABASE DÓNDE ALMAZENAR TODOS LOS OBJETOS DISPONIBLES EN EL JUEGO...
    // CUANDO SE AÑADEN DESDE EL INVENTARIO, LOS COGE DE ESTE MAP. CUANDO SE QUITA, SE BORRA SOLAMENTE DEL INVENTARIO YA QUE
    // OTROS USUARIOS PUEDEN TENER ESTE MISMO OBJETO.
    private Map <String, Objeto> mapObjeto;
    private Map <Integer, Mapa> mapMapas;

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

////////     COMENTARIOS       ///////
// mapObjeto comentario
// Comprobar parametros de entrada dentro o fuera la funcion?
// PlayerService: POST crearUsuarioInJSON parameter en argumento.
// Modificar usuario
// interfaz correcta?



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
        //getUser ya lanza la excepcion. Ademas, getUser retorna el user este o no (despues del ContainsKey), devolvera null?

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
     * Elinima usuario: comprueba que user existe (isUserVoid) y lo elimina.
     * @param nombreUser
     * @return true si eliminado
     * @throws UsuarioNoExisteException
     */
    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        //Player user = getUser(nombreUser);
        isUserVoid(nombreUser);
        removeUser(nombreUser);
        return true;
    }

    /**
     * @param nombre
     * @return ListaObjetos de un usuario
     * @throws UsuarioSinObjetosException
     * @throws UsuarioNoExisteException
     */
    public List<Objeto> consultarInventarioDeUsuario (String nombre) throws UsuarioSinObjetosException, UsuarioNoExisteException {

        Player user = getUser(nombre);
        List<Objeto> inventario = user.getInventarioUser().getListaObjetos();
        if (inventario == null || inventario.size() == 0) throw new UsuarioSinObjetosException();

        return inventario;
    }


    public PlayerTO playerTO (Player user){

        return new PlayerTO(user);

    }

    public Mapa consultarMapa(int idMalla) throws MapaNoEncontradoException {
        return getMapa(idMalla);
    }


    /*public void modificarUsuario (String nombreUser, Player user2) throws UsuarioNoExisteException{

        Player user = getUser(nombreUser);
        user.modificarUsuario(user2);
    }*/




    /////   METODOS PRIVADOS (TRIPAS) -> English  /////
    //nueva pol
    public void insertObjet2mapObjeto(Objeto objeto) {
        mapObjeto.put(objeto.getNombreObjeto(), objeto);
    }
    // nueva pol
    public Objeto getObjectFrommapObjeto(String microfono) {
        return this.mapObjeto.get(microfono);
    }

    private void addUser (Player user){ this.mapPlayer.put(user.getNombre(), user); }

    private Player getUser(String nombreUser) throws UsuarioNoExisteException{

        if (!this.mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
        return this.mapPlayer.get(nombreUser);
    }

    /**
     * Compara únicamente los nombres de Usuario de la lista.
     * @param listaPlayer
     * @return true si listas son iguales.
     */
    public boolean listUserIsEqual(List<Player> listaPlayer){
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
        this.mapPlayer.remove(nombreUser);
    }

    private void removeObjet(Player user, Objeto objeto) {
        user.getInventarioUser().getListaObjetos().remove(objeto);
    }

    private boolean isUser (String nombreUser) { return (mapPlayer.containsKey(nombreUser)); }

    private void isUserVoid (String nombreUser) throws UsuarioNoExisteException {
        if(!mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
    }

    private Mapa getMapa(int idMalla) throws MapaNoEncontradoException {
        if(mapMapas.get(idMalla) == null) throw new MapaNoEncontradoException();
        return mapMapas.get(idMalla);
    }

    public void reset() {
        this.instance = null;
    }



}
