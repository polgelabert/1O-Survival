package controlador;

import modelo.*;
import controlador.excepciones.*;

import java.util.List;

public interface OneOctoberManager {



    boolean crearUsuario(Player user) throws UsuarioYaExisteException;

    Player consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    List<Player> consultarListaUsuarios() throws ListaUsuariosVaciaException;

    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;

    List<Objeto> consultarInventarioDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    PlayerTO playerTO (Player user);


    public void reset();



}
