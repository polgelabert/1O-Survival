package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MinijuegoPoli{

    private int altura = 50, ample =100;
    private TextArea ta1 = new TextArea(60, 101);
    private String [][] malla = new String[altura][ample];
    private int idMalla;
    private int posX=95, posY=altura/2,numpolis=4,separacion=3,spawn=0;
    private int[][] pospolis;
    private double tope=ample*0.9;


    public void generateMapa()
    {
        pospolis=new int[numpolis][2];
        for(int i=0;i<altura;i++){

            for(int j=0;j<ample;j++){
                malla[i][j]="-";
            }
        }
                                malla[posY-1][posX]="@";
        malla[posY][posX-1]="/";malla[posY][posX]="|";
                             malla[posY+1][posX-1]="/";

    }

    public void spawn(){
        Random generator=new Random();
        int pos0=generator.nextInt(altura);
        if(pos0==0) pos0=1;
        if(pos0==altura-1) pos0=altura-2;
        pospolis[spawn][0]=pos0;
        pospolis[spawn][1]=0;
        spawn++;

    }
    public void tick(){
        for(int i=0;i<spawn;i++){
            int poliY=pospolis[i][0];
            int poliX=pospolis[i][1];
            malla[poliY-1][poliX]="@";
            malla[poliY][poliX]="|";malla[poliY][poliX+1]=">";
            malla[poliY+1][poliX+1]="\\";
            pospolis[i][1]++;
        }
        frame();
    }
    public void mostrar(){

    }

    public void dibuixarMapa()
    {

        ta1.setText("");
        malla[posY-1][posX]="@";
        malla[posY][posX-1]="/";malla[posY][posX]="|";
        malla[posY+1][posX-1]="/";
        for(int i = 0; i< altura; i++)
        {
            for(int j = 0; j< ample; j++ )
            {
                ta1.append(malla[i][j]);
            }
            ta1.append("\n");
        }
    }

    public Frame frame(){

        JFrame f = new JFrame("Mapa");

        ta1.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());

        //Dibujar mapa
        dibuixarMapa();
        //f.add(ta1);
        JButton button1 = new JButton("Abajo");
        JButton button2 = new JButton("Arriba");

        contentPane.setLayout(new FlowLayout());

        contentPane.add(ta1, BorderLayout.PAGE_START);
        contentPane.add(button1, BorderLayout.EAST);
        contentPane.add(button2, BorderLayout.WEST);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(posY+2<altura) {
                    malla[posY-1][posX]="-";
                    malla[posY][posX-1]="-";malla[posY][posX]="-";
                    malla[posY+1][posX-1]="-";
                    posY ++;
                    dibuixarMapa();
                    //malla[posX][posY] ="@";
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(posY-2>=0){
                    malla[posY-1][posX]="-";
                    malla[posY][posX-1]="-";malla[posY][posX]="-";
                    malla[posY+1][posX-1]="-";
                    posY --;
                    dibuixarMapa();
                    //malla[posX][posY] ="@";}
                }
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
