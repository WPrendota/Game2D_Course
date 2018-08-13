package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static final int count = 200;
    private static boolean keys[] = new boolean[count];
    private static boolean keys_prev[] = new boolean[count];

    public Keyboard(){
        for(int i=0;i<count;i++){
            keys[i] = false;
        }
        for(int i=0;i<count;i++){
            keys_prev[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void update(){
        for(int i=0;i<count;i++){
            if(!keys[i])
                keys_prev[i] = false;
        }
    }

    public static boolean getKey(int Key){
        return keys[Key];
    }

    public static boolean getKeyOnce(int Key){
        if(!keys_prev[Key] && keys[Key]) {
            keys_prev[Key] = true;
            return true;
        }

        return false;
    }

    public static void getKeyTyped(KeyEvent arg0){

    }
}
