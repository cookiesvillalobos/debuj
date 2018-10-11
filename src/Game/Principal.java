package Game;


import Lists.Matrix2;

import javax.swing.*;

/**
 * Clase principal
 * Crea la pantalla y tiene una instancia de la ventana
 * Hace que se pueda cerrar la ventana con el botón de la X
 * Es la clase que se corre
 */
public class Principal {
    Window window;
    public Principal(Matrix2 matrix, int Turn, int Player){
        window = new Window(matrix,Turn, Player);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Window getWindow() {
        return window;
    }
}
