package vista;

import controlador.*;
import controlador.excepciones.*;
import modelo.*;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * POSTMAN LINK: https://www.getpostman.com/collections/6b68f7f14c1864bcc18d
 */

@Path("/game")
@Singleton
public class PlayerService {


    public OneOctoberManager oneOct = OneOctoberManagerImpl.getInstance();

    Player user, user2;
    String nombreUser, nombreObjeto;
    Objeto objeto;


    public PlayerService() throws UsuarioYaExisteException {

        try {
            user = new Player("pol", 200, 50, 1 );
            objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
            user.getInventarioUser().getListaObjetos().add(objeto);
            objeto = new Objeto("mesa", "mesa para obstaculizar a los enemigos", 15, 3);
            user.getInventarioUser().getListaObjetos().add(objeto);
            oneOct.crearUsuario(user);

            user = new Player("marc", 150, 30, 2 );
            oneOct.crearUsuario(user);

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
     * @return json Player
     * @throws UsuarioNoExisteException
     */
    @GET
    @Path("/player/{nombreUser}/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Player consultarUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException {

        try {

            Player user = oneOct.consultarUsuario(nombreUser);
            return user;
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

            return new PlayerTO(oneOct.consultarUsuario(nombreUser));

        } catch (Exception e) {
            throw e;
        }

    }


    @GET
    @Path("/listaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> consultarListaDeUsuarioInJSON() throws ListaUsuariosVaciaException {

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

        try {
            return oneOct.consultarInventarioDeUsuario(nombreUser);

        } catch (Exception e) {
            throw e;
        }

    }


    @POST
    @Path("/newPlayer")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Player user) throws UsuarioYaExisteException {
    public Response crearUsuarioInJSON(Player user) throws UsuarioYaExisteException {
        try {

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
    public Mapa consultarListaObjetosDeUsuarioInJSON(@PathParam("idMalla") int idMalla) throws UsuarioNoExisteException, UsuarioSinObjetosException, MapaNoEncontradoException {

        try {
            return oneOct.consultarMapa(idMalla);

        } catch (Exception e) {
            throw e;
        }

    }



    /*@POST
    @Path("/Player/{nombreUser}/newObjeto")
    @Produces(MediaType.TEXT_PLAIN)
    //@Produces(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Player user) throws UsuarioYaExisteException {
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
    @Path("/Player/{nombreUser}/removeObjeto/{nombreObjeto}")
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






