package Modelo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Mapa {

    private int altura = 50, ample =100;
    private TextArea ta1 = new TextArea(60, 101);
    private String [][] malla = new String[altura][ample];
    private int idMalla;
    private int posX=15, posY=15;

    //private Character [][] malla;

    public Mapa(){
        generateMapa();
        generateFrame();
    }


    /*public String[][] getMalla() {
        return malla;
    }

    public void setMalla(String[][] malla) {
        this.malla = malla;
    }
*/
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }
    public int getIdMalla() {
        return idMalla;
    }

    public void setIdMalla(Integer idMalla) {
        this.idMalla = idMalla;
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
        int n=1, nn=1, fin1=3, fin=3;

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
        malla[posX][posY] ="@";
    }
    public void dibuixarMapa()
    {
        ta1.setText("");
        malla[posX][posY] ="@";
        for(int i = 0; i< altura; i++)
        {
            for(int j = 0; j< ample; j++ )
            {
                ta1.append(malla[i][j]);
            }
            ta1.append("\n");
        }
    }

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
                malla[posX][posY] ="-";
                posY += 1;dibuixarMapa();
                //malla[posX][posY] ="@";
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                malla[posX][posY] ="-";
                posY = posY - 1;dibuixarMapa();
                //malla[posX][posY] ="@";
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                malla[posX][posY] ="-";
                posX += 1;dibuixarMapa();
                //malla[posX][posY] ="@";
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                malla[posX][posY] ="-";
                posX = posX - 1;dibuixarMapa();
                //malla[posX][posY] ="@";
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