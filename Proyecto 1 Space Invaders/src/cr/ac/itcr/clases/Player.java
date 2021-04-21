package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player
{
    private double x;
    private double y;

    private BufferedImage jugador;

    public Player(double x, double y, Juego juego)
    {
        this.x = x;
        this.y = y;

        SpriteSheet ss = new SpriteSheet(juego.getSprite());

        jugador = ss.grabImage(1,1,32,32);
    }
    public void tick()
    {

    }
    public void reproductor(Graphics g)
    {
        g.drawImage(jugador,(int)x,(int)y,null);
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

}
