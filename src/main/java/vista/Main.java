
package vista;




import controlador.OneOctoberManagerImpl;
import controlador.excepciones.AccesoDenegado;
import controlador.excepciones.UsuarioYaExisteException;
import modelo.MinijuegoPoli;
import modelo.MinijuegoSeguidor;
import modelo.Objeto;
import modelo.clasesTablas.Usuario;

import java.lang.reflect.InvocationTargetException;

public class Main {


    public static void main(String[] args) throws AccesoDenegado, UsuarioYaExisteException {
        Usuario us = new Usuario("Pol", "1234","polete@gmail.com");
        OneOctoberManagerImpl impl=OneOctoberManagerImpl.getInstance();
        impl.crearUsuario(us);
        Objeto newObject = new Objeto("Banco","Objeto para añadir a la barricada y evitar el paso de los policias",15,4);
        //boolean addedObj = us.getMiNivel().getInventarioUser().añadirObjeto(newObject);
        //boolean tt = us.getMiNivel().getInventarioUser().sacarObjeto(newObject);

        //Mapa n=new Mapa();

        //MinijuegoPoli a=new MinijuegoPoli();
        //MinijuegoSeguidor a=new MinijuegoSeguidor("CiNa");
    }
}
