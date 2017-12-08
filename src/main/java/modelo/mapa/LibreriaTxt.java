package modelo.mapa;

import java.io.FileWriter;
import java.io.IOException;

public abstract class LibreriaTxt {

    public static void pasarMapaTxt(String[][] mapa, String nom){
        try {
            FileWriter writer = new FileWriter(nom+".txt", true);
            for (String[] p: mapa) {
                for (String pp:p) {
                    writer.write(pp);
                }
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
