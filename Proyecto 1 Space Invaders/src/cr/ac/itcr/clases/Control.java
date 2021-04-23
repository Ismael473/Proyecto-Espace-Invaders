package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;


public class Control
{
    private LinkedList<Entidad> e = new LinkedList<Entidad>();

    Entidad ent;
    private Texturas texturas;

    public Control(Juego juego, Texturas texturas)
    {
        this.texturas = texturas;
        //for(int i = 0; i < 20; i++)
            //addEntidad(new Enemigos(100,100,texturas));
    }

    public void tick()
    {
        for(int i = 0; i < e.size();i++)
        {
            ent = e.get(i);

            ent.tick();
        }
    }

    public void reproductor(Graphics g)
    {
        for(int i = 0; i < e.size();i++)
        {
            ent = e.get(i);

            ent.reproductor(g);
        }
    }

    public void addEntidad(Entidad block)
    {
        e.add(block);
    }

    public void removeEntidad(Entidad block)
    {
        e.remove(block);
    }
}
