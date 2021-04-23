package cr.ac.itcr.clases;

import java.awt.*;

public class Enemigos extends GameObject implements Entidad
{
    Juego juego;
    Bullet bullet;

    private Texturas texturas;

    public Enemigos(double x, double y, Texturas texturas)
    {
        super(x,y);
        this.texturas = texturas;

    }


    public void tick()
    {
        y += 2;

        if(y>((Juego.HEIGHT*Juego.ESCALA)-90))
        {
            Juego.State = Juego.STATE.GAMEOVER;
        }
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
