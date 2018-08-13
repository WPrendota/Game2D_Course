package core;

import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import java.util.Random;
public class Main extends Canvas implements Runnable{
    public static final String TITLE = "Moja gra platformowa";
    public static final int WIDTH = 800, HEIGHT = 600;
    private static final int FRAMERATE = 60;

    private boolean RUNNING = false;
    private JFrame frame;

    private Screen screen;
    private Keyboard keyboard = new Keyboard();

    int x = 40,y = 40;

    public static final Sprite s = new Sprite(0,0,16,Spritesheet.def1);

    private BufferedImage image = new BufferedImage(128, 64, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Main(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new Keyboard());

        frame.add(this, new BorderLayout().CENTER);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        screen = new Screen(128,64);
    }

    public void start(){
        if(RUNNING) return;
        RUNNING = true;

        new Thread(this, "Game " + TITLE).start();
    }

    private double timerek = System.currentTimeMillis();  //Pobranie aktualnego czasu w milisekundach
    private int FPS = 0;
    private int UPS = 0;
    private double delta;
    private double frametime = 1000000000 / FRAMERATE;
    private long timeNOW = System.nanoTime();
    private long timeLAST = System.nanoTime();

    @Override
    public void run() {
        while(RUNNING){
            timeNOW = System.nanoTime();
            delta += (timeNOW - timeLAST) / frametime;
            timeLAST = timeNOW;

            while(delta >= 1){
                update();
                delta -= 1;
                UPS++;
            }

            render();
            FPS++;

            // Shows number of frames per second:
            if(System.currentTimeMillis() - timerek >= 1000){
                timerek = System.currentTimeMillis();
                //System.out.println("FPS: " + FPS + ", UPS: " + UPS);
                FPS = 0;
                UPS = 0;
            }
            //
        }
        stop();
    }

    private void stop(){
        if(!RUNNING) return;
        RUNNING = false;
        frame.dispose();
        System.exit(0);
    }

    private void update(){
        keyboard.update();
        float speed = 1f;

        if(Keyboard.getKey(KeyEvent.VK_W)){
            y -= speed;
        }

        if(Keyboard.getKey(KeyEvent.VK_S)){
            y += speed;
        }

        if(Keyboard.getKey(KeyEvent.VK_A)){
            x -= speed;
        }

        if(Keyboard.getKey(KeyEvent.VK_D)){
            x += speed;
        }
    }

    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH + 10, HEIGHT + 10);

        screen.clear(0x000000);
        screen.frect(40, 1, 50, 50, 0xff00ff);

        //TU

        screen.renderSprite(x, y, s);

        g.drawImage(screen.getImage(),0,0,WIDTH,HEIGHT,null);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args){
        new Main().start();
    }

}
