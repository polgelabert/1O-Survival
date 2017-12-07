
package vista;




import modelo.MinijuegoPoli;
import modelo.Objeto;
import modelo.Usuario;

public class Main {


    public static void main(String[] args) {
        Usuario us = new Usuario("Joan", "1234","joanet@gmail.com");
        Objeto newObject = new Objeto("Banco","Objeto para añadir a la barricada y evitar el paso de los policias",15,4);
        boolean addedObj = us.getMiNivel().getInventarioUser().añadirObjeto(newObject);
        boolean tt = us.getMiNivel().getInventarioUser().sacarObjeto(newObject);

        //Mapa n=new Mapa();

        MinijuegoPoli a=new MinijuegoPoli();
    }
}
