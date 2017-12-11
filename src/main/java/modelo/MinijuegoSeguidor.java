package modelo;

import modelo.clasesTablas.Minijuegoseguidorestable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MinijuegoSeguidor {

    private String tema;
    private int id;
    private String pregunta, respuesta;
    private String[] respuestas;

    private TextArea tal = new TextArea(20, 50);
    private int resultado;
    private JFrame f;

    public MinijuegoSeguidor(String oficio) {
        this.tema = oficio;
        Minijuegoseguidorestable table=new Minijuegoseguidorestable(oficio);
        ArrayList<Object[]> cosas=table.select();
        Object[] o=cosas.remove(0);
            for(int i=0;i<o.length;i++){
               switch (i) {
                   default:
                       tema=o[i].toString();
                       break;
                   case 1:
                       id=(Integer)o[i];
                       break;
                   case 2:
                       pregunta=o[i].toString();
                       break;
                   case 3:
                       respuesta=o[i].toString();
                       break;
                   case 4:
                       this.respuestas=new String[4];
                       this.respuestas[0]=o[i].toString();
                       break;
                   case 5:
                       this.respuestas[1]=o[i].toString();
                       break;
                   case 6:
                       this.respuestas[2]=o[i].toString();
                       break;
                   case 7:
                       this.respuestas[3]=o[i].toString();
                       break;

               }
            }

        displayPregunta();
        frame();
    }

    public void displayPregunta(){

        tal.setText("");
        tal.append(pregunta);

    }

    public void comprobarRespuesta(String elegida){

        if (elegida.equals(respuesta)){
            tal.append("\nRespuesta correcta!");
            resultado=1;

        }else{
            tal.append("\nRespuesta incorrecta");
            resultado=0;
        }
        //f.setVisible(false);

    }

    public Frame frame(){

        f = new JFrame("Mapa");

        tal.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());


        JButton respuesta1=new JButton(respuestas[0]);
        JButton respuesta2=new JButton(respuestas[1]);
        JButton respuesta3=new JButton(respuestas[2]);
        JButton respuesta4=new JButton(respuestas[3]);

        contentPane.setLayout(new FlowLayout());

        contentPane.add(tal, BorderLayout.PAGE_START);
        contentPane.add(respuesta1,BorderLayout.WEST);
        contentPane.add(respuesta2, BorderLayout.NORTH);
        contentPane.add(respuesta3, BorderLayout.SOUTH);
        contentPane.add(respuesta4,BorderLayout.EAST);

        respuesta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo que las compara y hace el resto
                comprobarRespuesta(respuesta1.getText());
            }
        });
        respuesta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
                comprobarRespuesta(respuesta2.getText());
            }
        });
        respuesta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
                comprobarRespuesta(respuesta3.getText());
            }
        });
        respuesta4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
                comprobarRespuesta(respuesta4.getText());
            }
        });


        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
        return f;
    } //Botones y layouts del display
}

