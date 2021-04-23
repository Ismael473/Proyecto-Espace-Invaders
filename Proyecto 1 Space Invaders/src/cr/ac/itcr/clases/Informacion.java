package cr.ac.itcr.clases;

import java.awt.*;

public class Informacion
{
    public Rectangle backB = new Rectangle(Juego.WIDTH/2+120,470,100,50);
    public void reproductor(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;

        Font f = new Font("arial",Font.BOLD,30);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("BACK", backB.x+20, backB.y+35);
        g2D.draw(backB);
    }
}
