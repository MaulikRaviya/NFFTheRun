
package maulikgame;

import java.io.IOException;

/**
 *
 * @author MaulikRaviya
 */
public class Main {
    public static void main(String args[]) throws IOException{
        GlobalVariables.initilizeAll();
        GameStart game = new GameStart();
        GlobalVariables.gameStart = game;
        
    }
}
