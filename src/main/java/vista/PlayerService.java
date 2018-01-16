package vista;

import controlador.*;
import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.Usuario2;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * POSTMAN LINK: https://www.getpostman.com/collections/6b68f7f14c1864bcc18d
 */

@Path("/game")
@Singleton
public class PlayerService {


    public OneOctoberManager oneOct = OneOctoberManagerImpl.getInstance();
    Logger log = Logger.getLogger(PlayerService.class.getName());

    Usuario2 user, user2;
    String nombreUser, nombreObjeto;
    Objeto objeto;


    public PlayerService() throws UsuarioYaExisteException {

        /*try {

          user = new Usuario2("pol", "pass1234","pol123@gmail.com");
            Inventario inventario = new Inventario(100);
            //user.getMiNivel().setInventarioUser(inventario);
            objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
            //user.getMiNivel().getInventarioUser().getListaObjetos().add(objeto);
            objeto = new Objeto("mesa", "mesa para obstaculizar a los enemigos", 15, 3);
            //user.getMiNivel().getInventarioUser().getListaObjetos().add(objeto);
           // oneOct.crearUsuario(user);

            user2 = new Usuario2("marc", "0000","marc22@gmail.com" );
            inventario = new Inventario(100);
            //user.getMiNivel().setInventarioUser(inventario);
            //oneOct.crearUsuario(user2);

        }
        catch (Exception e) {
            //log.fatal(e.getMessage() + e.getCause());
            //e.printStackTrace();
            throw e;
        }*/
       //oneOct.reset();


    }

    @POST
    @Path("/newUser")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Usuario2 user) throws UsuarioYaExisteException {
    public int crearUsuarioInJSON(Usuario2 user) throws UsuarioYaExisteException, IllegalAccessException, AccesoDenegado, InvocationTargetException {

        try {

            boolean res = oneOct.crearUsuario(user);
            if(res) return 1;
            else return 0;

        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        }
    }


    @GET
    @Path("/player/{nombreUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario2 consultarUsuarioTOInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException {

        try {
            return  oneOct.consultarUsuario(nombreUser);

        } catch (Exception e) {
            throw e;
        }

    }


    @GET
    @Path("/listaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario2> consultarListaDeUsuarioInJSON() throws ListaUsuariosVaciaException {

        try {
            return oneOct.consultarListaUsuarios();

        } catch (Exception e) {
            throw e;
        }
    }


    @GET
    @Path("/player/{nombreUser}/inventario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Objeto> consultarListaObjetosDeUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException, UsuarioSinObjetosException {
        List<Objeto> k = new ArrayList<>();
        try {
            return  null;

        } catch (Exception e) {
            throw e;
        }

    }

    @DELETE
    @Path("/removePlayer/{nombreUser}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response eliminarUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException, ListaUsuariosVaciaException {

        try {
            boolean res = oneOct.eliminarUsuario(nombreUser);

            return Response.status(201).entity(1).build();
            //return Response.status(201).entity(oneOct.consultarListaUsuarios().size()).build();

        } catch (Exception e) {
            throw e;
        }
    }






}






