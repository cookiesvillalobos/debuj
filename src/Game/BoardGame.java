package Game;

import Lists.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

/**
 * Es la clase que se encarga de hacer las cosas en la pantalla y dibujar.
 * Interactúa con las demás clases para hacer los componentes en la pantalla y tener un juego óptimo
 */
public class BoardGame extends JPanel implements MouseListener {
    Matrix2 matrix;

    private int indicator = 0;
    private int TotalPoint = 0;
    private int Player1Points = 0;
    private int Player2Points = 0;
    private int Turn = 0;
    private int Player = 1;
    private int p1mX, p1mY, p2mX, p2mY;

    private Vector<Dot> DotList;
    private LinkList<Line> LineUDList;
    private LinkList<Line> LineLRList;
    private LinkList<Figure> FigureList;

    private Point p1;
    private Point p2;

    private Dot a = new Dot(0,0,0,0);
    private Dot b;

    private GsonReceiver gsonReceiver;


    public BoardGame(Matrix2 matrix, int Turn, int Player){
        setBackground(Color.BLACK);
        this.addMouseListener(this);
        this.matrix = matrix;

        LineLRList = matrix.getLineLRList();
        LineUDList = matrix.getLineUDList();
        FigureList = matrix.getFigureList();

    }

    /**
     * Método para dibujar los componentes
     * @param g lo que se va a dibujar
     */
    public void paintComponent (Graphics g){
        if ( indicator ==0) {
            g.setColor(Color.BLACK);
            g.fillRect(1, 1, 692, 592);

            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.YELLOW);
            matrix.board1(g2);
            matrix.board2(g2);
            matrix.board3(g2);
            indicator++;
            System.out.println("Es el turno del jugador 1");
            DotList = matrix.viewList();


        }
        else {

            int i = 0;
            while (i < 32) {
                Line line;
                line = LineLRList.see(i);
                line.pintar(g);
                i++;
            }
            i = 0;
            while (i < 27) {
                Line line;
                line = LineUDList.see(i);
                line.pintar(g);
                i++;
            }

            i=0;
            while (i<24){
                Figure figure;
                figure = FigureList.see(i);
                figure.paint(g);
                i++;
            }
        }
        System.out.println("Puntos totales: " + TotalPoint);
        System.out.println("Puntos jugador 1: " + Player1Points);
        System.out.println("Puntos jugador 2: " + Player2Points);

    }

    public GsonReceiver getGsonReceiver() {
        return gsonReceiver;
    }

    /**
     * Método que escucha al mouse y sabe cuando se presionan los botones del mismo para dibujar una línea
     * @param e es el evento o botón presionado
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){

            for (Dot dot : DotList){

                if (new Rectangle(dot.getX(), dot.getY(), 10,10).contains(e.getPoint())){
                    if (p1 == null){
                        p1 = new Point(dot.getX(), dot.getY());
                        p1mX = dot.getmX();
                        p1mY = dot.getmY();
                        a = dot;
                        break;
                    }
                    else if (p1.x != dot.getX() || p1.y != dot.getY()) {
                        p2 = new Point(dot.getX(), dot.getY());
                        p2mX = dot.getmX();
                        p2mY = dot.getmY();
                        b = dot;
                        gsonReceiver = new GsonReceiver(p1,p2,Turn,Player,indicator,p1mX,p1mY,p2mX,p2mY,matrix);
                        Turn++;

                    }

                    repaint();
                    p1 = null;
                    p2 = null;
                    a = null;
                    b = null;
                    break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
