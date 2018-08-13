package graphics;

public class Sprite {
    // Enable easy access to an image in Spritescheet ('x' - number of image horizontally, 'y' - number of image vertically)
    public int x,y,size;
    public Spritesheet sp;

    public Sprite(int x, int y, int size, Spritesheet sp){
        this.x = x;
        this.y = y;
        this.sp = sp;
        this.size = size;
    }
}
