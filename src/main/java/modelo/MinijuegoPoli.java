package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MinijuegoPoli{

    private int altura = 15, ample =30;
    private TextArea ta1 = new TextArea(20, 50);
    private String [][] malla = new String[altura][ample];
    private int idMalla;
    private int posX=27, posY=altura/2,numpolis=4,separacion=3,spawn=0;
    private int[][] pospolis;
    private double tope=ample*0.9;
    private Timer time;

    public MinijuegoPoli(){
        generateMapa();
        frame();
        time=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        time.start();
    }



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
        separacion--;
        if(separacion==0&&spawn<numpolis){
            spawn();
            separacion=3;
        }
        /*
        if(separacion==3){
            int poliY=pospolis[spawn-1][0];
            int poliX=pospolis[spawn-1][1];
            malla[poliY-1][poliX]="@";
            malla[poliY][poliX]="|";malla[poliY][poliX+1]=">";
            malla[poliY+1][poliX+1]="\\";
            pospolis[spawn-1][1]++;
        }
        */
        correr();
        /*
        for(int i=0;i<spawn;i++){
            int poliY=pospolis[i][0];
            int poliX=pospolis[i][1];
            malla[poliY-1][poliX]="@";
            malla[poliY][poliX]="|";malla[poliY][poliX+1]=">";
            malla[poliY+1][poliX+1]="\\";
            pospolis[i][1]++;
        }
        */
        dibuixarMapa();

    }
    public void correr(){
        moverPj();
        /*
        for(int i=ample-1;i>0;i--){
            for (int j=0;j<altura;j++){
                malla[j][i]=malla[j][i-1];
                if(i==1){
                malla[j][i-1]="-";
                }
                else{break;}
            }
        }
        for(int i=0;i<spawn;i++){
            pospolis[spawn][1]++;
        }
        */
    }

    public void moverPj(){

        for(int i=0;i<spawn;i++){
            int poliY=pospolis[i][0];
            int poliX=pospolis[i][1];
            malla[poliY-1][poliX]="-";
            malla[poliY][poliX]="-";malla[poliY][poliX+1]="-";
            malla[poliY+1][poliX+1]="-";
            poliX++;
            pospolis[i][1]=poliX;
            malla[poliY-1][poliX]="@";
            malla[poliY][poliX]="|";malla[poliY][poliX+1]=">";
            malla[poliY+1][poliX+1]="\\";
        }

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
        JButton stop=new JButton("Stop");
        JButton button1 = new JButton("Abajo");
        JButton button2 = new JButton("Arriba");

        contentPane.setLayout(new FlowLayout());

        contentPane.add(ta1, BorderLayout.PAGE_START);
        contentPane.add(stop,BorderLayout.NORTH);
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
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time.stop();
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
