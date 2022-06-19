/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.util.ArrayList;

/**
 *
 * @author MaulikRaviya
 */
public class PoliceCar extends RoadObject {

    public int id;
    public boolean wantLeft;
    public boolean wantRight;
    public boolean image2;
    //public boolean wantUp;

    public PoliceCar() {
        super(GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT);
        id = GlobalVariables.ID++;
        live = true;
        image = GlobalVariables.spritePolice1;
        image2 = false;
        positionY = GlobalVariables.gameHeight - height;
        positionX = GlobalVariables.myCar.positionX;

    }

    @Override
    public int update() {

        if (positionX < GlobalVariables.myCar.positionX) {
            wantRight = true;
        } else {
            wantRight = false;
        }
        if (positionX > GlobalVariables.myCar.positionX) {
            wantLeft = true;
        } else {
            wantLeft = false;
        }
        if (positionY > GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 10) {

            if (live) {
                positionY -= 3.5f;
            }
        } else {
           // System.out.println((id++) + " BuS..");
        }

        positionY += GlobalVariables.myCar.speed;

        if (live) {

            if (wantRight) {
                boolean allClear = true;

                ArrayList<RoadObject> targetLane = null;
                int point = (int) positionX + width + 2;

                if (point >= GlobalVariables.lane6X) {
                    targetLane = GlobalVariables.lane6Cars;
                } else if (point >= GlobalVariables.lane5X) {
                    targetLane = GlobalVariables.lane5Cars;
                } else if (point >= GlobalVariables.lane4X) {
                    targetLane = GlobalVariables.lane4Cars;
                } else if (point >= GlobalVariables.lane3X) {
                    targetLane = GlobalVariables.lane3Cars;
                } else if (point >= GlobalVariables.lane2X) {
                    targetLane = GlobalVariables.lane2Cars;
                } else {
                    targetLane = GlobalVariables.lane1Cars;
                }

                for (RoadObject ro : targetLane) {
                    if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX - 2 ,
                            (int) positionY + 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + width + 2,
                            (int) positionY + 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX - 2,
                            (int) positionY + height - 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + width + 2,
                            (int) positionY + height - 4)) {
                        allClear = false;
                        break;
                    }
                }

                if (allClear) {
                    positionX++;
                }
            }
            if (wantLeft) {
                boolean allClear = true;

                ArrayList<RoadObject> targetLane = null;
                int point = (int) positionX - 2;

                if (point >= GlobalVariables.lane6X) {
                    targetLane = GlobalVariables.lane6Cars;
                } else if (point >= GlobalVariables.lane5X) {
                    targetLane = GlobalVariables.lane5Cars;
                } else if (point >= GlobalVariables.lane4X) {
                    targetLane = GlobalVariables.lane4Cars;
                } else if (point >= GlobalVariables.lane3X) {
                    targetLane = GlobalVariables.lane3Cars;
                } else if (point >= GlobalVariables.lane2X) {
                    targetLane = GlobalVariables.lane2Cars;
                } else {
                    targetLane = GlobalVariables.lane1Cars;
                }

                for (RoadObject ro : targetLane) {
                    if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX - 2,
                            (int) positionY + 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + width + 2,
                            (int) positionY + 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX -2,
                            (int) positionY + height - 4)) {
                        allClear = false;
                        break;
                    } else if (RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + width +2,
                            (int) positionY + height - 4)) {
                        allClear = false;
                        break;
                    }
                }

                if (allClear) {
                    positionX--;
                }
            }

            if (RoadMaths.checkIns((int) positionX, (int) positionY, width,
                    height, (int) GlobalVariables.myCar.positionX + 4,
                    (int) GlobalVariables.myCar.positionY + 4)) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) (GlobalVariables.myCar.positionY) + 4)) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                live = false;
            } else if (RoadMaths.checkIns((int) positionX, (int) positionY,
                    width, height,
                    (int) (GlobalVariables.myCar.positionX + GlobalVariables.myCar.width - 4),
                    (int) (GlobalVariables.myCar.positionY + GlobalVariables.myCar.height - 4))) {
                live = false;
            }
            if (!live) { //just died...
                //System.out.println("Dead police-car!");

                image = GlobalVariables.spritePolice_dead;

                if (!GlobalVariables.rajniMode) {
                    GlobalVariables.myCar.image = GlobalVariables.spriteMyCar_dead;
                    GameComputer.killTheCar();
                }
            }
        }
