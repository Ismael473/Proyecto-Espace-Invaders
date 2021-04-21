package cr.ac.itcr.clases;
import java.awt.Rectangle;
/**
 * En esta clase se establecen los parametros para
 * aquellos objetos que se van a mover dentro de los
 * limites de la pantalla de juego. Todos estos a su vez
 * son objetos de juego por esto heredan de GameObjects
 *
 * @author kleader Gutierrez Pineda
 */
public class MoveableObject extends GameObjects{

    // estas son variables que los objetos en pantalla tendran
    private int speed;
    private boolean collide;
    private Rectangle bbox;

    public MoveableObject(int posX, int posY, int width, int height, int speed, String spriteName) {

        super(posX, posY, width, height, spriteName);
        this.speed = speed;
        this.collide = false;
        this.bbox = new Rectangle(posX, posY, width, height);
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getBbox() {
        return bbox;
    }

    public void setBbox(Rectangle bbox) {
        this.bbox = bbox;
    }

    public boolean isCollide(MoveableObject anotherObject) {
        collide = anotherObject.getBbox().intersects(this.getBbox());
        return collide;
    }
}
