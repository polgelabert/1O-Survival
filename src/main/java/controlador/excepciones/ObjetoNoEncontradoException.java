package controlador.excepciones;

public class ObjetoNoEncontradoException extends Exception {

    //public ObjetoNoEncontradoException(){ super("Nombre de objeto mal introuducido. modelo.Objeto no encontrado."); }

    public ObjetoNoEncontradoException(){ super(String.valueOf(-2)); }

}