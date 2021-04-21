package cr.ac.itcr.windows;
//Menu del juego
import cr.ac.itcr.clases.BufferedDescargarImgs;
import cr.ac.itcr.clases.Hunter;
import cr.ac.itcr.clases.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameStarter extends Canvas implements Runnable
{
    private static final long serialVersionUID =1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = 350;
    public static final int ESCALA = 2;
    public final String TITLE = "DUCK INVADERS";

    public boolean running = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage cazador = null;

    private BufferedImage jugador;

    public void init(){

        Hunter h = new Hunter(150,280,40,60,"cazador");

    }

    private synchronized void start()
    {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop()
    {
        if(!running)
            return;
        running = false;
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run()
    {
        init();
        long ultVez = System.nanoTime();
        final double cantidaddeTicks = 60.0;
        double ns = 1000000000 / cantidaddeTicks;
        double d = 0;
        int updates = 0;
        int cuadros = 0;
        long relojauto = System.currentTimeMillis();

        while(running)
        {
            //System.out.println("Working");
            long ahora = System.nanoTime();
            d += (ahora - ultVez ) / ns;
            ultVez = ahora;
            if(d >= 1)
            {
                tick();
                updates++;
                d--;
            }
            reproductor();
            cuadros++;

            if(System.currentTimeMillis() - relojauto > 1000)
            {
                relojauto += 1000;
                System.out.println(updates + "Ticks, FPS" + cuadros);
                updates = 0;
                cuadros = 0;
            }
        }
        stop();
    }

    private void tick()
    {

    }

    private void reproductor(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs==null)
        {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();

        graphics.drawImage(image,0,0,getWidth(),getHeight(),this);

        graphics.drawImage(jugador,100,100,this);

        graphics.dispose();
        bs.show();

    }

    public static void main(String args[])
    {
        GameStarter gameStarter = new GameStarter();

        gameStarter.setPreferredSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        gameStarter.setMaximumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        gameStarter.setMinimumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));

        JFrame frame = new JFrame(gameStarter.TITLE);
        frame.add(gameStarter);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gameStarter.start();
    }
}
