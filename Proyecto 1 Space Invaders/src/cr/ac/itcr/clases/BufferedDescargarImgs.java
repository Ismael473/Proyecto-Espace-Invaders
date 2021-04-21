package cr.ac.itcr.clases;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedDescargarImgs {

    private BufferedImage imagen;

    public BufferedDescargarImgs() {}

    public BufferedImage descargarImg(String path) throws IOException {

        imagen = ImageIO.read(getClass().getResource(path));
        return imagen;
    }
}
