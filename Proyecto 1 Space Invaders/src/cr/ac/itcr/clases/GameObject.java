package cr.ac.itcr.clases;

import java.awt.*;

public abstract class GameObject
{

    private double x, y;

    public GameObject(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Rectangle getLimites()
    {
        return new Rectangle((int)x, (int)y, 32,32);
    }

}
