package modelo.mapa;

import controlador.OneOctoberManagerImpl;
import org.apache.log4j.Logger;

import java.io.*;

public abstract class LibreriaTxt {

    final static Logger log = Logger.getLogger(OneOctoberManagerImpl.class.getName());

    public static void pasarMapaTxt(String[][] mapa, String nomTxt){
        String savePath=" ";
        try {
            savePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "mapesTxt";
            //File saveLocation = new File(savePath);
            File myFile = new File(savePath, nomTxt +".txt");
            FileWriter writer = new FileWriter(myFile, false);
            for (String[] p: mapa) {
                for (String pp:p) {
                    writer.write(pp);
                }
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            log.error(e);
            log.info("No se ha podido crear el fichero del mapa: "+nomTxt);
        }
        log.info("Se ha creado el mapa: "+nomTxt+". Se ha guardado en: "+savePath);
    }

    public static String[][] llegirMapaTxt(String nomTxt){
        String line="";
        int cont=1;
        String savePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "mapesTxt";
        File myFile = new File(savePath, nomTxt+".txt");
        try {
            // per saber la mida del mapa (amplada i altura)
            FileReader reader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            line = bufferedReader.readLine();
            while (bufferedReader.readLine() != null){
                cont++;
            }
            String[][] malla = new String [cont][line.length()];
            reader.close();
        } catch (Exception e){
            log.error(e);
            log.info("No se ha podido cargar el mapa: "+nomTxt+".txt");
            return null;
        }
        String[][] malla = new String [cont][line.length()];
        try{
            // Per omplir la malla
            FileReader reader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            cont=0;
            while ((line = bufferedReader.readLine()) != null){
                for (int i=0; i<line.length(); i++) {
                    malla[cont][i] = String.valueOf(line.charAt(i));
                }
                cont++;
            }
            reader.close();

        } catch (Exception e){
            log.fatal("No entenc què està passant.");
            return null;
        }
        //String[][] malla = String [][];
        return malla;

    }

}
