package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinijuegoSeguidor {

    private String oficio;
    private String pregunta,respuesta;
    private String[] respuestas;
    private TextArea ta1 = new TextArea(20, 50);

    public MinijuegoSeguidor(String oficio) {
        this.oficio = oficio;
    }

    public Frame frame(){

        JFrame f = new JFrame("Mapa");

        ta1.setFont(new Font("monospaced", Font.PLAIN, 12));
        //f.setSize(1000, 1000);
        final JPanel contentPane = new JPanel(new BorderLayout());


        JButton respuesta1=new JButton(respuestas[0]);
        JButton respuesta2=new JButton(respuestas[1]);
        JButton respuesta3=new JButton(respuestas[2]);
        JButton respuesta4=new JButton(respuestas[3]);

        contentPane.setLayout(new FlowLayout());

        contentPane.add(ta1, BorderLayout.PAGE_START);
        contentPane.add(respuesta1,BorderLayout.WEST);
        contentPane.add(respuesta2, BorderLayout.NORTH);
        contentPane.add(respuesta3, BorderLayout.SOUTH);
        contentPane.add(respuesta4,BorderLayout.EAST);

        respuesta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Llamar al metodo que las compara y hace el resto
            }
        });
        respuesta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
            }
        });
        respuesta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
            }
        });
        respuesta4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LLamar al metodo etc etc
            }
        });


        f.setContentPane(contentPane);
        f.pack();
        f.setVisible(true);
        return f;
    } //Botones y layouts del display
}

