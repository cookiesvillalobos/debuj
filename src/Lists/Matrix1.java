package Lists;

import com.google.gson.Gson;

import java.awt.*;
import java.util.Vector;

/**
 * Esta es la clase que crea la matriz para modelar el tablero
 */
public class Matrix1 {
    LinkList<LinkList> FinalList = new LinkList<>();
    LinkList<Integer> test = new LinkList<>();
    LinkList<Dot> DotsList = new LinkList<>();
    Vector<Dot> vectorDot = new Vector<>();
    LinkList<Line> LineUDList = new LinkList<>();
    LinkList<Line> LineLRList = new LinkList<>();
    LinkList<Figure> figureList = new LinkList<>();
    Gson gson = new Gson();


    private int p1X, p1Y, p2X, p2Y;
    private int p1mX, p1mY, p2mX, p2mY;

    /**
     * Constructor por defecto
     */
    public Matrix1() {
    }

    /**
     * Método que crea la matriz
     */
    public void Create(){
        for (int i = 0; i<10; i++){
            LinkList<Integer> Column = new LinkList<>();
            for (int j = 0; j <10;j++){
                if ( (j%2)==0){
                    Column.addPrev(1);
                }
                else {
                    Column.addPrev(0);
                }
            }
            FinalList.addPrev(Column);
        }
        test.addPrev(1);
        test.addPrev(0);
    }
    /**
     * Método que devuelve la malla de puntos
     */
    public void board1(Graphics g) {
        Create();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (test.see(1)== FinalList.see(i).see(j)){
                    Dot dot = new Dot((i+1)*70, (j+10)*20, i, j);
                    vectorDot.add(dot);
                    DotsList.addPrev(dot);
                    dot.paint(g);
                }
            }
        }
    }
    public void board1lines() {
        Create();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (test.see(1)== FinalList.see(i).see(j)){
                    Dot dot = new Dot((i+1)*70, (j+10)*20, i, j);
                    DotsList.addPrev(dot);
                }
            }
        }
    }
    /**
     * Método que devuelve la malla de líneas
     * @param g Objeto a dibujar
     */

    public void board2(Graphics g) {
        int i = 0;

        // primero se hacen todas las líneas verticales y se guardan en una lista
        while (i < 36) {
            if (i == 35) {
                i++;
            } else if ((i + 1) % 4 == 0) {
                i++;
            } else {
                p1X = DotsList.see(i).getX();
                p1Y = DotsList.see(i).getY();
                p2X = DotsList.see(i + 1).getX();
                p2Y = DotsList.see(i + 1).getY();
                p1mX = DotsList.see(i).getmX();
                p1mY = DotsList.see(i).getmY();
                p2mX = DotsList.see(i + 1).getmX();
                p2mY = DotsList.see(i + 1).getmY();

                Line line = new Line(p1X, p1Y, p2X, p2Y, false, p1mX, p1mY, p2mX, p2mY);
                LineUDList.addPrev(line);
                line.pintar(g);
                i++;
            }
        }
        // Luego se hacen todas las líneas horizontales y se guardan en otra lista
        i = 0;
        while (i < 32) {
            p1X = DotsList.see(i).getX();
            p1Y = DotsList.see(i).getY();
            p2X = DotsList.see(i + 4).getX();
            p2Y = DotsList.see(i + 4).getY();
            p1mX = DotsList.see(i).getmX();
            p1mY = DotsList.see(i).getmY();
            p2mX = DotsList.see(i + 4).getmX();

            p2mY = DotsList.see(i + 4).getmY();

            Line line = new Line(p1X, p1Y, p2X, p2Y, false, p1mX, p1mY, p2mX, p2mY);
            LineLRList.addPrev(line);
            line.pintar(g);

            i++;
        }
    }
    public void board2lines() {
        board1lines();
        int i = 0;

        // primero se hacen todas las líneas verticales y se guardan en una lista
        while (i < 36) {
            if (i == 35) {
                i++;
            } else if ((i + 1) % 4 == 0) {
                i++;
            } else {
                p1X = DotsList.see(i).getX();
                p1Y = DotsList.see(i).getY();
                p2X = DotsList.see(i + 1).getX();
                p2Y = DotsList.see(i + 1).getY();
                p1mX = DotsList.see(i).getmX();
                p1mY = DotsList.see(i).getmY();
                p2mX = DotsList.see(i + 1).getmX();
                p2mY = DotsList.see(i + 1).getmY();

                Line line = new Line(p1X, p1Y, p2X, p2Y, false, p1mX, p1mY, p2mX, p2mY);
                LineUDList.addPrev(line);
                i++;
            }
        }
        // Luego se hacen todas las líneas horizontales y se guardan en otra lista
        i = 0;
        while (i < 32) {
            p1X = DotsList.see(i).getX();
            p1Y = DotsList.see(i).getY();
            p2X = DotsList.see(i + 4).getX();
            p2Y = DotsList.see(i + 4).getY();
            p1mX = DotsList.see(i).getmX();
            p1mY = DotsList.see(i).getmY();
            p2mX = DotsList.see(i + 4).getmX();

            p2mY = DotsList.see(i + 4).getmY();

            Line line = new Line(p1X, p1Y, p2X, p2Y, false, p1mX, p1mY, p2mX, p2mY);
            LineLRList.addPrev(line);

            i++;
        }
    }

    /**
     * Devuelve la lista de los vectores
     * @return lista de los puntos
     */
    public Vector<Dot> viewList(){

        return vectorDot;
    }

    /**
     * Dibuja y prepara todos los cuadrados
     * @param g lo que se va a dibujar
     */
    public void board3(Graphics g){
        int d = 35;
        int i = 0;
        int c = 0;
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        int STEPX = 0;
        int STEPY = 0;

        while (c<24) {
            boolean one = false;
            boolean two = false;
            boolean three = false;
            if (c >= 0 & c <= 7) {
                STEPX = 14;
                STEPY = 2;
                while (i < 4) {
                    while (d < 36) {
                        Dot dot = DotsList.see(d);
                        if ((dot.getmX() == c & dot.getmY() == 1) & !one) {
                            x1 = dot.getX();
                            y1 = dot.getY();
                            one = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c & dot.getmY() == 3) & one) {
                            x2 = dot.getX();
                            y2 = dot.getY();
                            two = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c + 1 & dot.getmY() == 3) & one & two & three) {
                            x3 = dot.getX();
                            y3 = dot.getY();
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c + 1 & dot.getmY() == 1) & one & two) {
                            x4 = dot.getX();
                            y4 = dot.getY();
                            three = true;
                            i++;
                            d--;
                            break;
                        } else {
                            d--;
                        }
                    }
                }
            }

            else if (c >= 8 & c <= 15) {
                STEPX= 14;
                STEPY = 6;
                while (i < 4) {
                    while (d < 36) {
                        Dot dot = DotsList.see(d);
                        if ((dot.getmX() == c-8 & dot.getmY() == 3) & !one) {
                            x1 = dot.getX();
                            y1 = dot.getY();
                            one = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c-8 & dot.getmY() == 5) & one) {
                            x2 = dot.getX();
                            y2 = dot.getY();
                            two = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c - 7 & dot.getmY() == 5) & one & two & three) {
                            x3 = dot.getX();
                            y3 = dot.getY();
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c - 7 & dot.getmY() == 3) & one & two) {
                            x4 = dot.getX();
                            y4 = dot.getY();
                            three = true;
                            i++;
                            d--;
                            break;
                        } else {
                            d--;
                        }
                    }
                }
            }
            else if (c >= 16 & c <= 23) {
                STEPX= 14;
                STEPY = 2;
                while (i < 4) {
                    while (d < 36) {
                        Dot dot = DotsList.see(d);
                        if ((dot.getmX() == c-16 & dot.getmY() == 5) & !one) {
                            x1 = dot.getX();
                            y1 = dot.getY();
                            one = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c-16 & dot.getmY() == 7) & one) {
                            x2 = dot.getX();
                            y2 = dot.getY();
                            two = true;
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c - 15 & dot.getmY() == 7) & one & two & three) {
                            x3 = dot.getX();
                            y3 = dot.getY();
                            i++;
                            d--;
                            break;
                        } else if ((dot.getmX() == c - 15 & dot.getmY() == 5) & one & two) {
                            x4 = dot.getX();
                            y4 = dot.getY();
                            three = true;
                            i++;
                            d--;
                            break;
                        } else {
                            d--;
                        }
                    }
                }
            }

            int xpoints[] = {x1 + STEPX, x2 + STEPX, x3, x4};
            int ypoints[] = {y1 +4+ STEPY, y2 - STEPY, y3 - STEPY, y4 + 4+STEPY};
            Figure figure = new Figure(xpoints, ypoints, false);
            figure.paint(g);
            figureList.addPrev(figure);
            c++;
            d = 35;
            i=0;
        }
    }

    public LinkList<Dot> getDotsList() {
        return DotsList;
    }

    /**
     * Es el método encargado de dibujar las líneas y dejarlas en falso para después dibujarlas verdaderamente
     * @param p1X posición X de donde sale la línea
     * @param p1Y posición Y de donde sale la línea
     * @param p2X posición X a donde llega la línea
     * @param p2Y posición Y a donde llega la línea
     */
    public void lines(int p1X, int p1Y, int p2X, int p2Y, int player, int Turn,LinkList<Line> LineUDList,LinkList<Line> LineLRList){
        int i = 0;
        while (i<32){
            if (i<26){
                Line line = LineUDList.see(i);
                int pm1X = LineUDList.see(i).getXm1();
                int pm1Y = LineUDList.see(i).getYm1();
                int pm2X = LineUDList.see(i).getXm2();
                int pm2Y = LineUDList.see(i).getYm2();

                if ((p1X == pm1X && p1Y == pm1Y && p2X == pm2X && p2Y == pm2Y) || (p2X == pm1X && p2Y == pm1Y && p1X == pm2X && p1Y == pm2Y)){
                    line.setDone(true);
                    line.setTurn(Turn);
                    line.setPlayer(player);
                }


            }
            Line line = LineLRList.see(i);
            int pm1X = LineLRList.see(i).getXm1();
            int pm1Y = LineLRList.see(i).getYm1();
            int pm2X = LineLRList.see(i).getXm2();
            int pm2Y = LineLRList.see(i).getYm2();

            if ((p1X == pm1X && p1Y == pm1Y && p2X == pm2X && p2Y == pm2Y) || (p2X == pm1X && p2Y == pm1Y && p1X == pm2X && p1Y == pm2Y)) {
                line.setDone(true);
                line.setTurn(Turn);
                line.setPlayer(player);
            }

            i++;
        }
        this.LineLRList = LineLRList;
        System.out.println(gson.toJson(LineLRList) + "M");
        this.LineUDList = LineUDList;
    }

    /**
     * Método que se encarga de revisar si algún cuadro ya está dibujado
     * Otorga los puntos a los jugadores según el que realizó la última línea para cerrar el cuadrado.
     */
    public int checkForPoints(int ActualPlayer) {
        int points = 0;
        int c = 0;

        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();

        while (c < 24) {
            if (c >= 0 & c <= 7) {
                one = LineLRList.see(c * 4).isDone();
                two = LineLRList.see(c * 4 + 1).isDone();
                three = LineUDList.see(c * 3).isDone();
                four = LineUDList.see(c * 3 + 3).isDone();
                line1 = LineLRList.see(c * 4);
                line2 = LineLRList.see(c * 4 + 1);
                line3 = LineUDList.see(c * 3);
                line4 = LineUDList.see(c * 3 + 3);
            } else if (c >= 8 & c <= 15) {
                one = LineLRList.see((c - 8) * 4 + 1).isDone();
                two = LineLRList.see((c - 8) * 4 + 2).isDone();
                three = LineUDList.see((c - 8) * 3 + 1).isDone();
                four = LineUDList.see((c - 8) * 3 + 4).isDone();
                line1 =LineLRList.see((c - 8) * 4 + 1);
                line2 = LineLRList.see((c - 8) * 4 + 2);
                line3 =  LineUDList.see((c - 8) * 3 + 1);
                line4= LineUDList.see((c - 8) * 3 + 4);
            } else if (c >= 16 & c <= 23) {
                one = LineLRList.see((c - 16) * 4 + 2).isDone();
                two = LineLRList.see((c - 16) * 4 + 3).isDone();
                three = LineUDList.see((c - 16) * 3 + 2).isDone();
                four = LineUDList.see((c - 16) * 3 + 5).isDone();
                line1 = LineLRList.see((c - 16) * 4 + 2);
                line2 =LineLRList.see((c - 16) * 4 + 3) ;
                line3 = LineUDList.see((c - 16) * 3 + 2);
                line4= LineUDList.see((c - 16) * 3 + 5);
            }
            if (one && two && three && four) {
                figureList.see(23 - c).setPlayer(ActualPlayer,line1, line2, line3, line4);
                points = points + 1;
                figureList.see(23 - c).setDone(true);
                System.out.println(c + " ya esta hecho");
            }

            c++;
        }
        return points;
    }


    /**
     * Da todos los puntos que se han obtenido durante el juego
     * @return
     */
    //public int getPoints(){
    //  return this.points;
    //}

    /**
     * Obtiene la lista de todas las líneas horizontales dibujadas
     * @return lista de las líneas horizontales
     */
    public LinkList<Line> getLineUDList() {
        return LineUDList;
    }

    /**
     * Obtiene la lista de las líneas verticales dibujadas
     * @return lista de las líneas vericales
     */
    public LinkList<Line> getLineLRList() {
        return LineLRList;
    }

    /**
     * Obtiene la lista de los cuadraddos
     * @return lista de los cuadrados
     */
    public LinkList<Figure> getFigureList() {
        return figureList;
    }

    public int Player1Points(){
        int c = 0;
        int pointsPlayer1 = 0;
        while (c<24){
            if (figureList.see(c).getPlayer() == 1){
                pointsPlayer1++;
            }
            c++;
        }
        return pointsPlayer1;
    }

    public int Player2Points(){
        int c = 0;
        int pointsPlayer2 = 0;
        while (c<24){
            if (figureList.see(c).getPlayer() == 2){
                pointsPlayer2++;
            }
            c++;
        }
        return pointsPlayer2;
    }
}
