
package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Bullet
{
    private double x;
    private double y;

    private Texturas texturas;

    public Bullet(double x, double y,Texturas texturas)
    {
        this.x = x;
        this.y = y;
        this.texturas = texturas;

    }

    public void tick()
    {
        y -= 10;
    }

    public void reproductor(Graphics g)
    {
        g.drawImage(texturas.bala, (int)x,(int)y,null);
    }

    public double getY()
    {
        return y;
    }
}
