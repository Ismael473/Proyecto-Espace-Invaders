package cr.ac.itcr.clases;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener
{
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e)
    {
        int mousex = e.getX();
        int mousey = e.getY();

        /**
         * public Rectangle playB = new Rectangle(Juego.WIDTH/2+120,470,100,50);
         * public Rectangle infoB = new Rectangle(Juego.WIDTH/2+120,535,100,50);
         * public Rectangle instruB = new Rectangle(Juego.WIDTH/2+120,600,100,50);
         * public Rectangle quitB = new Rectangle(535,10,100,50);
         */

        //Play Button
        if(mousex >= Juego.WIDTH/2+120 && mousex <= Juego.WIDTH/2+220)
        {
            if(mousey >= 470 && mousey <= 520)
            {
                //Play Presionado
                Juego.State = Juego.STATE.JUEGO;
            }
            else if(mousey >= 535 && mousey <= 585)
            {
                Juego.State = Juego.STATE.INFORMACION;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e)
    {


    }

    public void mouseExited(MouseEvent e) {

    }
}
