package cr.ac.itcr.clases;

import java.awt.Graphics;

public interface Entidad
{
    public void tick();
    public void reproductor(Graphics g);

    public double getX();
    public double getY();


}
