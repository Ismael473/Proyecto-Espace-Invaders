package cr.ac.itcr.clases;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage imagen;

    public SpriteSheet(BufferedImage image)
    {
        this.imagen = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height)
    {
        BufferedImage img = imagen.getSubimage((col * 32)-32, (row * 32)-32, width, height);
        return img;
    }


}
