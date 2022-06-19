package maulikgame;

import java.awt.event.KeyEvent;

/**
 *
 * @author MaulikRaviya
 */
public class MyCar extends RoadObject {

    public boolean live;

    MyCar(int positionX, float speed) {
        super(GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT);
        positionY = GlobalVariables.gameHeight - height - height;
        this.positionX = positionX;
        this.speed = speed;
        image = GlobalVariables.spriteMyCar;

        live = true;
    }

    @Override
    public int update() {
        //positionY -= speed;
        if (live) {
            if (GlobalVariables.keysPressed[KeyEvent.VK_UP]) {
                positionY -= 3;
                if(positionY + width + 40 < 0){
                    GameComputer.killTheCar();
                }
                // System.out.println("up");
            }
            if (GlobalVariables.keysPressed[KeyEvent.VK_DOWN]) {
                positionY += 3;
                if(positionY > GlobalVariables.gameHeight - 5){
                    GameComputer.killTheCar();
                }
            }
            if (GlobalVariables.keysPressed[KeyEvent.VK_LEFT]) {
                if( (positionX-3)>(GlobalVariables.roadStartX-5) ) positionX -= 3;
            }
            if (GlobalVariables.keysPressed[KeyEvent.VK_RIGHT]) {
                if( (positionX+width+3)<(GlobalVariables.roadStartX+GlobalVariables.roadWidth+15) ) positionX += 3;
            }
            GlobalVariables.score += 0.1 * GlobalVariables.level;
            
            
        }
        return 0;
    }

}
