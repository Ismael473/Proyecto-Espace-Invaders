package cr.ac.itcr.clases;
//Menu del juego
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.nio.Buffer;

public class Juego extends Canvas implements Runnable
{
    private static final long serialVersionUID =1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = 350;
    public static final int ESCALA = 2;
    public final String TITLE = "DUCK INVADERS";

    public boolean corriendo = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage cazador = null;
    private BufferedImage bullet = null;
    private BufferedImage fondo = null;

    private Player p;
    private Control c;

    public void init()
    {
        requestFocus();
        BufferedDescargarImgs downloader = new BufferedDescargarImgs();
        try
        {
            cazador = downloader.descargarImg("cazador.png");
            bullet = downloader.descargarImg("bullet.png");
            fondo = downloader.descargarImg("fondojuego.png")
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        addKeyListener(new KeyInput(this));

        p = new Player(300,650,this);
        c = new Control(this);
    }


    private synchronized void start()
    {
        if(corriendo)
            return;
        corriendo = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop()
    {
        if(!corriendo)
            return;
        corriendo = false;
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

        while(corriendo)
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
        p.tick();
        c.tick();
    }

    private void reproductor()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs==null)
        {
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();

        graphics.drawImage(image,0,0,getWidth(),getHeight(),this);

        p.reproductor(graphics);
        c.reproductor(graphics);

        graphics.dispose();
        bs.show();
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p.setVelX(5);
        }
        else if(key == KeyEvent.VK_LEFT)
        {
            p.setVelX(-5);
        }

    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT)
        {
            p.setVelX(0);
        }
        else if(key == KeyEvent.VK_LEFT)
        {
            p.setVelX(0);
        }
    }

    public static void main(String args[])
    {
        Juego juego = new Juego();

        juego.setPreferredSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        juego.setMaximumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));
        juego.setMinimumSize(new Dimension(WIDTH*ESCALA,HEIGHT*ESCALA));

        JFrame frame = new JFrame(juego.TITLE);
        frame.add(juego);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        juego.start();
    }

    public BufferedImage getSprite(int n)
    {
        if(n == 1)
        {
            return cazador;
        }
        else if(n == 2)
        {
            return bullet;
        }
        return fondo;

    }
}
