/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

/**
 *
 * @author MaulikRaviya
 */
public class FuelTank extends RoadObject {

    /*
     public float positionX, positionY;
     public int height, width;
     public Image image ;
     public float speed;
     public int type;
     public boolean live;
     */
    int inverseMilage;
    public FuelTank(int type) {
        super(40, 60);
        positionX = GlobalVariables.crazy.nextInt(GlobalVariables.roadWidth - 40) + GlobalVariables.roadStartX;
        positionY = 0 - width;
        if (type == 1) {
            image = GlobalVariables.spriteFual1;
            inverseMilage = 15;
        } else {
            image = GlobalVariables.spriteFual2;
            inverseMilage = 5;
        }
        speed = 0;
    }

    @Override
    public int update() {
        positionY += GlobalVariables.myCar.speed;
        if (GlobalVariables.myCar.live) {
            boolean flag = false;
            if (RoadMaths.checkIns((int) positionX, (int) positionY, width,
                    height, (int) GlobalVariables.myCar.positionX + 4,
                    (int) GlobalVariables.myCar.positionY + 4)) {
                flag = true;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) GlobalVariables.myCar.positionY + 4)) {
                flag = true;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                flag = true;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                flag = true;
            }
            
            if(flag){
                GlobalVariables.fual = 1000;
                GlobalVariables.inverseMilage = inverseMilage;
                return 1;
            }
        }
        
        if(positionY > GlobalVariables.gameHeight){
            return 1;
        }
        return 0;
    }

}
