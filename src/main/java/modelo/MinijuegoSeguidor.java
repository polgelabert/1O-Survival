package modelo;

import controlador.excepciones.UsuarioNoExisteException;
import modelo.clasesTablas.Minijuegoseguidorestable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MinijuegoSeguidor {

    private String tema;
    private String pregunta, respuesta;
    private String[] respuestas;

    private TextArea tal = new TextArea(20, 50);
    private int resultado;
    private JFrame f;

    public MinijuegoSeguidor(String oficio) throws UsuarioNoExisteException {
        this.tema = oficio;
        Minijuegoseguidorestable table=new Minijuegoseguidorestable(oficio);
        table.select();
        setDatos(table.datos());
        displayPregunta();
        frame();
    }

    public void setDatos(String[][] datos){
        tema=datos[0][0];
        pregunta=datos[0][1];
        respuesta=datos[0][2];
        respuestas=new String[4];
        respuestas[0]=datos[1][0];
        respuestas[1]=datos[1][1];
        respuestas[2]=datos[1][2];
        respuestas[3]=datos[1][3];
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

