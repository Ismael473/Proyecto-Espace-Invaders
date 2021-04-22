package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player
{
    private double x;
    private double y;

    private double velX = 0;

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
        x+=velX;

        if(x <= -10)
        {
            x = -10;
        }
        if(x >= 610)
        {
            x = 610;
        }
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

    public void setVelX(double velX)
    {
        this.velX = velX;
    }

}
