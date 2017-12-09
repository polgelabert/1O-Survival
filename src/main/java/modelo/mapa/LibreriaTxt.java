package modelo.mapa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class LibreriaTxt {

    public static void pasarMapaTxt(String[][] mapa, String nom){
        try {
            //new File(".").getAbsolutePath()+"//folder//out.txt"

            String savePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "mapesTxt";
            File saveLocation = new File(savePath);
            File myFile = new File(savePath, nom+".txt");

            FileWriter writer = new FileWriter(myFile, true);
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
