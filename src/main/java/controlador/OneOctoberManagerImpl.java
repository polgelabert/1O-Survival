package controlador;

import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.DAO;
import modelo.clasesTablas.Niveltable;
import modelo.clasesTablas.Usuario2;
import modelo.clasesTablas.Usuario;
import modelo.mapa.Mapa;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneOctoberManagerImpl implements OneOctoberManager {


    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());

    private static OneOctoberManagerImpl instance;
    private Map <String, Usuario2> mapPlayer;
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






    public boolean crearUsuario(Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {
        return createUser(user);// return true ya que operacion ok



        // createUser(user);
        /*
        if(isUser(user.getNombre())) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        addUser(user);
        return true;*/
    }

    // Tripas CrearUsuario
    private boolean createUser (Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {

        boolean insertado = false;
        try {

            //Se crea el userDAO que interactuará con la DB
            Usuario userDAO = new Usuario(user.getNombre());
            userDAO.copyUser(user);     // funcion que copia todos los atributos de user a userDAO.

            Exception e = userDAO.insert();
            insertado = true;

            if (e != null) {
                throw e;
            }


        }catch(Exception e){

            insertado = false;
           /// e.printStackTrace();
            if (e.getMessage().contains("Duplicate entry")) throw new UsuarioYaExisteException();
            if (e.getMessage().contains("Access denied")) throw new AccesoDenegado();
        }


       return insertado;
    }


    public Usuario2 consultarUsuario (String nombreUser) throws UsuarioNoExisteException {
        return selectUser(nombreUser);
    }

    //Tripas consultarUsuario
    private Usuario2 selectUser (String nombreUser) throws UsuarioNoExisteException {
        //Usuario2 u = null;

        //Se crea el usuario que interactua con el DAO
        Usuario userDAO = new Usuario(nombreUser,"xxx","xxx");


         userDAO.select();


        if(userDAO.getNombre() == "xxx" & userDAO.getCorreo()== "xxx") throw new UsuarioNoExisteException();

        // Se crea el Usuario2 (copiado del userDAO) que se retorna
        Usuario2 user = new Usuario2();
        user.copyUser(userDAO);

        return user;
    }


    public List<Object[]> consultarListaUsuarios(Usuario2 user) throws ListaUsuariosVaciaException {

        //List<Usuario2> listaUsuarios = new ArrayList<>();
        /*if (!listaUsuarios.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();

        return listaUsuarios;
        */

        return selectListUser(user);

    }
    private List<Object[]> selectListUser(Usuario2 user) {

        List<Object[]> listaUsuarios = new ArrayList<>();

        try{

            //Usuario2 u = consultarUsuario(user);

            Usuario userDAO = new Usuario(user.getNombre());
            userDAO.copyUser(user);

            userDAO.selectAll();

        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return listaUsuarios;

        /*if (!listaUsuarios.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();

        return listaUsuarios;
        */


    }


    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        //Usuario2 user = getUser(nombreUser);
        //(nombreUser);
        //removeUser(nombreUser);
        return deleteUser(nombreUser);
    }
    private boolean deleteUser (String nombreUser) throws UsuarioNoExisteException {
        //Usuario2 user = getUser(nombreUser);
        boolean borrado = false;
        Usuario2 u = new Usuario2(nombreUser,"xxx","xxx");

        Usuario userDAO = new Usuario(nombreUser);
        //userDAO.copyUser(user);

        try {

            userDAO.delete();
            borrado = true;
        }
        catch (Exception e){borrado=false;}

        return borrado;
    }

    public boolean modificarUsuario (Usuario2 user) throws UsuarioNoExisteException {
        return updateUser(user);
    }
    private boolean updateUser (Usuario2 user){
        boolean actualizado = false;

        Usuario userDAO = new Usuario(user.getNombre());
        userDAO.copyUser(user);

        try{

            userDAO.update();
            actualizado = true;

        } catch (Exception e){
            actualizado = false;
        }

        return actualizado;
    }


    public Niveltable seleccionarNivel (String idMapa)  {

       return selectLevel(idMapa);
    }
    private Niveltable selectLevel (String idMapa){
        Niveltable actNivel = null;
        ArrayList<Object[]> datos;

        Niveltable nivel = new Niveltable(idMapa);
        try {
            //datos = nivel.select();
            //Object[] j = datos.get(0);
            //actNivel = new Niveltable((String) j[0], (Integer) j[1], (ArrayList) j[2], (String) j[3], (String) j[4], (String) j[5]);
        }
        catch (Exception e){}
        return actNivel;
    }

    /*
    public PlayerTO playerTO (Usuario2 user){

        return new PlayerTO(user);

    }*/

    /*public Mapa consultarMapa(int idMalla) throws MapaNoEncontradoException {
        return getMapa(idMalla);
    }*/


    /*public void modificarUsuario (String nombreUser, Usuario2 user2) throws UsuarioNoExisteException{

        Usuario2 user = getUser(nombreUser);
        user.modificarUsuario(user2);
    }*/




    /////   METODOS PRIVADOS (TRIPAS) -> English  /////
    //nueva pol
    public void insertObjet2mapObjeto(Objeto objeto) {
        mapObjeto.put(objeto.getNombreObjeto(), objeto);
    }
    // nueva pol
    /*public Objeto getObjectFrommapObjeto(String microfono) {
        return this.mapObjeto.get(microfono);
    }*/

    private void addUser (Usuario2 user){ this.mapPlayer.put(user.getNombre(), user); }

    private Usuario2 getUser(String nombreUser) throws UsuarioNoExisteException{

        if (!this.mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
        return this.mapPlayer.get(nombreUser);
    }


    public boolean listUserIsEqual(List<Usuario2> listaUsuario){
        int cont = 0;
        for (Usuario2 p : listaUsuario){
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

    private void removeObjet(Usuario2 user, Objeto objeto) {
        //user.getMiNivel().getInventarioUser().getListaObjetos().remove(objeto);
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
