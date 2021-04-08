package cr.ac.itcr.clases;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

public abstract class Juego extends Canvas implements Runnable
{
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int ESCALA = 2;
    public final String TITLE = "DUCK INVADERS";

    public static void main(String args[])
    {
        Juego juego = new Juego() {
            @Override
            public void run() {

            }
        };

        juego.setPreferredSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        juego.setMaximumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        juego.setMinimumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));

        JFrame frame = new JFrame(juego.TITLE);
        frame.add(juego);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
