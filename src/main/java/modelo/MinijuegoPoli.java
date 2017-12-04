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
    private int posX=27, posY=altura/2,numpolis=4,separacion=3,spawn=0,parados=0,fallados=0;
    private int[][] pospolis;
    private double tope=ample*0.9;
    private Timer time;
    private boolean abajo=false,arriba=false;

    public MinijuegoPoli(){
        pospolis=new int[numpolis][2];
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

    //Metodos de usar mucho

    public void pintarJugador(){
        malla[posY-1][posX]="@";
        malla[posY][posX-1]="/";malla[posY][posX]="|";
        malla[posY+1][posX-1]="/";
    }
    public void despintarJugador(){
        malla[posY-1][posX]="-";
        malla[posY][posX-1]="-";malla[posY][posX]="-";
        malla[posY+1][posX-1]="-";
    }
    public void pintarPoli(int i){
        int poliY=pospolis[i][0];
        int poliX=pospolis[i][1];
        malla[poliY-1][poliX]="@";
        malla[poliY][poliX]="|";malla[poliY][poliX+1]=">";
        malla[poliY+1][poliX+1]="\\";
    }
    public void despintarPoli(int i){
        int poliY=pospolis[i][0];
        int poliX=pospolis[i][1];
        malla[poliY-1][poliX]="-";
        malla[poliY][poliX]="-";malla[poliY][poliX+1]="-";
        malla[poliY+1][poliX+1]="-";
    }

    public void spawn(){
        Random generator=new Random();
        int pos0=generator.nextInt(altura);
        if(pos0==0) pos0=1;
        if(pos0==altura-1) pos0=altura-2;
        pospolis[spawn-parados-fallados][0]=pos0;
        pospolis[spawn-parados-fallados][1]=0;
        spawn++;
    } //Random elije a que altura spawnea el poli y lo añade al array

    public void moverPj(){
        for(int i=0;i<spawn-parados-fallados;i++){
            despintarPoli(i);
            pospolis[i][1]++;
            pintarPoli(i);
        }
    } //Mueve cada Poli una celda adelante (despintando y pintando)

    public void meta(){

        for (int i=0;i<spawn-parados-fallados;i++)
        {
            //combinaciones posibles de que el jugador pare al poli
            //En X
            if(pospolis[i][1]==posX-2)
            {
                //En Y
                if(pospolis[i][0]<=posY+1&&pospolis[i][0]>=posY-1){
                    parados++;
                    despintarPoli(i);
                    pintarJugador();
                    parado(pospolis,i);

                }
            }else if(pospolis[i][1]==posX-1) //X
            {
                //Y
                if(pospolis[i][0]==posY+2||pospolis[i][0]==posY-2){
                    parados++;
                    despintarPoli(i);
                    pintarJugador();
                    parado(pospolis,i);

                }
            }else if(pospolis[i][1]>posX)
            {
                fallados++;
                despintarPoli(i);
                parado(pospolis,i);
            }
        }

    } //Comprueba si algun poli y el jugador estan a punto de chocar o el poli de llegar a la "meta"
        public void parado(int[][] pospolis,int i){
        this.pospolis=new int[numpolis-parados-fallados][2];
        int j=0,k=0;
        for(int[] pos:pospolis){

            if(i!=j){
                this.pospolis[j-k][0]=pos[0];
                this.pospolis[j-k][1]=pos[1];
            }else{k++;}
            j++;
        }

    } //Si paras a un poli, lo elimino de la array

    public void dibuixarMapa(){

        ta1.setText("");
        pintarJugador(); //Creo que lo quitare
        for(int i = 0; i< altura; i++)
        {
            for(int j = 0; j< ample; j++ )
            {
                ta1.append(malla[i][j]);
            }
            ta1.append("\n");
        }
    } //Prepara el TextArea

    public void generateMapa(){
        for(int i=0;i<altura;i++){

            for(int j=0;j<ample;j++){
                malla[i][j]="-";
            }
        }
        pintarJugador();
    } //Genera el mapa vacio (quiza innecesario)

    public Frame frame(){

        JFrame f = new JFrame("Mapa");

        ta1.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());

        dibuixarMapa();
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
                abajo=true;
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arriba=true;
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time.stop();
            }
        });

        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
        return f;
    } //Botones y layouts del display

    public void tick(){
        separacion--;
        if(separacion==0&&spawn<numpolis){ //Que spawneen a un ritmo
            spawn();
            separacion=3;
        }

        //Moverse solo se podra antes de haber movido a los polis (de momento)
        if(abajo){ //Pulsar el boton abajo cambia este bool,limitando cuando se puede ir abajo
            if(posY+2<altura) {
                despintarJugador();
                posY ++;
                abajo=false;
            }
        }
        if(arriba){
            if(posY-2>=0){
                despintarJugador();
                posY --;
                arriba=false;
            }
        }

        moverPj();
        meta();
        dibuixarMapa();

    } //Cosas que hacer en cada tick del timer



}
