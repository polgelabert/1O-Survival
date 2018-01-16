
package vista;




import controlador.OneOctoberManagerImpl;
import controlador.excepciones.AccesoDenegado;
import controlador.excepciones.UsuarioYaExisteException;
import modelo.Objeto;
import modelo.clasesTablas.Usuario2;

public class Main {


    public static void main(String[] args) throws AccesoDenegado, UsuarioYaExisteException {
        Usuario2 us = new Usuario2("Pol", "1234","polete@gmail.com");
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
