package Game;

import Lists.Matrix2;

import java.awt.*;

public class GsonReceiver {
    Point point1;
    Point point2;
    int turn;
    int player;
    int indicator;
    int p1mX,p1mY,p2mX,p2mY;
    Matrix2 matrix;
    public GsonReceiver(Point point1, Point point2, int turn, int player, int indicator, int p1mX, int p1mY, int p2mX, int p2mY, Matrix2 matrix) {
        this.point1 = point1;
        this.point2 = point2;
        this.turn = turn;
        this.player = player;
        this.indicator = indicator;
        this.p1mX = p1mX;
        this.p1mY = p1mY;
        this.p2mX = p2mX;
        this.p2mY = p2mY;
        this.matrix = matrix;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getP1mX() {
        return p1mX;
    }

    public void setP1mX(int p1mX) {
        this.p1mX = p1mX;
    }

    public int getP1mY() {
        return p1mY;
    }

    public void setP1mY(int p1mY) {
        this.p1mY = p1mY;
    }

    public int getP2mX() {
        return p2mX;
    }

    public void setP2mX(int p2mX) {
        this.p2mX = p2mX;
    }

    public int getP2mY() {
        return p2mY;
    }

    public void setP2mY(int p2mY) {
        this.p2mY = p2mY;
    }

    public Matrix2 getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix2 matrix) {
        this.matrix = matrix;
    }
}
