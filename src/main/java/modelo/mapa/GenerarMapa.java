package modelo.mapa;

import modelo.Punto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerarMapa {
    private TextArea ta1 = new TextArea(60, 101); //per prova del frame
    private TextArea ta2 = new TextArea(50, 50);
    private int posY =15, posX =15;

    //utilitzar aquesta funció per generar els mapes en format txt

    private int altura = 50, ample =100;
    private String [][] malla = new String[altura][ample];

    private int altEscola=20, amplEscola=30;
    private String [][] mapaEscola=new String[altEscola][amplEscola];


    public GenerarMapa(){
        generarMapaEscola();
        generateFrame (mapaEscola, ta2, altEscola, amplEscola);
    }
    public String quinEdifici(int n, int nn)
    {
        String s= " ";
        switch (nn){
            case 1:
                switch (n){
                    case 1:
                        s="H";
                        break;
                    case 4:
                        s="O";
                        break;
                    case 7:
                        s="O";
                        break;
                }
                break;
            case 4:
                switch (n){
                    case 1:
                        s="O";
                        break;
                    case 4:
                        s= "E";
                        break;
                    case 7:
                        s="P";
                        break;
                }
                break;
            case 7:
                switch (n){
                    case 1:
                        s="C";
                        break;
                    case 4:
                        s="O";
                        break;
                    case 7:
                        s="O";
                        break;
                }
                break;

        }
        return s;
    }
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
        //malla[posX][posY] ="@";
    }

    public void generarMapaEscola(){
        int n,fin1,nn=2,fin2=8;
        boolean llocAlt=false, taula=false;

        for(int i = 0; i< altEscola; i++)
        {
            //nn=3 fins fin2=9
            n=1; fin1=3;
            if (i == (nn*altEscola)/10) {
                llocAlt = true;
                //nn +=3;
            } else if (i == (fin2*altEscola)/10)
            {
                llocAlt = false;
                //fin +=3;
            }
            for(int j = 0; j< amplEscola; j++ )
            {
                // n=2 fins fin=4; n=8, fin=10
                if (j == (n*amplEscola)/10 && llocAlt && !taula) {
                    taula = true;
                    n = 7;
                } else if (j == (fin1*amplEscola)/10)
                {
                    taula = false;
                    fin1=9;
                }
                if(taula) {
                    mapaEscola[i][j] = "T";//quinEdifici(n-3,nn-3);//"H";
                }else
                    mapaEscola[i][j] = "-";
            }

        }
    }

    // dibuixo el mapa en el frame
    public void dibuixarMapa(String [][] mapa, TextArea ta, int alt, int ampl)
    {
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
    public Frame generateFrame (String [][] mapa, TextArea ta, int alt, int ampl)
    {
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
    public static void main(String[] args) {
        //generarMapaEscola();
        GenerarMapa g=new GenerarMapa();

    }
}
