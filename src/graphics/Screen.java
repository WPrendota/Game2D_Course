package graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {
    public final int WIDTH;
    public final int HEIGHT;

    private BufferedImage image;
    private int[] pixels;

    public Screen(int w, int h){
        WIDTH = w;
        HEIGHT = h;

        image = new BufferedImage(128, 64, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }

    public void clear(int color){
        for( int i = 0; i < WIDTH*HEIGHT; i++){
            pixels[i] = color;
        }
    }

    public BufferedImage getImage(){
        return image;
    }

    public void renderSprite(int px, int py, Sprite s){
        for(int y = 0; y < s.height;  y++){
            for(int x = 0; x < s.width; x++){
                pixel(px + x, py + y, s.sp.pixels[s.x + x + (s.y + y) * s.sp.WIDTH]);
            }
        }
    }

    public void frect(int px, int py, int w, int h, int color){
        for(int y = 0; y < h;  y++){
            for(int x = 0; x < w; x++){
                pixel(x + px, y + py, color);
            }
        }
    }

    private void pixel(int x, int y, int color){
        if(x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || color == 0xFFFE00FF || color == 0xFF000000) return;

        pixels[x + y * WIDTH] = color;
    }
}
