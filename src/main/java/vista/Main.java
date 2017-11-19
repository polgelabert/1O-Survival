
package Vista;

import Modelo.Mapa;
import Modelo.Player;


import java.awt.*;

public class Main {


    public static void main(String[] args) {


        Player p = new Player();
        p.setVida(50);
        Integer res = p.getVida() - 40;
        System.out.println(res);

        Mapa m = new Mapa();


    }
}
