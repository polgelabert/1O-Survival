package vista;

import controlador.*;
import controlador.excepciones.*;
import modelo.*;
import modelo.clasesTablas.Usuario;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //public Response crearUsuarioInJSON(@QueryParam("user") Usuario2 user) throws UsuarioYaExisteException {
    public Usuario2 crearUsuarioInJSON(Usuario2 user) throws UsuarioYaExisteException, IllegalAccessException, AccesoDenegado, InvocationTargetException {


        return  oneOct.crearUsuario(user);

        /*try {

            return  oneOct.crearUsuario(user);
            //if(res) return 1;
            //else return 0;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }*/
    }


    @GET
    @Path("/player/{nombreUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario2 consultarUsuarioTOInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException {

        return  oneOct.consultarUsuario(nombreUser);

        /*try {
            return  oneOct.consultarUsuario(nombreUser);

        }
        catch (Exception e) {
            throw e;
        }*/

    }


    @POST
    @Path("/isUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario2 esUsuarioApi(Usuario2 user) throws UsuarioNoExisteException {

        return  oneOct.esUsuario(user);

        /*try {
            return  oneOct.consultarUsuario(nombreUser);

        }
        catch (Exception e) {
            throw e;
        }*/

    }



    @POST
    @Path("/listaUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Object[]> consultarListaUsuariosInJSON(Usuario2 user) throws ListaUsuariosVaciaException {

        try {
            return oneOct.consultarListaUsuarios(user);

        } catch (Exception e) {
            throw e;
        }
    }


    @POST
    @Path("/player/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario2 modificarUsuarioInJSON(Usuario2 user) throws UsuarioNoExisteException, UsuarioSinObjetosException {


        return oneOct.modificarUsuario(user);

        /*try {

            if(oneOct.modificarUsuario(user)) return 1;
            else return 0;

        } catch (Exception e) {
            throw e;
        }*/

    }

    @DELETE
    @Path("/removePlayer/{nombreUser}")
    @Produces(MediaType.TEXT_PLAIN)
    public int eliminarUsuarioInJSON(@PathParam("nombreUser") String nombreUser) throws UsuarioNoExisteException, ListaUsuariosVaciaException {

        try {

            if(oneOct.eliminarUsuario(nombreUser)) return 1;
            else return 0;


            //return Response.status(201).entity(1).build();
            //return Response.status(201).entity(oneOct.consultarListaUsuarios().size()).build();

        } catch (Exception e) {
            throw e;
        }
    }








}