// <editor-fold desc="Whether i live or die i will always be there to kill u">
        int point2 = (int) positionX + width, point1 = (int) positionX;
        ArrayList<RoadObject> targetLane1 = null;
        ArrayList<RoadObject> targetLane2 = null;

        if (point1 >= GlobalVariables.lane6X) {
            targetLane1 = GlobalVariables.lane6Cars;
        } else if (point1 >= GlobalVariables.lane5X) {
            targetLane1 = GlobalVariables.lane5Cars;
        } else if (point1 >= GlobalVariables.lane4X) {
            targetLane1 = GlobalVariables.lane4Cars;
        } else if (point1 >= GlobalVariables.lane3X) {
            targetLane1 = GlobalVariables.lane3Cars;
        } else if (point1 >= GlobalVariables.lane2X) {
            targetLane1 = GlobalVariables.lane2Cars;
        } else {
            targetLane1 = GlobalVariables.lane1Cars;
        }

        if (point2 >= GlobalVariables.lane6X) {
            targetLane2 = GlobalVariables.lane6Cars;
        } else if (point2 >= GlobalVariables.lane5X) {
            targetLane2 = GlobalVariables.lane5Cars;
        } else if (point2 >= GlobalVariables.lane4X) {
            targetLane2 = GlobalVariables.lane4Cars;
        } else if (point2 >= GlobalVariables.lane3X) {
            targetLane2 = GlobalVariables.lane3Cars;
        } else if (point2 >= GlobalVariables.lane2X) {
            targetLane2 = GlobalVariables.lane2Cars;
        } else {
            targetLane2 = GlobalVariables.lane1Cars;
        }

        for (RoadObject ro : targetLane1) {
            boolean collision = false;
            
            if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + 4,
                            (int) positionY + 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX +width- 4,
                            (int) positionY + 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + 4,
                            (int) positionY +height- 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX +width- 4,
                            (int) positionY +height- 4)){
                collision = true;
            }
            
            if (collision) {
                if (live) {
                    live = false;
                    speed = 0;
                    image = GlobalVariables.spritePolice_dead;
                }
                ro.live = false;
                ro.speed = 0;
                ro.image = ro.deathImage;
                switch (ro.lane) {
                    case 1:
                        GlobalVariables.lane1Panoti = ro;
                        break;
                    case 2:
                        GlobalVariables.lane2Panoti = ro;
                        break;
                    case 3:
                        GlobalVariables.lane3Panoti = ro;
                        break;
                    case 4:
                        if (GlobalVariables.lane4Panoti == null) {
                            GlobalVariables.lane4Panoti = ro;
                        }
                        break;
                    case 5:
                        if (GlobalVariables.lane5Panoti == null) {
                            GlobalVariables.lane5Panoti = ro;
                        }
                        break;
                    case 6:
                        if (GlobalVariables.lane6Panoti == null) {
                            GlobalVariables.lane6Panoti = ro;
                        }
                        break;
                }
            }
        }

        for (RoadObject ro : targetLane2) {
            
            boolean collision = false;
            
            if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + 4,
                            (int) positionY + 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX +width- 4,
                            (int) positionY + 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX + 4,
                            (int) positionY +height- 4)){
                collision = true;
            }
            else if(RoadMaths.checkIns((int) ro.positionX,
                            (int) ro.positionY,
                            ro.width,
                            ro.height, (int) positionX +width- 4,
                            (int) positionY +height- 4)){
                collision = true;
            }
            
            
            if (collision) {
                if (live) {
                    live = false;
                    speed = 0;
                    image = GlobalVariables.spritePolice_dead;
                }
                ro.live = false;
                ro.speed = 0;
                ro.image = ro.deathImage;
                switch (ro.lane) {
                    case 1:
                        GlobalVariables.lane1Panoti = ro;
                        break;
                    case 2:
                        GlobalVariables.lane2Panoti = ro;
                        break;
                    case 3:
                        GlobalVariables.lane3Panoti = ro;
                        break;
                    case 4:
                        if (GlobalVariables.lane4Panoti == null) {
                            GlobalVariables.lane4Panoti = ro;
                        }
                        break;
                    case 5:
                        if (GlobalVariables.lane5Panoti == null) {
                            GlobalVariables.lane5Panoti = ro;
                        }
                        break;
                    case 6:
                        if (GlobalVariables.lane6Panoti == null) {
                            GlobalVariables.lane6Panoti = ro;
                        }
                        break;
                }
            }
        }
//</editor-fold>        

        if (positionY > (GlobalVariables.gameHeight + GlobalVariables.CAR_HEIGHT)) {
            //System.out.println("Destroyed police-car!");
            return 1;
        }
        return 0;
    }
}
