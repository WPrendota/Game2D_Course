package core.core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.Screen;
import input.Keyboard;

import java.awt.event.KeyEvent;

public class GS_Menu extends GameState{
    public GS_Menu(){

    }

    public void update(){
        if(Keyboard.getKey(KeyEvent.VK_ENTER)){
            GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME);
        }
    }

    public void render(Screen s){
        s.clear(0x00ff00);
    }
}
