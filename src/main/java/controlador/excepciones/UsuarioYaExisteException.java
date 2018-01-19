package controlador.excepciones;

public class UsuarioYaExisteException extends Exception{


    //public UsuarioYaExisteException() { super ("El usuario ya existe, prueba con otro nombre."); }

    public UsuarioYaExisteException() {
        super (String.valueOf(-1));
    }
}
