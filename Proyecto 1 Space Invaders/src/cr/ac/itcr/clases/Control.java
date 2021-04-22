package cr.ac.itcr.clases;

import java.awt.*;
import java.util.LinkedList;


public class Control
{
    private LinkedList<Bullet> b = new LinkedList<Bullet>();

    Bullet BulletTemp;

    Juego juego;

    public Control(Juego juego)
    {
        this.juego = juego;
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
    }

    public void reproductor(Graphics g)
    {
        for(int i = 0; i < b.size(); i++)
        {
            BulletTemp = b.get(i);

            BulletTemp.reproductor(g);

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
}
