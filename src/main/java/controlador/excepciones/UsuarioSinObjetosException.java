package controlador.excepciones;

public class UsuarioSinObjetosException extends Exception {


    //public UsuarioSinObjetosException() { super ("El usuario no tiene ningún objeto."); }

    public UsuarioSinObjetosException() { super (String.valueOf(-2)); }
}
