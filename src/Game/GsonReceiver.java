package Game;

import java.awt.*;

public class GsonReceiver {
    Point point1;
    Point point2;
    int turn;
    int player;
    int indicator;
    int p1mX,p1mY,p2mX,p2mY;

    public GsonReceiver(Point point1, Point point2, int turn, int player, int indicator, int p1mX, int p1mY, int p2mX, int p2mY) {
        this.point1 = point1;
        this.point2 = point2;
        this.turn = turn;
        this.player = player;
        this.indicator = indicator;
        this.p1mX = p1mX;
        this.p1mY = p1mY;
        this.p2mX = p2mX;
        this.p2mY = p2mY;
    }
}
