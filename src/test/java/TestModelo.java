import controlador.OneOctoberManagerImpl;
import controlador.excepciones.*;
import modelo.Objeto;
import modelo.Player;

import java.util.ArrayList;
import java.util.List;
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

    Player user, user2;
    String nombreUser, nombreObjeto;
    Objeto objeto;


    @Before
    public void SetUp() throws UsuarioYaExisteException {

        this.oneOct = OneOctoberManagerImpl.getInstance();

        try {
            user = new Player("pol", 200, 50, 1 );
            objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
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
        user = new Player("pol", 100, 50, 1 );
        Assertions.assertThrows(UsuarioYaExisteException.class, () -> { oneOct.crearUsuario(user); });

        user2 = new Player("juanito", 90, 40, 2 );
        assertTrue(oneOct.crearUsuario(user2));

        //Assertions.assertEquals(4, oneOct.consultarListaUsuarios().size());

    }

    /**
     * @throws UsuarioNoExisteException
     */
    @Test
    public void consultarUsuarioTest() throws UsuarioNoExisteException {

        nombreUser = "BadName";
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { oneOct.consultarUsuario(nombreUser);});


        Player userEsperado = new Player("pol", 200, 50, 1);
        objeto = new Objeto("espada", "espada para luchar contra los enemigos", 5, 2);
        userEsperado.getInventarioUser().getListaObjetos().add(objeto);

        nombreUser = "pol";
        Player user = oneOct.consultarUsuario(nombreUser);
        boolean res = user.usuarioEsIgual(userEsperado);
       // Assertions.assertTrue(user.usuarioEsIgual(userEsperado));
    }

    /**
     * @throws ListaUsuariosVaciaException
     * @throws UsuarioNoExisteException
     */
    @Test
    public void consultarListaUsuariosTest() throws ListaUsuariosVaciaException, UsuarioNoExisteException {
        List<Player> listaPlayers = new ArrayList<>();

        listaPlayers = oneOct.consultarListaUsuarios();
        Assert.assertTrue(oneOct.listaUserEsIgual(listaPlayers));

        oneOct.eliminarUsuario("pol");
        oneOct.eliminarUsuario("marc");
        Assertions.assertThrows(ListaUsuariosVaciaException.class, () -> {oneOct.consultarListaUsuarios() ;});
    }

    /**
     * @throws UsuarioNoExisteException
     */
    @Test
    public void modificarUsuarioTest() throws UsuarioNoExisteException{

        user = oneOct.consultarUsuario("pol");
        int nuevaVida = 250;
        user2 = new Player("pol", nuevaVida,50, 1);
        objeto = new Objeto("casco", "casco que minimiza los golpes de los enemigos", 1, 1);
        user2.getInventarioUser().getListaObjetos().add(objeto);
        user.modificarUsuario(user2);

        Assertions.assertEquals(nuevaVida, oneOct.consultarUsuario(user.getNombre()).getVida());
    }

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

        // Comprueba que se lanza ObjetoNoEncontradoException, UsuarioNoExisteException y UsuarioSinObjetosException.
        Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> { oneOct.consultarObjetoDeUsuario(nombreUser, "BadObjectName");});
        Assertions.assertThrows(UsuarioNoExisteException.class, () -> { oneOct.consultarObjetoDeUsuario("BadName", oneOct.consultarUsuario(nombreUser).getInventarioUser().getListaObjetos().get(0).getNombreObjeto());});
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario("marc", "casco" );});

        objeto = new Objeto("casco", "casco que minimiza los golpes de los enemigos", 1, 1);
        user = oneOct.consultarUsuario(nombreUser);

        oneOct.anadirObjetoAUsuario(user.getNombre(),objeto);             // Se añade el Arcode madera al usuario pol.
        boolean result = user.getInventarioUser().getListaObjetos().get(1).objetoEsIgual(objeto);
        assertTrue(result);

        Assertions.assertEquals(2, user.getInventarioUser().getListaObjetos().size());
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
        user = oneOct.consultarUsuario("marc");
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario(user.getNombre(), "casco");});

        // Consultar objeto con BadObjectName
        nombreUser = "pol";
        user2 = oneOct.consultarUsuario(nombreUser);
        Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> { oneOct.consultarObjetoDeUsuario(nombreUser, "BadObjectName");});


        objeto = new Objeto("microfono", "microfono para avisar de dónde vienen los enemigos", 2, 1);
        Objeto objetoReturned = oneOct.consultarObjetoDeUsuario(nombreUser, user2.getInventarioUser().getListaObjetos().get(0).getNombreObjeto());
        assertTrue(objeto.objetoEsIgual(objetoReturned));

    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     */
    @Test
    public void consultarListaObjetosDeUsuarioTest() throws  UsuarioNoExisteException, UsuarioSinObjetosException {

        nombreUser = "marc";
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario(nombreUser, nombreObjeto);});

        nombreUser = "pol";
        user = oneOct.consultarUsuario(nombreUser);

        List<Objeto> listaObjetosReturned = oneOct.consultarListaObjetosDeUsuario(nombreUser);
        assertTrue(user.listaEsIgual(listaObjetosReturned));
    }

    /**
     *
     * @throws UsuarioNoExisteException
     * @throws UsuarioSinObjetosException
     * @throws ObjetoNoEncontradoException
     */
    @Test
    public void eliminarObjetoDeUsuario() throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException {

        nombreUser = "pol";
        nombreObjeto = "microfono";
        Assertions.assertEquals(nombreObjeto, oneOct.consultarObjetoDeUsuario(nombreUser, nombreObjeto).getNombreObjeto());

        Assertions.assertTrue(oneOct.eliminarObjetoDeUsuario(nombreUser, nombreObjeto));
        Assertions.assertThrows(UsuarioSinObjetosException.class, () -> { oneOct.consultarObjetoDeUsuario(nombreUser, nombreObjeto);});
    }


}
