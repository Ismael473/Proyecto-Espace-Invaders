package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;


public class Control
{
    private LinkedList<Bullet> b = new LinkedList<Bullet>();
    private LinkedList<Enemigos> e = new LinkedList<Enemigos>();

    Bullet BulletTemp;
    Enemigos EneTemp;
    Graphics g;
    Juego juego;
    Texturas texturas;

    private BufferedImage gameover;

    public Control(Juego juego, Texturas texturas)
    {
        this.juego = juego;
        this.texturas = texturas;

        addEnemigo(new Enemigos(100,0, texturas));
    }

    public void tick()
    {
        for(int i = 0; i < b.size(); i++)
        {
            BulletTemp = b.get(i);

            if(BulletTemp.getY() < 0)
                removeBullet(BulletTemp);

            BulletTemp.tick();

        }
        for(int i = 0; i < e.size(); i++)
        {
            EneTemp = e.get(i);

            //if(EneTemp.getY()>(Juego.HEIGHT*Juego.ESCALA))
            //{
            //    Juego.State = Juego.STATE.GAMEOVER;
            //}

            EneTemp.tick();
        }
    }

    public void reproductor(Graphics g)
    {
        for(int i = 0; i < b.size(); i++)
        {
            BulletTemp = b.get(i);

            BulletTemp.reproductor(g);

        }
        for(int i = 0; i < e.size(); i++)
        {
            EneTemp = e.get(i);

            EneTemp.reproductor(g);

        }
    }

    public void addBullet(Bullet block)
    {
        b.add(block);
    }

    public void removeBullet(Bullet block)
    {
        b.remove(block);
    }

    public void addEnemigo(Enemigos block)
    {
        e.add(block);
    }

    public void removeEnemigo(Enemigos block)
    {
        e.remove(block);
    }
}
