package controlador;

import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.Niveltable;
import modelo.clasesTablas.Usuario;
import modelo.mapa.Mapa;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
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






    public boolean crearUsuario(Usuario user) throws UsuarioYaExisteException, AccesoDenegado {
        //createUser(user);

        /*
        if(isUser(user.getNombre())) throw new UsuarioYaExisteException();          // lanza excepcion si isUser== true (lo contiene)
        addUser(user);

        return true;*/
        return createUser(user);// return true ya que operacion ok
    }
    private boolean createUser (Usuario user) throws UsuarioYaExisteException, AccesoDenegado {

        boolean insertado = true;
        try {
            Exception e = user.insert();
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


    public Usuario consultarUsuario (String nombreUser) throws UsuarioNoExisteException {
        return selectUser(nombreUser);
    }

    //Tripas consultarUsuario
    private Usuario selectUser (String nombreUser) throws UsuarioNoExisteException {
        Usuario u = null;
        u = new Usuario(nombreUser,"xxx","xxx");
        try{
            u.select();
        }catch (Exception e){
            log.error(e.getMessage());
        }

        if(u.getPassword() == "xxx" & u.getCorreo()== "xxx") throw new UsuarioNoExisteException();
        return u;
    }


    public List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException {

        List<Usuario> listaUsuarios = new ArrayList<>();
        /*if (!listaUsuarios.addAll(mapPlayer.values())) throw new ListaUsuariosVaciaException();

        return listaUsuarios;
        */

        return selectListUser();

    }
    private List<Usuario> selectListUser() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        try{


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
        //Usuario user = getUser(nombreUser);
        //(nombreUser);
        //removeUser(nombreUser);
        return deleteUser(nombreUser);
    }
    private boolean deleteUser (String nombreUser) throws UsuarioNoExisteException {
        //Usuario user = getUser(nombreUser);
        boolean borrado = true;
        Usuario u = new Usuario(nombreUser,"xx","xx");
        try {
            u.delete();
        }
        catch (Exception e){borrado=false;}

        return borrado;
    }

    public boolean modificarUsuario (Usuario nombreUser) throws UsuarioNoExisteException {


        //Usuario user = getUser(nombreUser);
        //(nombreUser);
        //removeUser(nombreUser);
        return updateUser(nombreUser);
    }
    private boolean updateUser (Usuario user){
        boolean actualizado =true;
        try{
            user.update();

        }catch (Exception e){


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
    public PlayerTO playerTO (Usuario user){

        return new PlayerTO(user);

    }*/

    /*public Mapa consultarMapa(int idMalla) throws MapaNoEncontradoException {
        return getMapa(idMalla);
    }*/


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
    /*public Objeto getObjectFrommapObjeto(String microfono) {
        return this.mapObjeto.get(microfono);
    }*/

    private void addUser (Usuario user){ this.mapPlayer.put(user.getNombre(), user); }

    private Usuario getUser(String nombreUser) throws UsuarioNoExisteException{

        if (!this.mapPlayer.containsKey(nombreUser)) throw new UsuarioNoExisteException();
        return this.mapPlayer.get(nombreUser);
    }


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
