package Game;

import Lists.Matrix2;

import javax.swing.*;

public class Window extends JFrame {
    private final int WIDTH = 700, HEIGH = 600;
    private BoardGame sheet;

    public Window(Matrix2 matrix, int Turn, int Player){
        setTitle("Dots"); //Título de la ventana
        setSize(WIDTH,HEIGH); //Dimensiones
        setLocationRelativeTo(null); //Posición en el centro de la pantalla
        setResizable(false); // No se puede cambiar el tamaño
        sheet = new BoardGame(matrix, Turn, Player);
        add(sheet);
    }

    public BoardGame getSheet() {
        return sheet;
    }
}
