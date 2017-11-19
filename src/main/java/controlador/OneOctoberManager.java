package controlador;

import modelo.*;
import controlador.excepciones.*;

import java.util.List;

public interface OneOctoberManager {



    boolean crearUsuario(Player user) throws UsuarioYaExisteException;

    Player consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    List<Player> consultarListaUsuarios() throws ListaUsuariosVaciaException;

    void modificarUsuario (String nombreUser, Player user2) throws UsuarioNoExisteException;

    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;



    void anadirObjetoAUsuario(String nombre, Objeto objeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException;

    Objeto consultarObjetoDeUsuario(String nombre, String nombreObjeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException;

    List<Objeto> consultarListaObjetosDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    boolean eliminarObjetoDeUsuario(String nombreUser, String nombreObjeto) throws UsuarioNoExisteException, UsuarioSinObjetosException, ObjetoNoEncontradoException;




    public void reset();




}
