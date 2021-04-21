package cr.ac.itcr.clases;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Todos los elementos desplegados en la pantalla
 * durante el tiempo de juego, van a ser objetos del juego,
 * por ello se tiene esta clase abstracta, en la cual se
 * establecen los parametros fijos que van a tener estos objetos
 *
 * @author kleader Gutierrez Pineda
 */
public abstract class GameObjects {

    private int posX, posY, width, height;
    private BufferedImage imageSprite;

    public GameObjects(int posX, int posY, int width, int height, String spriteName) {

        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        try {
            URL url = this.getClass().getResource("/res/"+spriteName+".png");
            imageSprite = ImageIO.read(url);
        } catch(IOException e) {e.printStackTrace();}
        // el metodo descargarImgs puede retornar error, se maneja aca mismo try/catch
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImageSprite() {
        return imageSprite;
    }

    public void setImage(String spriteName) {

        try {
            URL url = this.getClass().getResource("/images/"+spriteName+".png");
            imageSprite = ImageIO.read(url);
        } catch(IOException e) {e.printStackTrace();}
    }
}
