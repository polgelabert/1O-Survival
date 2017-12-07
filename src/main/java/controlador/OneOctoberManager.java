package controlador;

import modelo.*;
import controlador.excepciones.*;
import modelo.mapa.Mapa;

import java.util.List;

public interface OneOctoberManager {



    boolean crearUsuario(Usuario user) throws UsuarioYaExisteException;

    Usuario consultarUsuario(String nombreUser) throws UsuarioNoExisteException;

    List<Usuario> consultarListaUsuarios() throws ListaUsuariosVaciaException;

    boolean eliminarUsuario (String nombreUser) throws UsuarioNoExisteException;

    List<Objeto> consultarInventarioDeUsuario(String nombre) throws UsuarioNoExisteException, UsuarioSinObjetosException;

    PlayerTO playerTO (Usuario user);

    Mapa consultarMapa(int idMalla) throws MapaNoEncontradoException;

    public void reset();



}
