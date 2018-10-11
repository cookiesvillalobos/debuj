package Lists;

import java.awt.*;

/**
 * Clase que representa las líneas en la interfaz
 */
public class Line {
    private int x1, y1, x2, y2;
    private boolean done;
    private int xm1, ym1, xm2, ym2;
    private int player = 0;
    private int Turn = -1;

    /**
     * Constructor para cuando se quiere crear una línea
     * @param x1 Posición X de donde empieza la línea
     * @param y1 Posición Y de donde empieza la línea
     * @param x2 Posición X de donde termina la línea
     * @param y2 Posición Y de donde termina la línea
     * @param done Dice si la línea ya fue dibujada o no
     * @param xm1 Posición X del punto inicial dentro de la matriz
     * @param ym1 Posición Y del punto inicial dentro de la matriz
     * @param xm2 Posición X del punto final dentro de la matriz
     * @param ym2 Posición Y del punto final dentro de la matriz
     */
    public Line(int x1, int y1, int x2, int y2, boolean done, int xm1, int ym1, int xm2, int ym2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.done = done;
        this.xm1 = xm1;
        this.ym1 = ym1;
        this.xm2 = xm2;
        this.ym2 = ym2;
    }

    public Line(){

    }

    /**
     * Se encarga de pintar las líneas según esten o no dibujadas
     * @param g línea a dibujar
     */
    public void pintar (Graphics g){
        if (done) {
            if (player == 1) {
                g.setColor(Color.GREEN);
                g.drawLine(x1, y1, x2, y2);
            }
            else if (player == 2){
                g.setColor(Color.BLUE);
                g.drawLine(x1, y1, x2, y2);
            }
        }
        else {
            g.setColor(Color.BLACK);
            g.drawLine(x1,y1,x2,y2);
        }
    }

    /**
     * Obtiene la posición X del primer punto dentro de la malla
     * @return
     */
    public int getXm1() {
        return xm1;
    }

    /**
     * Obtiene la posición Y del primer punto dentro de la malla
     * @return
     */
    public int getYm1() {
        return ym1;
    }

    /**
     * Oteniene la posición X del último punto dentro de la malla
     * @return
     */
    public int getXm2() {
        return xm2;
    }

    /**
     * Obtiene la posición Y del último punto dentro de la malla
     * @return
     */
    public int getYm2() {
        return ym2;
    }

    /**
     * Cuando se dibuja la línea se llama para poder ponerla como dibujada
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Obtiene si la línea ya fue dibujada o no
     * @return
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Método para obtener el jugador que dibujó la línea
     * @return devuelve el número del jugador
     */
    public int getPlayer() {
        return player;
    }

    /**
     * Para establecer el jugador que hace la línea
     * @param player jugador 1 y 2
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    public int getTurn() {
        return Turn;
    }

    public void setTurn(int turn) {
        Turn = turn;
    }
}
