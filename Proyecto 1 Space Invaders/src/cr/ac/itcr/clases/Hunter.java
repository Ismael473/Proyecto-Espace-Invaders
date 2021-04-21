package cr.ac.itcr.clases;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Hunter extends MoveableObject implements Drawable, MouseListener {

    private boolean right, left;

    public Hunter (int posX, int posY, int width, int height, String spriteName) {

        super(posX, posY, width, height, 5, spriteName);
        this.right = false;
        this.left = false;

    }
    @Override
    public void draw(Graphics2D target) {
        target.drawImage(this.getImageSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void updateState(double delta) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hello");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
