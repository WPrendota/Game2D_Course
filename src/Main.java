import javax.swing.*;
import java.awt.*;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable{
    public static final String TITLE = "Moja gra platformowa";
    public static final int WIDTH = 800, HEIGHT = 600;

    private boolean RUNNING = false;
    private JFrame frame;

    public Main(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this, new BorderLayout().CENTER);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void start(){
        if(RUNNING) return;
        RUNNING = true;

        new Thread(this, "Game " + TITLE).start();
    }


    @Override
    public void run() {
        while(RUNNING){
            update();
            render();
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
        System.out.println("Petla");
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

        g.dispose();
        bs.show();
    }

    public static void main(String[] args){
        new Main().start();
    }

}
