package controlador;

import modelo.*;
import controlador.excepciones.*;
import modelo.clasesTablas.Niveltable;
import modelo.clasesTablas.Usuario;
import modelo.mapa.Mapa;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface OneOctoberManager {



    boolean crearUsuario(Usuario user) throws UsuarioYaExisteException, InvocationTargetException, IllegalAccessException, AccesoDenegado;

    Usuario consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException;

    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;
    boolean modificarUsuario (Usuario nombreUser) throws UsuarioNoExisteException;
    Niveltable seleccionarNivel (String idMapa);


   // List<Objeto> consultarInventarioDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    //PlayerTO playerTO (Usuario user);

    // consultarMapa(int idMalla) throws MapaNoEncontradoException;

     public void reset();



}
