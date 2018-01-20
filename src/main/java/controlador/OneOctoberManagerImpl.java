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






    public Usuario2 crearUsuario(Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {
        return createUser(user);// return true ya que operacion ok



        // createUser(user);
        /*
        if(isUser(user.getNombre())) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        addUser(user);
        return true;*/
    }
    // Tripas CrearUsuario
    private Usuario2 createUser (Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {

        Usuario userDAO= null;

        try {
            //Se crea el userDAO que interactuará con la DB
            userDAO = new Usuario(user.getNombre());
            userDAO.copyUser(user);     // funcion que copia todos los atributos de user a userDAO.

            log.info("CreateUser entra a DAO.");
            if (!userDAO.insert()) throw new UsuarioYaExisteException();
            log.info("CreateUser sale de DAO.");



        }catch(Exception e){
            log.error(e.getMessage());
            user.setResponse(Integer.parseInt(e.getMessage()));
            return user;

            /// e.printStackTrace();
            //if (e.getMessage().contains("Duplicate entry")) throw new UsuarioYaExisteException();
            //if (e.getMessage().contains("Access denied")) throw new AccesoDenegado();
        }

        return user;
    }


    public Usuario2 consultarUsuario (String nombreUser) throws UsuarioNoExisteException {
        return selectUser(nombreUser);
    }
    //Tripas consultarUsuario
    private Usuario2 selectUser (String nombreUser) throws UsuarioNoExisteException {
        Usuario userDAO= null;
        Usuario2 user = null;

        try {

            userDAO = new Usuario(nombreUser, "xxx", "xxx");

            log.info("Select entra a DAO.");
            userDAO.select();
            log.info("Select surt de DAO.");

            // Se crea el Usuario2 (copiado del userDAO) que se retorna
            user = new Usuario2();
            user.copyUser(userDAO);

            if(user.getPassword().equals( "xxx") && user.getCorreo().equals("xxx")) throw new UsuarioNoExisteException();
        }
        catch (Exception e)  {
            user.setResponse(Integer.parseInt(e.getMessage()));
            return user;
        }

        return user;
    }

    public Usuario2 esUsuario (Usuario2 user) throws UsuarioNoExisteException {
        return isUser(user);
    }
    //Tripas consultarUsuario
    private Usuario2 isUser (Usuario2 user) throws UsuarioNoExisteException {
        Usuario userDAO= null;

        try {
            userDAO = new Usuario(user.getNombre(), user.getPassword(), "xxx");

            log.info("Select entra a DAO.");
            userDAO.checkUser(userDAO);
            log.info("Select surt de DAO.");

            // Se crea el Usuario2 (copiado del userDAO) que se retorna
            user = new Usuario2();
            user.copyUser(userDAO);

            if(user.getCorreo().equals("xxx")) throw new UsuarioNoExisteException();
        }
        catch (Exception e)  {
            user.setResponse(Integer.parseInt(e.getMessage()));
            return user;
        }

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
            log.info("selectAll entra a DAO.");
            userDAO.selectAll();
            log.info("selectAll surt de DAO.");
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        return listaUsuarios;

        /*if (!listaUsuarios.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();
        return listaUsuarios;
        */


    }



    public Usuario2 modificarUsuario (Usuario2 user) throws UsuarioNoExisteException {
        return updateUser(user);
    }
    private Usuario2 updateUser (Usuario2 user){

        Usuario userDAO = new Usuario(user.getNombre());
        userDAO.copyUser(user);

        try{
            log.info("UpdateUser entra a DAO.");
            if(!userDAO.update()) throw new UsuarioNoActualizado();
            log.info("UpdateUser surt de DAO.");

        } catch (Exception e){
            log.error(e.getMessage());
            user.setResponse(Integer.parseInt(e.getMessage()));
            return user;
        }

        return user;
    }



    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        return deleteUser(nombreUser);
    }
    private boolean deleteUser (String nombreUser) throws UsuarioNoExisteException {
        Usuario2 u = new Usuario2(nombreUser,"xxx","xxx");

        Usuario userDAO = new Usuario(u.getNombre());

        try {
            log.info("deleteUser entra a DAO.");
            if(!userDAO.delete()) throw new UsuarioNoBorrado();
            log.info("deleteUser surt de DAO.");
        }
        catch (Exception e){
            log.error(e.getMessage());
            return false;
        }

        return true;
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