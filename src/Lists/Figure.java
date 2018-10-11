package Lists;

import java.awt.*;

public class Figure {
    private int xpoints[];
    private int ypoints[];
    private boolean done;
    private int player = 0;
    private int PlayerLineOne = 0;
    private int PlayerLineTwo = 0;
    private int PlayerLineThree = 0;
    private int PlayerLineFour = 0;
    private Lot lot = new Lot();



    public Figure(int[] xpoints, int[] ypoints, boolean done) {
        this.xpoints = xpoints;
        this.ypoints = ypoints;
        this.done = done;
    }

    public void paint(Graphics g) {
        int npoints = 4;
        if (!done){
            g.setColor(Color.BLACK);
            g.fillPolygon(xpoints, ypoints, npoints);

        }
        else {
            if (player == 1) {
                System.out.println("Jugador 1");
                g.setColor(Color.GREEN);
                g.fillPolygon(xpoints, ypoints, npoints);
            }
            else if (player == 2){
                System.out.println("Jugador 2");
                g.setColor(Color.BLUE);
                g.fillPolygon(xpoints, ypoints, npoints);
            }
        }
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player, Line one, Line two, Line three, Line four) {
        int ActualPlayer = lot.ViewPlayer(one.getTurn(),two.getTurn(),three.getTurn(),four.getTurn());
        if (one.getTurn() == ActualPlayer){
            this.player = one.getPlayer();
        }
        else if (two.getTurn() == ActualPlayer){
            this.player = two.getPlayer();
        }
        else if (three.getTurn() == ActualPlayer){
            this.player = three.getPlayer();
        }
        else if (four.getTurn() == ActualPlayer){
            this.player = four.getPlayer();
        }


        System.out.println(this.player);
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }


}
