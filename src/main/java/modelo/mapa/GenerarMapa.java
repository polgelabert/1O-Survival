package modelo.mapa;

import modelo.Objeto;
import modelo.Punto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerarMapa extends LibreriaTxt{
    private TextArea ta1 = new TextArea(60, 101); //per prova del frame
    private TextArea ta2 = new TextArea(50, 50);
    private TextArea ta3 = new TextArea(50, 50);
    private int posY =15, posX =15;

    private int altura = 50, ample =100;
    private String [][] malla = new String[altura][ample];

    private int altEscola=20, amplEscola=30;
    private String [][] mapaEscola=new String[altEscola][amplEscola];

    private int altcti=20, amplcti=30;
    private String [][] mapaCti=new String[altcti][amplcti];

    private List<Edifici> listaEdificios;


    public GenerarMapa(){
/*        cargarEdificios();

        String[][] malla3=generarMapaEscola(altEscola,amplEscola);
        generateFrame (malla3, ta2, altEscola, amplEscola);

        String[][] malla1=generateMapa(altura, ample, listaEdificios);
        generateFrame(malla1, ta1,altura,ample);

        String[][] malla2=generarMapaCti(altcti,amplcti);
        generateFrame(malla2,ta3,altcti,amplcti);*/

    }
    public static List<Edifici> cargarEdificios(){
        List<Edifici> listaEdificios=new ArrayList<>();

        Edifici hosp =new Edifici("H","Hospistal",1,true);
        listaEdificios.add(hosp);
        Edifici nada =new Edifici("N","Nada",2,false);
        listaEdificios.add(nada);
        Edifici nada2 =new Edifici("N","Nada",3,false);
        listaEdificios.add(nada2);
        Edifici nada3 =new Edifici("N","Nada",4,false);
        listaEdificios.add(nada3);
        Edifici escuela =new Edifici("E","Escuela",5,true);
        listaEdificios.add(escuela);
        Edifici parque =new Edifici("K","Parque",6,false);
        listaEdificios.add(parque);
        Edifici cti =new Edifici("C","CTI",7,true);
        listaEdificios.add(cti);
        Edifici nada5 =new Edifici("N","Nada",7,false);
        listaEdificios.add(nada5);
        Edifici nada6 =new Edifici("N","Nada",8,false);
        listaEdificios.add(nada6);
        return listaEdificios;
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
    public static String[][] generarMapaCti(int altcti, int amplcti){
        int n,fin1,nn=1,fin2=9, nnn=4, fin3=6;
        boolean llocAlt=false, taula=false, urna=false, porta1=false, porta=false;

        String [][] mapaCti = new String[altcti][amplcti];

        for(int i = 0; i< altcti; i++)
        {
            //nn=3 fins fin2=9
            n=6; fin1=8;
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
            if(i==(nnn*altcti)/20){
                urna=true;
                nnn+=5;
            }else if(i==(fin3*altcti)/20){
                urna = false;
                fin3+=5;
            }

            for(int j = 0; j< amplcti; j++ )
            {
                // n=2 fins fin=4; n=8, fin=10
                if (porta1) {// && (j==((amplEscola/2)-2)||j==(amplEscola/2)+2)){
                    if (j == 0)//||j==(amplEscola/2)+2))
                        porta = true;
                    else
                        porta = false;
                }

                if (j == (n*amplcti)/10 && llocAlt && !taula) {
                    taula = true;
                    //n = 7;
                } else if (j == (fin1*amplcti)/10)
                {
                    taula = false;
                    //fin1=9;
                }
                if(taula) {
                    if(urna)
                        mapaCti[i][j] = "O";
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
        return mapaCti;
    }
    public static String[][] generarMapaEscola(int altEscola,int amplEscola){
        int n,fin1,nn=2,fin2=8, nnn=3, fin3=4;
        boolean llocAlt=false, taula=false, urna=false, porta1=false, porta=false;
        String[][] mapaEscola = new String[altEscola][amplEscola];

        for(int i = 0; i< altEscola; i++)
        {
            //nn=3 fins fin2=9
            n=1; fin1=3;
            if(i==altEscola-1)//i==0 || i==altEscola-1)
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
        return mapaEscola;
    }

    // dibuixo el mapa en el frame
    public static void dibuixarMapa(String [][] mapa, TextArea ta, int alt, int ampl) {
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
    public static Frame generateFrame (String [][] mapa, TextArea ta, int alt, int ampl) {
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

    // fucnions que criden a les funcions de la llibreriaTxt
    public static void pasarMapaTxt2(String[][] mapa, String nom){
        pasarMapaTxt(mapa,nom);
    }
    public static void llegirMapaTxt2(String nomFitxesSenseTxt){
        llegirMapaTxt(nomFitxesSenseTxt);
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
    public static void main(String[] args)  {
        int altura = 50, ample =100;
        int altEscola=20, amplEscola=30;
        int altcti=20, amplcti=30;
        List<Edifici> listaEdificios = cargarEdificios();
        //String[][] malla2=generarMapaCti(altcti,amplcti);
        //pasarMapaTxt(malla2,"mapaCTI");
        //llegirMapaTxt2("hola");


        TextArea ta1 = new TextArea(60, 101); //per prova del frame
        TextArea ta2 = new TextArea(50, 50);
        TextArea ta3 = new TextArea(50, 50);

        String[][] malla3=generarMapaEscola(altEscola,amplEscola);
        //generateFrame (malla3, ta2, altEscola, amplEscola);
        pasarMapaTxt(malla3,"mapaEscola");

        String[][] malla1=generateMapa(altura, ample, listaEdificios);
        //generateFrame(malla1, ta1,altura,ample);
        pasarMapaTxt(malla1,"mapaGeneral");

        String[][] malla2=generarMapaCti(altcti,amplcti);
        //generateFrame(malla2,ta3,altcti,amplcti);
        pasarMapaTxt(malla2,"mapaCTI");

        //String [][] malla = generateMapa(altura,ample,listaEdificios);
        //pasarMapaTxt(malla);*/
    }
}
