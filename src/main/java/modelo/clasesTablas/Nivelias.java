package modelo.clasesTablas;

public class Nivelias extends DAO{

    private final String iddificultad;
    private double velocidad;
    private int numero;

    public Nivelias(String iddificultad) {
        this.iddificultad = iddificultad;
    }


    //GETTERS


    public String getIddificultad() {
        return iddificultad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public int getNumero() {
        return numero;
    }

    //SETERS


    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
