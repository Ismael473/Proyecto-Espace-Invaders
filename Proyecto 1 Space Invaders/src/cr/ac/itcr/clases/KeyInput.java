package cr.ac.itcr.clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    Juego juego;

    public KeyInput(Juego juego)
    {
        this.juego = juego;
    }

    public void keyPressed(KeyEvent e)
    {
        juego.keyPressed(e);
    }

    public void keyReleased(KeyEvent e)
    {
        juego.keyReleased(e);
    }
}
