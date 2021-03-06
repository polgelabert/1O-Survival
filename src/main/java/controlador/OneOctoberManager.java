package controlador;

import controlador.excepciones.*;
import modelo.clasesTablas.Niveltable;
import modelo.clasesTablas.Ranking2;
import modelo.clasesTablas.Usuario2;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface OneOctoberManager {



    Usuario2 crearUsuario(Usuario2 user) throws UsuarioYaExisteException, InvocationTargetException, IllegalAccessException, AccesoDenegado;

    Usuario2 consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    Usuario2 esUsuario(Usuario2 user) throws UsuarioNoExisteException;

    List<Usuario2> consultarListaUsuarios(String userName) throws ListaUsuariosVaciaException;


    List<Ranking2> consultarListaRanking(String userName) throws ListaUsuariosVaciaException;


    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;

    Usuario2 modificarUsuario (Usuario2 nombreUser);

    Ranking2 modificarRanking(Ranking2 rank);

    Niveltable seleccionarNivel (String idMapa);


   // List<Objeto> consultarInventarioDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    //PlayerTO playerTO (Usuario2 user);

    // consultarMapa(int idMalla) throws MapaNoEncontradoException;

     public void reset();



}
