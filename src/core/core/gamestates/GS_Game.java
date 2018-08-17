package core.core.gamestates;

import core.GameState;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;

import java.awt.event.KeyEvent;

public class GS_Game extends GameState{

    int x = 40,y = 40;

    public static final Sprite s = new Sprite(0,0,16, Spritesheet.def1);

    public GS_Game(){

    }

    public void update(){
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

    public void render(Screen s){
        s.clear(0x0000ff);

        s.renderSprite((int)x, (int)y, this.s);
    }
}
