
package vista;

import modelo.Player;

public class Main {


    public static void main(String[] args) {


        Player p = new Player();
        p.setVida(50);
        Integer res = p.getVida() - 40;
        System.out.println(res);


    }
}
