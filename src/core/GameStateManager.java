package core;

import core.core.gamestates.GS_Game;
import core.core.gamestates.GS_Menu;
import graphics.Screen;

public class GameStateManager {

    private static final int GAME_STATE_MENU = 0;
    public static final int GAME_STATE_GAME = 1;


    private static GameState gs;

    public static void ChangeGameState(int ID){
        if(ID == GAME_STATE_MENU){
            gs = new GS_Menu();
        }

        if(ID == GAME_STATE_GAME){
            gs = new GS_Game();
        }
    }

    public GameStateManager(){
        ChangeGameState(GAME_STATE_MENU);
    }

    public void update(){
        gs.update();
    }

    public void render(Screen s){
        gs.render(s);
    }
}
