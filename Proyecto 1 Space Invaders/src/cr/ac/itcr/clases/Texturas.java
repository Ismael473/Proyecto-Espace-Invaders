package cr.ac.itcr.clases;

import java.awt.image.BufferedImage;

public class Texturas
{
    public BufferedImage cazador, bala, pato1, pato2, pato3, pato4, pato5, pato6, pato7;

    private SpriteSheet ss;

    public Texturas(Juego juego)
    {
        ss = new SpriteSheet(juego.getSprite());

        getTextures();
    }

    private void getTextures()
    {
        cazador = ss.grabImage(1,1,32,32);
        bala = ss.grabImage(2,1,32,32);
        pato1 = ss.grabImage(3,1,32,32);
        pato2 = ss.grabImage(4,1,32,32);
        pato3 = ss.grabImage(5,1,32,32);
        pato4 = ss.grabImage(6,1,32,32);
        pato5 = ss.grabImage(7,1,32,32);
        pato6 = ss.grabImage(8,1,32,32);
        pato7 = ss.grabImage(1,2,32,32);
    }
}
