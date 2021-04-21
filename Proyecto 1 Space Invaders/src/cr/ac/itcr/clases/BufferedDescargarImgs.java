package cr.ac.itcr.clases;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedDescargarImgs
{
    private BufferedImage image;

    public BufferedImage descargarImg(String path) throws IOException
    {
        image = ImageIO.read(getClass().getResource(path));
        return image;
    }
}
