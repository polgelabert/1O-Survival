package controlador.excepciones;

import modelo.clasesTablas.Usuario2;

public class UsuarioNoActualizado extends Exception {

    public UsuarioNoActualizado(){ super (String.valueOf(-4));}
}
