
package vista;




import modelo.MinijuegoPoli;
import modelo.mapa.Mapa;
import modelo.Objeto;
import modelo.Player;

public class Main {


    public static void main(String[] args) {
        Player us = new Player("Joan", 100,0,0);
        Objeto newObject = new Objeto("Banco","Objeto para añadir a la barricada y evitar el paso de los policias",15,4);
        boolean addedObj = us.getInventarioUser().añadirObjeto(newObject);
        boolean tt = us.getInventarioUser().sacarObjeto(newObject);

        //Mapa n=new Mapa();

        MinijuegoPoli a=new MinijuegoPoli();
    }
}
