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
    private Map <String, Usuario> mapPlayer;
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




    /**
     * Comprueba nombre de usuario (isUser) y lo añade a mapPlayer (addUser).
     * @param user
     * @return true si se crea el usuario correctamente.
     * @throws UsuarioYaExisteException
     */
    public boolean crearUsuario(Usuario user) throws UsuarioYaExisteException {

        if(isUser(user.getNombre())) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        addUser(user);

        return true;                                                        // return true ya que operacion ok
    }

    /**
     * @param nombreUser
     * @return Usuario
     * @throws UsuarioNoExisteException
     */
    public Usuario consultarUsuario (String nombreUser) throws UsuarioNoExisteException {

        log.info("Inicio consultarUsuario: " + nombreUser);
        Usuario user = getUser(nombreUser);
        //getUser ya lanza la excepcion. Ademas, getUser retorna el user este o no (despues del ContainsKey), devolvera null?

        log.info("Fin consultarUsuario: " + nombreUser + " con éxito.");
        return user;
    }

    /**
     * @return Lista de Players.
     * @throws ListaUsuariosVaciaException
     */
    public List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException {

        List<Usuario> listaUsuarios = new ArrayList<>();
        if (!listaUsuarios.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();

        return listaUsuarios;
    }


    /**
     * Elinima usuario: comprueba que user existe (isUserVoid) y lo elimina.
     * @param nombreUser
     * @return true si eliminado
     * @throws UsuarioNoExisteException
     */
    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        //Usuario user = getUser(nombreUser);
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

        Usuario user = getUser(nombre);
        if(user.getMiNivel().getInventarioUser() == null || user.getMiNivel().getInventarioUser().getListaObjetos().size() == 0) throw  new UsuarioSinObjetosException();

        return user.getMiNivel().getInventarioUser().getListaObjetos();
    }


    public PlayerTO playerTO (Usuario user){

        return new PlayerTO(user);

    }

    public Mapa consultarMapa(int idMalla) throws MapaNoEncontradoException {
        return getMapa(idMalla);
    }


    /*public void modificarUsuario (String nombreUser, Usuario user2) throws UsuarioNoExisteException{

        Usuario user = getUser(nombreUser);
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

    private void addUser (Usuario user){ this.mapPlayer.put(user.getNombre(), user); }

    private Usuario getUser(String nombreUser) throws UsuarioNoExisteException{

        if (!this.mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
        return this.mapPlayer.get(nombreUser);
    }

    /**
     * Compara únicamente los nombres de Usuario de la lista.
     * @param listaUsuario
     * @return true si listas son iguales.
     */
    public boolean listUserIsEqual(List<Usuario> listaUsuario){
        int cont = 0;
        for (Usuario p : listaUsuario){
            String nombreUser = p.getNombre();
            if(nombreUser.equals(this.mapPlayer.get(nombreUser).getNombre())){
                cont = cont + 1;
            }
        }
        if(cont == listaUsuario.size()) return true;
        return false;
    }

    private void removeUser(String nombreUser) {
        this.mapPlayer.remove(nombreUser);
    }

    private void removeObjet(Usuario user, Objeto objeto) {
        user.getMiNivel().getInventarioUser().getListaObjetos().remove(objeto);
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
