package cr.ac.itcr.clases;

import java.awt.*;

public interface Drawable {

    public void draw(Graphics2D target);
    public void updateState(double delta);
}
