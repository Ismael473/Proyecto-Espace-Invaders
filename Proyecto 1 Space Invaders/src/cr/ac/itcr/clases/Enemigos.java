package cr.ac.itcr.clases;

import java.awt.*;

public class Enemigos
{
    private double x;
    private double y;

    Bullet bullet;

    private Texturas texturas;

    public Enemigos(double x, double y, Texturas texturas)
    {
        this.x = x;
        this.y = y;
        this.texturas = texturas;

    }

    public void tick()
    {
        y += 1;
    }

    public void reproductor(Graphics graphics)
    {
        graphics.drawImage(texturas.pato1,(int)x,(int)y,null);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
