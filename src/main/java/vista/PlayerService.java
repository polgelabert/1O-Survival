package vista;

import controlador.*;
import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.Usuario;
import modelo.mapa.Mapa;

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

    Usuario user, user2;
    String nombreUser, nombreObjeto;
    Objeto objeto;


    public PlayerService() throws UsuarioYaExisteException {

        try {
          user = new Usuario("pol", "pass1234","pol123@gmail.com");
            Inventario inventario = new Inventario(100);
            //user.getMiNivel().setInventarioUser(inventario);
            objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
            //user.getMiNivel().getInventarioUser().getListaObjetos().add(objeto);
            objeto = new Objeto("mesa", "mesa para obstaculizar a los enemigos", 15, 3);
            //user.getMiNivel().getInventarioUser().getListaObjetos().add(objeto);
           // oneOct.crearUsuario(user);

            user2 = new Usuario("marc", "0000","marc22@gmail.com" );
            inventario = new Inventario(100);
            //user.getMiNivel().setInventarioUser(inventario);
            //oneOct.crearUsuario(user2);

        }
        catch (Exception e) {
            //log.fatal(e.getMessage() + e.getCause());
            //e.printStackTrace();
            throw e;
        }



       //oneOct.reset();
    }

    /**
     *
     * @param nombreUser
     * @return json Usuario
     * @throws UsuarioNoExisteException
     */
    @GET
    @Path("/player/{nombreUser}/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario consultarUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException {

        try {
            Usuario u = new Usuario(nombreUser,"xx","xx");
            //Usuario user = oneOct.consultarUsuario(nombreUser);
            return u;
            //return Response.status(200).build();
        } catch (Exception e) {
            throw e;
        }

    }

    @GET
    @Path("/player/{nombreUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlayerTO consultarUsuarioTOInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException {

        try {

            return new PlayerTO(oneOct.consultarUsuario(nombreUser,"j"));
        } catch (Exception e) {
            throw e;
        }

    }


    @GET
    @Path("/listaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> consultarListaDeUsuarioInJSON() throws ListaUsuariosVaciaException {

        try {
            return oneOct.consultarListaUsuarios();

        } catch (Exception e) {
            throw e;
        }
    }


    /*@GET
    @Path("/player/{nombreUser}/{nombreObjeto}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Objeto consultarObjetoDeUsuarioInJSON(@PathParam("nombreUser") String nombreUser, @PathParam("nombreObjeto") String nombreObjeto) throws UsuarioNoExisteException, ObjetoNoEncontradoException, UsuarioSinObjetosException {

        try {
            objeto = oneOct.consultarObjetoDeUsuario(nombreUser, nombreObjeto);
            return objeto;

        } catch (Exception e) {
            throw e;
        }
    }*/

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


    @POST
    @Path("/newUser")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Usuario user) throws UsuarioYaExisteException {
    public Response crearUsuarioInJSON(Usuario user) throws UsuarioYaExisteException, AccesoDenegado, InvocationTargetException, IllegalAccessException {
        try {

            log.info("Will see");
            boolean res = oneOct.crearUsuario(user);

            return Response.status(201).entity(1).build();
            //return consultarListaDeUsuarioInJSON();

        } catch (Exception e) {
            //e.printStackTrace();
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

    @GET        // Falta revisar.
    @Path("/player/{nombreUser}/{idMalla}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mapa consultarMapaInJSON(@PathParam("idMalla") int idMalla) throws UsuarioNoExisteException, UsuarioSinObjetosException, MapaNoEncontradoException {

        try {
            return  null;
            //return oneOct.consultarMapa(idMalla);

        } catch (Exception e) {
            throw e;
        }

    }



    /*@POST
    @Path("/Usuario/{nombreUser}/newObjeto")
    @Produces(MediaType.TEXT_PLAIN)
    //@Produces(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Usuario user) throws UsuarioYaExisteException {
    public Response anadirObjetoAUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioYaExisteException, UsuarioNoExisteException, ObjetoNoEncontradoException, UsuarioSinObjetosException {
        try {

            objeto = new Objeto("silla", "silla para avisar de dónde vienen los enemigos", 8, 2);
            oneOct.anadirObjetoAUsuario(nombreUser, objeto);

            return Response.status(201).entity(1).build();

        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        }
    }*/

    /*@POST
    @Path("/Usuario/{nombreUser}/removeObjeto/{nombreObjeto}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response eliminarObjetoDeUsuarioInJSON(@PathParam("nombreUser") String nombreUser, @PathParam("nombreObjeto") String nombreObjeto) throws UsuarioNoExisteException, ListaUsuariosVaciaException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        try {
            boolean res = oneOct.eliminarObjetoDeUsuario(nombreUser,nombreObjeto);
            return Response.status(201).entity(1).build();

        } catch (Exception e) {
            throw e;
        }
    }*/


}






