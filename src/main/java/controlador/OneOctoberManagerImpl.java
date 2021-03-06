package controlador;

import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.*;
import modelo.mapa.Mapa;
import org.apache.log4j.Logger;
import org.glassfish.hk2.api.Rank;

import java.util.*;

public class OneOctoberManagerImpl implements OneOctoberManager {


    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());

    private static OneOctoberManagerImpl instance;


    private OneOctoberManagerImpl(){ }

    public static OneOctoberManagerImpl getInstance(){                 // Tiene que ser estático ??
        if(instance == null) {
            instance = new OneOctoberManagerImpl();
            log.info("Se ha instanciado controlador.OneOctoberManagerImpl por primera vez.");
        }
        return  instance;
    }




    public Usuario2 crearUsuario(Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {
        return createUser(user);// return true ya que operacion ok

    }
    // Tripas CrearUsuario
    private Usuario2 createUser (Usuario2 user) throws UsuarioYaExisteException, AccesoDenegado {

        Usuario userDAO= null;

        try {
            //Se crea el userDAO que interactuará con la DB
            userDAO = new Usuario(user.getNombre());
            userDAO.copyUser(user);     // funcion que copia todos los atributos de user a userDAO.

            //log.info("CreateUser entra a DAO.");
            if (!userDAO.insert()) throw new UsuarioYaExisteException();
            //log.info("CreateUser sale de DAO.");



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

            //log.info("Select entra a DAO.");
            userDAO.select();
            //log.info("Select surt de DAO.");

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

            //log.info("Select entra a DAO.");
            userDAO.checkUser(userDAO);
            //log.info("Select surt de DAO.");

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

    public List<Usuario2> consultarListaUsuarios(String nombreUser) throws ListaUsuariosVaciaException {
        return selectListUser(nombreUser);
    }

    private List<Usuario2> selectListUser(String nombreUser) {

        List<Object[]> listaUsuarios = new ArrayList<>();
        List<Usuario2> listaU = new ArrayList<>(1);

        try{
            Usuario2 user = new Usuario2(nombreUser);
            Usuario userDAO = new Usuario(nombreUser);

            userDAO.copyUser(user);
            //log.info("selectAll entra a DAO.");
            listaUsuarios = userDAO.selectAll();
            //log.info("selectAll surt de DAO.");


            int p = listaUsuarios.size();
            listaU = new ArrayList<Usuario2>(p);

            for(Object[] uuu : listaUsuarios){
                user = new Usuario2((String) uuu[0], (String) uuu[1], (String) uuu[2], (int) uuu[3], (String) uuu[4]);
                listaU.add(user);
            }

            listaU.sort(Comparator.comparingInt(Usuario2::getPuntFinal).reversed());



        }
        catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.getStackTrace());
            listaU.get(0).setResponse(-1);
        }
        return listaU;
    }

    public List<Ranking2> consultarListaRanking(String nombreUser) throws ListaUsuariosVaciaException {
        return selectListRanking(nombreUser);
    }

    private List<Ranking2> selectListRanking(String nombreUser) {

        List<Object[]> listaRanking = new ArrayList<>();
        List<Ranking2> listaR = new ArrayList<>(1);
        List<Ranking2> listaReturn = new ArrayList<>(1);
        Ranking2 rank2;

        try{
            rank2 = new Ranking2(nombreUser);
            Ranking rankDAO = new Ranking(nombreUser);

            rankDAO.copyRank(rank2);
            //log.info("selectAll entra a DAO.");
            listaRanking = rankDAO.selectAll();
            //log.info("selectAll surt de DAO.");


            int p = listaRanking.size();
            listaR = new ArrayList<Ranking2>(p);

            for(Object[] uuu : listaRanking){

                if(uuu[1].equals(nombreUser)){

                    rank2 = new Ranking2 ((String) uuu[0], (String) uuu[1], (int) uuu[2], (int) uuu[3], (int) uuu[4]);
                    listaReturn.add(rank2);
                }
            }
            //listaR.sort(Comparator.comparingInt(Ranking2::getPuntuaciontot).reversed());
        }
        catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.getStackTrace());
        }
        return listaReturn;
    }

    public Usuario2 modificarUsuario (Usuario2 user) {
        return updateUser(user);
    }
    private Usuario2 updateUser (Usuario2 user){

        Usuario userDAO = new Usuario(user.getNombre());
        userDAO.copyUser(user);

        try{
            //log.info("UpdateUser entra a DAO.");
            if(!userDAO.update()) throw new UsuarioNoActualizado();
            //log.info("UpdateUser surt de DAO.");

        } catch (Exception e){
            log.error(e.getMessage());
            user.setResponse(Integer.parseInt(e.getMessage()));
            return user;
        }

        return user;
    }

    public Ranking2 modificarRanking (Ranking2 rank) {
        return updateRank(rank);
    }
    private Ranking2 updateRank (Ranking2 rank){

        Ranking rankDAO = new Ranking(rank.getUsuario());
        rankDAO.copyRank(rank);

        try{
            //log.info("UpdateRank entra a DAO.");
            if(!rankDAO.insert()) throw new UsuarioNoActualizado();
            //log.info("UpdateRank surt de DAO.");

        } catch (Exception e){
            log.error(e.getMessage());
            rank.setResponse(Integer.parseInt(e.getMessage()));
            return rank;
        }

        return rank;
    }

    public boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException {
        return deleteUser(nombreUser);
    }
    private boolean deleteUser (String nombreUser) throws UsuarioNoExisteException {
        Usuario2 u = new Usuario2(nombreUser,"xxx","xxx");

        Usuario userDAO = new Usuario(u.getNombre());

        try {
            //log.info("deleteUser entra a DAO.");
            if(!userDAO.delete()) throw new UsuarioNoBorrado();
            //log.info("deleteUser surt de DAO.");
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

    public void reset() {
        this.instance = null;
    }





}