package controlador.excepciones;

public class ListaUsuariosVaciaException extends Exception {

    //public ListaUsuariosVaciaException() { super ("Error al cargar la lista de usuarios del map. Lista de Usuarios vacía."); }

    public ListaUsuariosVaciaException() { super (String.valueOf(-1)); }
}
