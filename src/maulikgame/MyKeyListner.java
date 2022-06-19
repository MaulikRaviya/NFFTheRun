package maulikgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author MaulikRaviya
 */
class MyKeyListner implements KeyListener {

    public MyKeyListner() {

    }

    private int keyCode = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(""+e.getKeyCode());
        try{
        keyCode = e.getKeyCode();
        GlobalVariables.keysPressed[keyCode] = true;
        if (keyCode == KeyEvent.VK_R) {
            if (GlobalVariables.keysPressed[KeyEvent.VK_C] && GlobalVariables.keysPressed[KeyEvent.VK_ALT] && GlobalVariables.keysPressed[KeyEvent.VK_CONTROL]) {
                if(GlobalVariables.rajniMode) GlobalVariables.rajniMode = false;
                else{
                    GlobalVariables.rajniMode = true;
                    GlobalVariables.cheated = true;
                }
            }
        }
        else if (keyCode == KeyEvent.VK_I) {
            if (GlobalVariables.keysPressed[KeyEvent.VK_C] && GlobalVariables.keysPressed[KeyEvent.VK_ALT] && GlobalVariables.keysPressed[KeyEvent.VK_CONTROL]) {
                if(GlobalVariables.infinityMilage) GlobalVariables.infinityMilage = false;
                else{
                    GlobalVariables.infinityMilage = true;
                    GlobalVariables.cheated = true;
                }
            }
        }
        }catch(ArrayIndexOutOfBoundsException ex){
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GlobalVariables.keysPressed[e.getKeyCode()] = false;
    }

}
