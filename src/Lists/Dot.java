package Lists;

import java.awt.*;

/**
 * Clase que representa el punto dentro del juego
 */
public class Dot {
    private int x; //posición X en la pantalla
    private int y; //posición Y en la pantalla
    private int mX; //posición X en la matriz
    private int mY; // posición Y en la matriz

    /**
     * Constructor de los punto
     * @param x Posición x en la pantalla
     * @param y Posición "Y" en la pantalla
     * @param mX Posición "X" en la matriz
     * @param mY Posición "Y" en la matriz
     */
    public Dot(int x, int y, int mX, int mY) {
        this.x = x;
        this.y = y;
        this.mX = mX;
        this.mY = mY;
    }

    /**
     * Método para pintar los puntos
     * @param g punto y características
     */
    public void paint (Graphics g){
        g.drawOval(x,y,10,10);
        g.fillOval(x,y,10,10);
    }

    /**
     * Obtiene la posicón "X" en la pantalla del punto
     * @return
     */
    public int getX() {
        return x;
    }
    /**
     * Obtiene la posicón "Y" en la pantalla del punto
     * @return
     */

    public int getY() {
        return y;
    }
    /**
     * Obtiene la posicón "X" en la matrixz del punto
     * @return
     */
    public int getmX() {
        return mX;
    }
    /**
     * Obtiene la posicón "X" en la matriz del punto
     * @return
     */

    public int getmY() {
        return mY;
    }

}

