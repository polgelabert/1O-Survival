package modelo.mapa;


import modelo.Objeto;
import modelo.Punto;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Mapa {
    // Coses que s'han de canviar
    private TextArea ta1 = new TextArea(60, 101); //per prova del frame
    private int posY =15, posX =15; // posicio del jugador (aixo sera un get inicial)


    private int altura = 50, ample =100;
    private String [][] malla = new String[altura][ample];
    private String [][] mallaAnt = new String[altura][ample];
    private int idMalla;

    private String[] edificios = new String[9];
    /* 1 2 3
       4 5 6
       7 8 9  */
    private java.util.List<Objeto> objectesDinsMapa = new ArrayList<>();


    public Mapa(){
        edificios[0]="H";
        edificios[1]="O";
        edificios[2]="O";
        edificios[3]="O";
        edificios[4]="E";
        edificios[5]="P";
        edificios[6]="C";
        edificios[7]="O";
        edificios[8]="O";

        afegirObjectes();
        generateMapa();
        posarObjectesAlMapa();
        generateFrame();
    }


    public String[][] getMalla() {
        return malla;
    }
    public void setMalla(String[][] malla) {
        this.malla = malla;
    }
    public int getIdMalla() {
        return idMalla;
    }
    public void setIdMalla(Integer idMalla) {
        this.idMalla = idMalla;
    }


    public void afegirObjectes(){
        Objeto banco = new Objeto("banco", "pa' sentarse", 20, 2);
        Objeto container = new Objeto("Container", "pa' tirar basura", 40, 4);

        banco.setIdObjMapa("b"); container.setIdObjMapa("c"); // li dic quin caracter correspon a l'objecte al mapa

        banco.setTamanoObjCeldaMap(new Punto(2,1)); //dimensio del objecte al mapa
        banco.setPosicionObjeto(new Punto(31,10)); //posició de la cela superior dreta al mapa
        container.setTamanoObjCeldaMap(new Punto(2,2));
        container.setPosicionObjeto(new Punto(31,40));

        objectesDinsMapa.add(banco); objectesDinsMapa.add(container);

        Objeto banco2 = new Objeto("banco", "pa' sentarse", 20, 2);
        Objeto container2 = new Objeto("Container", "pa' tirar basura", 40, 4);
        banco2.setIdObjMapa("b"); container2.setIdObjMapa("c"); // li dic quin caracter correspon a l'objecte al mapa
        banco2.setPosicionObjeto(new Punto(61,20));
        container2.setPosicionObjeto(new Punto(61,40));
        banco2.setTamanoObjCeldaMap(new Punto(2,1)); //dimensio del objecte al mapa
        container2.setTamanoObjCeldaMap(new Punto(2,2));
        objectesDinsMapa.add(banco2); objectesDinsMapa.add(container2);
    }

    public void posarObjectesAlMapa(){
        for (Objeto o: objectesDinsMapa) {
            for (int amp=0;amp<o.getTamanoObjCeldaMap().getX();amp++) {
                malla[o.getPosicionObjeto().getY()][o.getPosicionObjeto().getX() + amp] = o.getIdObjMapa();
                for (int alt = 0; alt < o.getTamanoObjCeldaMap().getY(); alt++) {
                    malla[o.getPosicionObjeto().getY() + alt][o.getPosicionObjeto().getX()+amp] = o.getIdObjMapa();
                }
            }
        }

    }
    // a partir del n y nn et diu a quin edifici estas
    public String quinEdifici(int n, int nn)
    {
        String s= " ";
        switch (nn){
            case 1:
                switch (n){
                    case 1:
                        s=edificios[0];//"H";
                    break;
                    case 4:
                        s=edificios[1];//"O";
                    break;
                    case 7:
                        s=edificios[2];//"O";
                    break;
                }
                break;
            case 4:
                switch (n){
                    case 1:
                        s=edificios[3];//"O";
                    break;
                    case 4:
                        s= edificios[4];//"E";
                    break;
                    case 7:
                        s=edificios[5];//"P";
                    break;
                }
                break;
            case 7:
                switch (n){
                    case 1:
                        s=edificios[6];//"C";
                    break;
                    case 4:
                        s=edificios[7];//"O";
                    break;
                    case 7:
                        s=edificios[8];//"O";
                    break;
                }
                break;

        }
        return s;
    }

    // genero el mapa 3x3
    public void generateMapa()
    {
        boolean llocAlt = false, edifici = false;
        int n, nn=1,fin1, fin=3;

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
                if(edifici) {
                    malla[i][j] = quinEdifici(n-3,nn-3);//"H";
                }else
                    malla[i][j] = "-";
            }

        }
        malla[posY][posX] ="@";
    }

    // A partir de la posicio et retorna el n y nn per saber en quin edifici estas
    public Punto quinDecim(int posX, int posY){
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


    // dibuixo el mapa en el frame
    public void dibuixarMapa()
    {
        ta1.setText("");
        malla[posY][posX] ="@";
        for(int i = 0; i< altura; i++)
        {
            for(int j = 0; j< ample; j++ )
            {
                ta1.append(malla[i][j]);
            }
            ta1.append("\n");
        }
    }

    // faig una finestra per provar el mapa
    public Frame generateFrame ()
    {
        JFrame f = new JFrame("Mapa");

        ta1.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());

        dibuixarMapa();
        //f.add(ta1);
        JButton button = new JButton("Derecha");
        JButton button2 = new JButton("Izquierda");
        JButton button3 = new JButton("Abajo");
        JButton button4 = new JButton("Arriba");

        contentPane.setLayout(new FlowLayout());

        contentPane.add(ta1, BorderLayout.PAGE_START);
        contentPane.add(button, BorderLayout.NORTH);
        contentPane.add(button2, BorderLayout.SOUTH);
        contentPane.add(button3, BorderLayout.EAST);
        contentPane.add(button4, BorderLayout.WEST);

        button.addActionListener(new ActionListener() {
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
        });
        //f.getContentPane().add(ta1);
        //f.getContentPane().add(button);
        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
        return f;
    }
}