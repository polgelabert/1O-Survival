package modelo.mapa;

import modelo.Objeto;
import modelo.Punto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerarMapa {
    private TextArea ta1 = new TextArea(60, 101); //per prova del frame
    private TextArea ta2 = new TextArea(50, 50);
    private int posY =15, posX =15;

    //utilitzar aquesta funció per generar els mapes en format txt

    private int altura = 50, ample =100;
    private String [][] malla = new String[altura][ample];

    private int altEscola=20, amplEscola=30;
    private String [][] mapaEscola=new String[altEscola][amplEscola];

    private int altcti=20, amplcti=30;
    private String [][] mapaCti=new String[altcti][amplcti];

    private List<Edifici> listaEdificios;

    public GenerarMapa(){
        cargarEdificios();

        generarMapaEscola();
        generateFrame (mapaEscola, ta2, altEscola, amplEscola);

        String[][] malla1=generateMapa(altura, ample, listaEdificios);
        generateFrame(malla1, ta1,altura,ample);
    }
    public void cargarEdificios(){
        listaEdificios=new ArrayList<>();

        Edifici hosp =new Edifici("H","Hospistal",1,true);
        listaEdificios.add(hosp);
        Edifici nada =new Edifici("O","Nada",2,false);
        listaEdificios.add(nada);
        Edifici nada2 =new Edifici("O","Nada",3,false);
        listaEdificios.add(nada2);
        Edifici nada3 =new Edifici("O","Nada",4,false);
        listaEdificios.add(nada3);
        Edifici escuela =new Edifici("E","Escuela",5,true);
        listaEdificios.add(escuela);
        Edifici parque =new Edifici("K","Parque",6,false);
        listaEdificios.add(parque);
        Edifici cti =new Edifici("C","CTI",7,true);
        listaEdificios.add(cti);
        Edifici nada5 =new Edifici("O","Nada",7,false);
        listaEdificios.add(nada5);
        Edifici nada6 =new Edifici("O","Nada",8,false);
        listaEdificios.add(nada6);
    }
    public static Edifici quinEdifici(int n, int nn, List<Edifici> list) {
        Edifici s =new Edifici("O","Nada",0,false);
        switch (nn){
            case 1:
                switch (n){
                    case 1:
                        s= list.get(0);//"H";
                        break;
                    case 4:
                        s=list.get(1);//"O";
                        break;
                    case 7:
                        s=list.get(2);//"O";
                        break;
                }
                break;
            case 4:
                switch (n){
                    case 1:
                        s=list.get(3);//"O";
                        break;
                    case 4:
                        s= list.get(4);//"E";
                        break;
                    case 7:
                        s=list.get(5);//"P";
                        break;
                }
                break;
            case 7:
                switch (n){
                    case 1:
                        s=list.get(6);//"C";
                        break;
                    case 4:
                        s=list.get(7);//"O";
                        break;
                    case 7:
                        s=list.get(8);//"O";
                        break;
                }
                break;

        }
        return s;
    }
    public static String[][] generateMapa(int altura,int ample, List<Edifici> list) {
        boolean llocAlt = false, edifici = false, porta1=false, porta = false ;
        int n, nn=1,fin1, fin=3;
        String [][] malla = new String[altura][ample];

        for(int i = 0; i< altura; i++)
        {
            n=1; fin1=3;
            if (i == (nn*altura)/10) {
                llocAlt = true;
                nn +=3;
            } else if (i == (fin*altura)/10)
            {
                llocAlt = false;
                fin +=3;
            }
            if(i+1 == (fin*altura)/10){
                porta1=true;
            }else
                porta1=false;



            for(int j = 0; j< ample; j++ )
            {
                if (j == (n*ample)/10 && llocAlt) {
                    edifici = true;
                    n +=3;
                } else if (j == (fin1*ample)/10)
                {
                    edifici = false;
                    fin1 +=3;
                }
                if (j == ((((n-2)*ample)/10)-2) && porta1)
                    porta=true;
                else if(j == ((((n-2)*ample)/10)+2) && porta1)
                    porta=false;

                if(edifici) {
                    Edifici ed = quinEdifici(n - 3, nn - 3,list);
                    if(porta && ed.isPorta())
                        malla[i][j] = "P";
                    else
                        malla[i][j] = ed.getIdEdifici();
                }else
                    malla[i][j] = "-";
            }

        }
        return malla;
        //malla[posX][posY] ="@";
    }

    public void generarMapaCti(){
        int n,fin1,nn=2,fin2=8, nnn=3, fin3=4;
        boolean llocAlt=false, taula=false, urna=false, porta1=false, porta=false;

        for(int i = 0; i< altcti; i++)
        {
            //nn=3 fins fin2=9
            n=1; fin1=3;
            if( i == (altcti/2-2))
                porta1=true;
            else if (i==(altcti/2+2))
                porta1=false;

            if (i == (nn*altcti)/10) {
                llocAlt = true;
                //nn +=3;
            } else if (i == (fin2*altcti)/10)
            {
                llocAlt = false;
                //fin +=3;
            }
            if(i==(nnn*altcti)/10){
                urna=true;
                nnn+=3;
            }else if(i==(fin3*altcti)/10){
                urna = false;
                fin3+=3;
            }

            for(int j = 0; j< amplcti; j++ )
            {
                // n=2 fins fin=4; n=8, fin=10
                if (porta1) {// && (j==((amplEscola/2)-2)||j==(amplEscola/2)+2)){
                    if (j == 1)//||j==(amplEscola/2)+2))
                        porta = true;
                }

                if (j == (n*amplcti)/10 && llocAlt && !taula) {
                    taula = true;
                    n = 7;
                } else if (j == (fin1*amplcti)/10)
                {
                    taula = false;
                    fin1=9;
                }
                if(taula) {
                    if(urna)
                        mapaCti[i][j] = "U";
                    else
                        mapaCti[i][j] = "T";
                    if(porta)
                        mapaCti[i][j] = "P";
                }else if(porta)
                    mapaCti[i][j] = "P";
                else
                    mapaCti[i][j] = "-";
            }

        }
    }
    public void generarMapaEscola(){
        int n,fin1,nn=2,fin2=8, nnn=3, fin3=4;
        boolean llocAlt=false, taula=false, urna=false, porta1=false, porta=false;

        for(int i = 0; i< altEscola; i++)
        {
            //nn=3 fins fin2=9
            n=1; fin1=3;
            if(i==0 || i==altEscola-1)
                porta1=true;
            else
                porta1=false;

            if (i == (nn*altEscola)/10) {
                llocAlt = true;
                //nn +=3;
            } else if (i == (fin2*altEscola)/10)
            {
                llocAlt = false;
                //fin +=3;
            }
            if(i==(nnn*altEscola)/10){
                urna=true;
                nnn+=3;
            }else if(i==(fin3*altEscola)/10){
                urna = false;
                fin3+=3;
            }

            for(int j = 0; j< amplEscola; j++ )
            {
                // n=2 fins fin=4; n=8, fin=10
                if (porta1) {// && (j==((amplEscola/2)-2)||j==(amplEscola/2)+2)){
                    if (j == ((amplEscola / 2) - 2))//||j==(amplEscola/2)+2))
                        porta = true;
                    if (j == (amplEscola / 2) + 2)
                        porta = false;
                }

                if (j == (n*amplEscola)/10 && llocAlt && !taula) {
                    taula = true;
                    n = 7;
                } else if (j == (fin1*amplEscola)/10)
                {
                    taula = false;
                    fin1=9;
                }
                if(taula) {
                    if(urna)
                        mapaEscola[i][j] = "U";
                    else
                        mapaEscola[i][j] = "T";
                    if(porta)
                        mapaEscola[i][j] = "P";
                }else if(porta)
                    mapaEscola[i][j] = "P";
                else
                    mapaEscola[i][j] = "-";
            }

        }
    }

    // dibuixo el mapa en el frame
    public void dibuixarMapa(String [][] mapa, TextArea ta, int alt, int ampl) {
        ta.setText("");
        //mapa[posY][posX] ="@";
        for(int i = 0; i< alt; i++)
        {
            for(int j = 0; j< ampl; j++ )
            {
                ta.append(mapa[i][j]);
            }
            ta.append("\n");
        }
    }

    // faig una finestra per provar el mapa
    public Frame generateFrame (String [][] mapa, TextArea ta, int alt, int ampl) {
        JFrame f = new JFrame("Mapa");

        ta.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());

        dibuixarMapa(mapa,ta,alt,ampl);
        //f.add(ta1);
        JButton button = new JButton("Derecha");
        JButton button2 = new JButton("Izquierda");
        JButton button3 = new JButton("Abajo");
        JButton button4 = new JButton("Arriba");

        contentPane.setLayout(new FlowLayout());

        contentPane.add(ta, BorderLayout.PAGE_START);
        contentPane.add(button, BorderLayout.NORTH);
        contentPane.add(button2, BorderLayout.SOUTH);
        contentPane.add(button3, BorderLayout.EAST);
        contentPane.add(button4, BorderLayout.WEST);

        /*button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //malla[posY][posX] ="-";
                Punto p=quinDecim(posX, posY);
                if(p.getX()==0 || p.getY()==0)
                    malla[posY][posX] ="-";
                else
                    malla[posY][posX] =quinEdifici(p.getX(),p.getY());
                posX += 1;dibuixarMapa();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Punto p=quinDecim(posX, posY);
                if(p.getX()==0 || p.getY()==0)
                    malla[posY][posX] ="-";
                else
                    malla[posY][posX] =quinEdifici(p.getX(),p.getY());
                posX = posX - 1;dibuixarMapa();
                //malla[posY][posX] ="@";
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Punto p=quinDecim(posX, posY);
                if(p.getX()==0 || p.getY()==0)
                    malla[posY][posX] ="-";
                else
                    malla[posY][posX] =quinEdifici(p.getX(),p.getY());
                posY += 1;dibuixarMapa();
                //malla[posY][posX] ="@";
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Punto p=quinDecim(posX, posY);
                if(p.getX()==0 || p.getY()==0)
                    malla[posY][posX] ="-";
                else
                    malla[posY][posX] =quinEdifici(p.getX(),p.getY());
                posY = posY - 1;dibuixarMapa();
                //malla[posY][posX] ="@";
            }
        });*/
        //f.getContentPane().add(ta1);
        //f.getContentPane().add(button);
        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
        return f;
    }

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

    /*
    public static String[][] posarObjectesAlMapa(String[][] mapa, java.util.List<Objeto> objectesDinsMapa){
        for (Objeto o: objectesDinsMapa) {
            for (int amp=0;amp<o.getTamanoObjCeldaMap().getX();amp++) {
                mapa[o.getPosicionObjeto().getY()][o.getPosicionObjeto().getX() + amp] = o.getIdObjMapa();
                for (int alt = 0; alt < o.getTamanoObjCeldaMap().getY(); alt++) {
                    mapa[o.getPosicionObjeto().getY() + alt][o.getPosicionObjeto().getX()+amp] = o.getIdObjMapa();
                }
            }
        }
        return mapa;
    }

    public Punto quinDecimMapaGen(int posX, int posY){
        int m,mm;

        if(posX<(3*ample/10) && posX>=(ample/10))
            m=1;
        else if (posX<(6*ample/10) && posX>=(4*ample/10))
            m=4;
        else if(posX<(9*ample/10) && posX>=(7*ample/10))
            m=7;
        else
            m=0;

        if(posY<(3*altura/10) && posY>=(altura/10))
            mm=1;
        else if (posY<(6*altura/10) && posY>=(4*altura/10))
            mm=4;
        else if(posY<(9*altura/10) && posY>=(7*altura/10))
            mm=7;
        else
            mm=0;
        return new Punto(m,mm);
    }

*/
    public static void main(String[] args) {
        //generarMapaEscola();
        int altura = 50, ample =100;
        GenerarMapa g = new GenerarMapa();
        //String [][] malla=generateMapa(altura,ample,listaEdificios);
        //pasarMapaTxt(malla);
    }
}
