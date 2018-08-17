package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spritesheet {
    // Table of images, which are cut during rendering process.

    public static final Spritesheet  def1 = new Spritesheet("C:\\Users\\Witek\\IdeaProjects\\Game\\res\\spritsheet.png");
    public static final Spritesheet  bg_menu = new Spritesheet("C:\\Users\\Witek\\IdeaProjects\\Game\\res\\bg_menu.png");
    //public static final Spritesheet  def1 = new Spritesheet("res/spritsheet.png");

    public int WIDTH, HEIGHT;
    public int[] pixels;

    public Spritesheet(String path){
        try{
            BufferedImage image = ImageIO.read(new File(path));
            //BufferedImage image = ImageIO.read(getClass().getResourceAsStream(path));
            WIDTH = image.getWidth();
            HEIGHT = image.getHeight();
            pixels = new int[WIDTH*HEIGHT];

            image.getRGB(0,0,WIDTH,HEIGHT,pixels,0, WIDTH);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
