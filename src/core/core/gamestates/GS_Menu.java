package core.core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import input.Keyboard;

import java.awt.event.KeyEvent;

public class GS_Menu extends GameState{

    public static final Sprite s_logo = new Sprite(0, 80, 64, 32, Spritesheet.def1);
    public static final Sprite s_newGame = new Sprite(0, 16, 64, 16, Spritesheet.def1);
    public static final Sprite s_continue = new Sprite(0, 32, 64, 16, Spritesheet.def1);
    public static final Sprite s_credits = new Sprite(0, 48, 64, 16, Spritesheet.def1);
    public static final Sprite s_exit = new Sprite(0, 64, 32, 16, Spritesheet.def1);
    public static final Sprite s_pointer = new Sprite(16, 0, 16, 16, Spritesheet.def1);
    public static final Sprite s_bg = new Sprite(0, 0, Spritesheet.bg_menu.WIDTH, Spritesheet.bg_menu.HEIGHT, Spritesheet.bg_menu);

    private int choose = 0;
    private float pointerPosition = 0;

    public GS_Menu(){

    }

    public void update(){
        if(Keyboard.getKey(KeyEvent.VK_ENTER)){
            if(choose == 0){
                GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME);
            }
            if(choose == 3){
                GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_EXIT);
            }
        }

        if(Keyboard.getKeyOnce(KeyEvent.VK_DOWN)){
            choose++;
        }

        if(Keyboard.getKeyOnce(KeyEvent.VK_UP)){
            choose--;
        }

        if(choose > 3){
            choose = 0;
        }

        if(choose < 0){
            choose = 3;
        }

        if(choose == 0){
            setPointer(0); // New Game
        }
        if(choose == 1){
            setPointer(16);  // Continue
        }
        if(choose == 2){
            setPointer(32);  // Credits
        }
        if(choose == 3){
            setPointer(48);  // Exit
        }
    }

    private void setPointer(int i) {
        pointerPosition += (i - pointerPosition);
    }

    public void render(Screen s){
        s.clear(0x000000);
        
        s.renderSprite(0,0, s_bg);
        s.renderSprite(65,0, s_logo);
        s.renderSprite(0,0, s_newGame);
        s.renderSprite(0,16, s_continue);
        s.renderSprite(0,32, s_credits);
        s.renderSprite(0,48, s_exit);
        s.renderSprite(0,(int)pointerPosition, s_pointer);
    }
}
