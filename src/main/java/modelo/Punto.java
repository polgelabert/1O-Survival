package modelo;

public class Punto {

    int x;
    int y;


    public Punto(){ // si la posicion es negativa, el objeto esta en el inventario, no en el mapa
        this.x = -1;
        this.y = -1;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }




}