package controlador;

import controlador.excepciones.*;
import modelo.clasesTablas.Niveltable;
import modelo.clasesTablas.Usuario2;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface OneOctoberManager {



    Usuario2 crearUsuario(Usuario2 user) throws UsuarioYaExisteException, InvocationTargetException, IllegalAccessException, AccesoDenegado;

    Usuario2 consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    List<Object[]> consultarListaUsuarios(Usuario2 user) throws ListaUsuariosVaciaException;

    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;
    Usuario2 modificarUsuario (Usuario2 nombreUser) throws UsuarioNoExisteException;
    Niveltable seleccionarNivel (String idMapa);


   // List<Objeto> consultarInventarioDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    //PlayerTO playerTO (Usuario2 user);

    // consultarMapa(int idMalla) throws MapaNoEncontradoException;

     public void reset();



}
