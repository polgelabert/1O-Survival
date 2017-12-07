import controlador.OneOctoberManagerImpl;
import controlador.excepciones.*;
import modelo.Inventario;
import modelo.Objeto;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

import modelo.PlayerTO;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertTrue;


public class TestModelo {

    final static Logger log = Logger.getLogger(TestModelo.class.getName());          // test2.class.getname indica el nombre de la clase.

    private OneOctoberManagerImpl oneOct;

    Usuario user, user2;
    String nombreUser, nombreObjeto;
    Objeto objeto;


    @Before
    public void SetUp() throws UsuarioYaExisteException {

        this.oneOct = OneOctoberManagerImpl.getInstance();

        try {
            user = new Usuario("pol", "contra1", "pol1@gmail.com" );
            objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);

            //Se inserta el objeto a mapObjeto
            oneOct.insertObjet2mapObjeto(objeto);

            //se añade al usuario user, el objeto sacado de la base de datos
            objeto = oneOct.getObjectFrommapObjeto("microfono");
            Inventario inventario = new Inventario(100);
            user.getMiNivel().setInventarioUser(inventario);
            user.getMiNivel().getInventarioUser().añadirObjeto(objeto);

            // Esta la he comentado ya que en en juego cuando te encuentres un objeto, ya estará creado... Por este motivo necesitaras cogerlo
            // del HashMap de Objetos. Y en esta linea si no lo creas, petará.
            //user.getInventarioUser().getListaObjetos().add(objeto);

            oneOct.crearUsuario(user);

            user = new Usuario("marc", "contra2", "marc1@gmail.com" );
            oneOct.crearUsuario(user);

            }
        catch (Exception e) {
            //log.fatal(e.getMessage() + e.getCause());
            //e.printStackTrace();
            throw e;
        }

    }

    @After
    public void tearDown () {
        oneOct.getInstance().reset();
    }

    /**
     * @throws UsuarioYaExisteException
     * @throws ListaUsuariosVaciaException
     */
    @Test
    public void crearUsuarioTest() throws UsuarioYaExisteException, ListaUsuariosVaciaException {
        // Intento crar un usuario con el mismo nombre de otro usuario -> Excepcion UsuarioYaExiste:
        user = new Usuario("pol", "contra1", "pol1@gmail.com");
        Assertions.assertThrows(UsuarioYaExisteException.class, () -> { oneOct.crearUsuario(user); });

        // Se crea correctamente el usuario.
        user2 = new Usuario("juan", "juanpass", "juan@gmail.com");
        assertTrue(oneOct.crearUsuario(user2));


    }

    /**
     * @throws UsuarioNoExisteException
     */
    @Test
    public void consultarUsuarioTest() throws UsuarioNoExisteException {

        // Consulta de un usuario inexistente.
        nombreUser = "BadName";
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { oneOct.consultarUsuario(nombreUser);});

        // Consulta correcta del usuario.
        nombreUser = "pol";
        Usuario user = oneOct.consultarUsuario(nombreUser);


    }

    /**
     * @throws ListaUsuariosVaciaException
     * @throws UsuarioNoExisteException
     */
    @Test
    public void consultarListaUsuariosTest() throws ListaUsuariosVaciaException, UsuarioNoExisteException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios = oneOct.consultarListaUsuarios();
        Assert.assertTrue(oneOct.listUserIsEqual(listaUsuarios));        // Comprueba que la lista que saca por pantalla es correcta.

        // Intenta mostrar una lista de usuarios vacia -> Excpecion ListaUsuariosVacia
        oneOct.eliminarUsuario("pol");
        oneOct.eliminarUsuario("marc");
        Assertions.assertThrows(ListaUsuariosVaciaException.class, () -> {oneOct.consultarListaUsuarios() ;});
    }

    /*@Test
    public void modificarUsuarioTest() throws UsuarioNoExisteException{

        user = oneOct.consultarUsuario("pol");
        int nuevaVida = 250;
        user2 = new Usuario("pol", nuevaVida,50, 1);
        objeto = new Objeto("casco", "casco que minimiza los golpes de los enemigos", 1, 1);
        user2.getInventarioUser().getListaObjetos().add(objeto);
        user.modificarUsuario(user2);

        Assertions.assertEquals(nuevaVida, oneOct.consultarUsuario(user.getNombre()).getVida());
    }*/

    /**
     * @throws UsuarioNoExisteException
     */
    @Test
    public void eliminarUsuarioTest() throws UsuarioNoExisteException {

        nombreUser = "pol";
        Assertions.assertNotNull(oneOct.consultarUsuario(nombreUser));

        Assertions.assertTrue(oneOct.eliminarUsuario(nombreUser));
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { oneOct.consultarUsuario(nombreUser);});

    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    @Test
    public void anadirObjetoAUsuarioTest() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        nombreUser = "pol";
        user = oneOct.consultarUsuario(nombreUser);

        // Comprueba que se lanza ObjetoNoEncontradoException, UsuarioNoExisteException y UsuarioSinObjetosException.
       // Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> { user.getInventarioUser().(nombreUser, "BadObjectName");});
        //Assertions.assertThrows(UsuarioNoExisteException.class, () -> { oneOct.consultarObjetoDeUsuario("BadName", oneOct.consultarUsuario(nombreUser).getInventarioUser().getListaObjetos().get(0).getNombreObjeto());});
       // Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario("marc", "casco" );});

        objeto = new Objeto("casco", "casco que minimiza los golpes de los enemigos", 1, 1);

        user.getMiNivel().getInventarioUser().añadirObjeto(objeto);
        //boolean result = user.getInventarioUser().getListaObjetos().get(1).objetoEsIgual(objeto);
        //assertTrue(result);

        Assertions.assertEquals(2, user.getMiNivel().getInventarioUser().getListaObjetos().size());
    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    @Test
    public void consultarObjetoDeUsuarioTest() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        // Usuario sin objetos
        //user = oneOct.consultarUsuario("marc");
        //Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { user.getInventarioUser().sacarObjeto();});

        // Consultar objeto con BadObjectName
        nombreUser = "pol";
        user2 = oneOct.consultarUsuario(nombreUser);
        //Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> { user2.getInventarioUser().(nombreUser, "BadObjectName");});


        objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
        boolean res = user2.getMiNivel().getInventarioUser().sacarObjeto(objeto);


    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     */
    @Test
    public void consultarInventarioDeUsuarioTest() throws  UsuarioNoExisteException, UsuarioSinObjetosException {

        nombreUser = "marc";
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarInventarioDeUsuario(nombreUser);});

        nombreUser = "pol";
        user = oneOct.consultarUsuario(nombreUser);
        List<Objeto> listaObjetos = oneOct.consultarInventarioDeUsuario(nombreUser);

    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    @Test
    public void eliminarObjetoDeUsuario() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        // HAY QUE REDEFINIR COMO SE HACE..

         nombreUser = "pol";
        user = oneOct.consultarUsuario(nombreUser);


        nombreObjeto = "microfono";
        //user.getInventarioUser().sacarObjeto(objeto);


       // Assertions.assertTrue(oneOct.eliminarObjetoDeUsuario(nombreUser, nombreObjeto));
       // Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario(nombreUser, nombreObjeto);});
    }

    @Test
    public void userTOTest() throws UsuarioNoExisteException {
        PlayerTO user = new PlayerTO(oneOct.consultarUsuario("pol"));
    }

}
