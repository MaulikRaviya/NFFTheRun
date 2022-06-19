/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MaulikRaviya
 */
class GameComputer {                    //15, 5

    private static long refualTimes[] = {20000000000L, 30000000000L,
        55000000000L, 90000000000L, 190000000000L};
    //3, 2, 1, 2, 1
    //120 * 6 *1 = 720 ~ 1000
    //(420) *6 *2 = 5040 + 720 = 5720 ~ 5000
    //(600) *18 = 10800 + 5040 = 15840 ~ 15000
    //(900) *24 = 21600 + 15840 = 37000

    private static int refualType[] = {1, 1, 1, 2, 2};
//    private static int levelChange[] = {1000, 5000, 15000, 37000};
    private static int levelChange[] = {1000, 5000, 15000, 35000};

    private static long l1Ns = System.nanoTime();
    private static long l2Ns = l1Ns;
    private static long l3Ns = l1Ns;
    private static long l4Ns = l1Ns;
    private static long l5Ns = l1Ns;
    private static long l6Ns = l1Ns;

    private static long cdNs = 0L;

    private static long pLight = System.nanoTime();
    private static long pTimer = System.nanoTime();

    private static long pTimes[] = {0, 0, 240000000000L, 150000000000L, 90000000000L};

    private static RoadObject ro = null;
    private static int result = 0;
    private static int countDown = -1;
    private static long fualCD = System.nanoTime();
    private static long refualCD = System.nanoTime();

    static void update() {

        if (countDown >= -1) {
            if (System.nanoTime() - cdNs >= 1000000000L) {
                if (countDown == -1) {
                    countDown = -99;
                    GlobalVariables.hasOnScreenText = false;
                } else if (countDown == 0) {
                        GlobalVariables.roadObjects.clear();
                        GlobalVariables.lane1Cars.clear();
                        GlobalVariables.lane2Cars.clear();
                        GlobalVariables.lane3Cars.clear();
                        GlobalVariables.lane4Cars.clear();
                        GlobalVariables.lane5Cars.clear();
                        GlobalVariables.lane6Cars.clear();

                        GlobalVariables.lane1Panoti = null;
                        GlobalVariables.lane2Panoti = null;
                        GlobalVariables.lane3Panoti = null;
                        GlobalVariables.lane4Panoti = null;
                        GlobalVariables.lane5Panoti = null;
                        GlobalVariables.lane6Panoti = null;

                        GlobalVariables.myCar.live = true;
                        GlobalVariables.myCar.image = GlobalVariables.spriteMyCar;
                        GlobalVariables.myCar.positionY = GlobalVariables.gameHeight - 2 * GlobalVariables.myCar.height;
                        GlobalVariables.myCar.positionX = GlobalVariables.lane3X;
                        GlobalVariables.myCar.speed = 3;
                        GlobalVariables.fual = 1000;
                        GlobalVariables.policeCar = null;
                        
                        pTimer = fualCD = refualCD = l1Ns = l2Ns = l3Ns = l4Ns = l5Ns = l6Ns = System.nanoTime();
                    
                    GlobalVariables.screenBlur = false;
                }

                if (GlobalVariables.life == 3) {
                    if (countDown == 0) {
                        GlobalVariables.onScreenText = "GO!";
                    } else {
                        GlobalVariables.onScreenText = "" + countDown;
                    }
                } else {
                    GlobalVariables.onScreenText = "" + GlobalVariables.life + " life left!";

                }
                countDown--;

                cdNs = System.nanoTime();

            }
            if (GlobalVariables.life == 3) {
                return;
            }
        }

        if (System.nanoTime() - fualCD > 1000000000L) {
            if (!GlobalVariables.infinityMilage) {
                if (GlobalVariables.myCar.live) {
                    GlobalVariables.fual -= GlobalVariables.inverseMilage;
                }
            }

            if (GlobalVariables.fual <= 0) {
                if (GlobalVariables.myCar.live) {
                    killTheCar();
                }
            }
            fualCD = System.nanoTime();
        }

        if (System.nanoTime() - refualCD > refualTimes[ (GlobalVariables.level - 1)]) {
            GlobalVariables.fuelObject = new FuelTank(
                    refualType[ (GlobalVariables.level - 1)]);
            refualCD = System.nanoTime();
        }

        if (GlobalVariables.level >= 3) {
            if (System.nanoTime() - pTimer >= pTimes[GlobalVariables.level - 1]) {
                if(GlobalVariables.policeCar==null) GlobalVariables.policeCar = new PoliceCar();
                pTimer = System.nanoTime();
            }
        }

        if (System.nanoTime() - l1Ns > 3500000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane1Cars.add(new UpCar(GlobalVariables.lane1X,
                        1f, 1));
            }
            l1Ns = System.nanoTime();
        }
        if (System.nanoTime() - l2Ns > 2500000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane2Cars.add(new UpCar(GlobalVariables.lane2X,
                        1.5f, 2));
            }
            l2Ns = System.nanoTime();
        }
        if (System.nanoTime() - l3Ns > 2000000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane3Cars.add(new UpCar(GlobalVariables.lane3X,
                        2f, 3));
            }
            l3Ns = System.nanoTime();
        }
        if (System.nanoTime() - l4Ns > 2000000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane4Cars.add(
                        new DownCar(GlobalVariables.lane4X, 2f, 4));
            }
            l4Ns = System.nanoTime();
        }
        if (System.nanoTime() - l5Ns > 1000000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane5Cars.add(
                        new DownCar(GlobalVariables.lane5X, 1.5f, 5));
            }
            l5Ns = System.nanoTime();
        }
        if (System.nanoTime() - l6Ns > 2500000000L) {
            if (GlobalVariables.crazy.nextInt(100) % (7 - GlobalVariables.level) == 0) {
                GlobalVariables.lane6Cars.add(
                        new DownCar(GlobalVariables.lane6X, 1f, 6));
            }
            l6Ns = System.nanoTime();
        }

        //update all
        for (int i = 0; i < GlobalVariables.lane1Cars.size(); i++) {
            ro = GlobalVariables.lane1Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane1Cars.remove(i);
            }
        }
        for (int i = 0; i < GlobalVariables.lane2Cars.size(); i++) {
            ro = GlobalVariables.lane2Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane2Cars.remove(i);
            }
        }
        for (int i = 0; i < GlobalVariables.lane3Cars.size(); i++) {
            ro = GlobalVariables.lane3Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane3Cars.remove(i);
            }
        }
        for (int i = 0; i < GlobalVariables.lane4Cars.size(); i++) {
            ro = GlobalVariables.lane4Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane4Cars.remove(i);
            }
        }
        for (int i = 0; i < GlobalVariables.lane5Cars.size(); i++) {
            ro = GlobalVariables.lane5Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane5Cars.remove(i);
            }
        }
        for (int i = 0; i < GlobalVariables.lane6Cars.size(); i++) {
            ro = GlobalVariables.lane6Cars.get(i);
            result = ro.update();
            if (result == 1) {
                GlobalVariables.lane6Cars.remove(i);
            }
        }

        //terror of panoti
        for (int i = 0; i < GlobalVariables.lane1Cars.size(); i++) {
            ro = GlobalVariables.lane1Cars.get(i);

            if (ro.live && GlobalVariables.lane1Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane1Panoti.positionY + GlobalVariables.lane1Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane1Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((UpCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteUpCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteUpCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteUpCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteUpCar4_dead;
                            break;
                    }
                    GlobalVariables.lane1Panoti = ro;
                }
            }

        }

        for (int i = 0; i < GlobalVariables.lane2Cars.size(); i++) {
            ro = GlobalVariables.lane2Cars.get(i);

            if (ro.live && GlobalVariables.lane2Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane2Panoti.positionY + GlobalVariables.lane2Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane2Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((UpCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteUpCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteUpCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteUpCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteUpCar4_dead;
                            break;
                    }
                    GlobalVariables.lane2Panoti = ro;
                }
            }

        }

        for (int i = 0; i < GlobalVariables.lane3Cars.size(); i++) {
            ro = GlobalVariables.lane3Cars.get(i);

            if (ro.live && GlobalVariables.lane3Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane3Panoti.positionY + GlobalVariables.lane3Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane3Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((UpCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteUpCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteUpCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteUpCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteUpCar4_dead;
                            break;
                    }
                    GlobalVariables.lane3Panoti = ro;
                }
            }

        }

        for (int i = 0; i < GlobalVariables.lane4Cars.size(); i++) {
            ro = GlobalVariables.lane4Cars.get(i);

            if (ro.live && GlobalVariables.lane4Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane4Panoti.positionY + GlobalVariables.lane4Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane4Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((DownCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteDownCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteDownCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteDownCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteDownCar4_dead;
                            break;
                    }
                    GlobalVariables.lane4Panoti = ro;
                }
            }

        }

        for (int i = 0; i < GlobalVariables.lane5Cars.size(); i++) {
            ro = GlobalVariables.lane5Cars.get(i);

            if (ro.live && GlobalVariables.lane5Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane5Panoti.positionY + GlobalVariables.lane5Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane5Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((DownCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteDownCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteDownCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteDownCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteDownCar4_dead;
                            break;
                    }
                    GlobalVariables.lane5Panoti = ro;
                }
            }

        }

        for (int i = 0; i < GlobalVariables.lane6Cars.size(); i++) {
            ro = GlobalVariables.lane6Cars.get(i);

            if (ro.live && GlobalVariables.lane6Panoti != null) {
                if ((ro.positionY - 4) < (GlobalVariables.lane6Panoti.positionY + GlobalVariables.lane6Panoti.height) && (ro.positionY + ro.height - 4) > (GlobalVariables.lane6Panoti.positionY)) {
                    ro.live = false;
                    ro.speed = 0;
                    switch (((DownCar) ro).spriteID) {
                        case 1:
                            ro.image = GlobalVariables.spriteDownCar1_dead;
                            break;
                        case 2:
                            ro.image = GlobalVariables.spriteDownCar2_dead;
                            break;
                        case 3:
                            ro.image = GlobalVariables.spriteDownCar3_dead;
                            break;
                        case 4:
                            ro.image = GlobalVariables.spriteDownCar4_dead;
                            break;
                    }
                    GlobalVariables.lane6Panoti = ro;
                }
            }

        }
        if (GlobalVariables.fuelObject != null) {
            result = GlobalVariables.fuelObject.update();
            if (result == 1) {
                GlobalVariables.fuelObject = null;
            }
        }
        if (GlobalVariables.policeCar != null) {
            if (GlobalVariables.policeCar.live) {
                if (System.nanoTime() - pLight >= 250000000L) {
                    if (GlobalVariables.policeCar.image2) {
                        GlobalVariables.policeCar.image = GlobalVariables.spritePolice1;
                        GlobalVariables.policeCar.image2 = false;
                    } else {
                        GlobalVariables.policeCar.image = GlobalVariables.spritePolice2;
                        GlobalVariables.policeCar.image2 = true;
                    }
                    pLight = System.nanoTime();
                }
            }
            //System.out.println("Detailes:");
            //System.out.println(GlobalVariables.policeCar +" "+GlobalVariables.policeCar.image);
            result = GlobalVariables.policeCar.update();
            if (result == 1) {
//                System.out.println("Got 1");
//                System.out.println(
//                        "x:" + GlobalVariables.policeCar.positionY + ", " + GlobalVariables.gameHeight);
//                System.out.println("y:" + GlobalVariables.policeCar.positionX);

                GlobalVariables.policeCar = null;
            }
        }
        if (GlobalVariables.level != 5) {
            if (GlobalVariables.score >= levelChange[ GlobalVariables.level - 1]) {
                GlobalVariables.level++;
            }
        }
        GlobalVariables.myCar.update();
        GlobalVariables.roadStartY = (GlobalVariables.roadStartY + (int) GlobalVariables.myCar.speed) % GlobalVariables.roadTexture.getHeight(
                null);
        //if(GlobalVariables)
        //System.out.println("roadStartY: "+  GlobalVariables.roadStartY);

    }

    static void flush() {
        if (GlobalVariables.roadObjects != null) {
            GlobalVariables.roadObjects.clear();
        }
        if (GlobalVariables.lane1Cars != null) {
            GlobalVariables.lane1Cars.clear();
        }
        if (GlobalVariables.lane2Cars != null) {
            GlobalVariables.lane2Cars.clear();
        }
        if (GlobalVariables.lane3Cars != null) {
            GlobalVariables.lane3Cars.clear();
        }
        if (GlobalVariables.lane4Cars != null) {
            GlobalVariables.lane4Cars.clear();
        }
        if (GlobalVariables.lane5Cars != null) {
            GlobalVariables.lane5Cars.clear();
        }
        if (GlobalVariables.lane6Cars != null) {
            GlobalVariables.lane6Cars.clear();
        }
        if (GlobalVariables.myCar != null) {
            GlobalVariables.myCar = null;
        }

        GlobalVariables.lane1Panoti = null;
        GlobalVariables.lane2Panoti = null;
        GlobalVariables.lane3Panoti = null;
        GlobalVariables.lane4Panoti = null;
        GlobalVariables.lane5Panoti = null;
        GlobalVariables.lane6Panoti = null;
        
        GlobalVariables.policeCar = null;

        GlobalVariables.roadObjects = new ArrayList();
        GlobalVariables.lane1Cars = new ArrayList();
        GlobalVariables.lane2Cars = new ArrayList();
        GlobalVariables.lane3Cars = new ArrayList();
        GlobalVariables.lane4Cars = new ArrayList();
        GlobalVariables.lane5Cars = new ArrayList();
        GlobalVariables.lane6Cars = new ArrayList();
        GlobalVariables.myCar = new MyCar(GlobalVariables.lane3X, 3);

        GlobalVariables.score = 0;
        GlobalVariables.fual = 1000;
        GlobalVariables.life = 3;

        countDown = 3;
        GlobalVariables.hasOnScreenText = true;
        GlobalVariables.screenBlur = true;
        if (GlobalVariables.myCar.live && GlobalVariables.fual <= 0) {
            killTheCar();
        }
        cdNs = System.nanoTime();

    }

    public static String lifeString() {
        String lifeString = "Life: ";
        for (int i = 1; i <= GlobalVariables.life; i++) {
            lifeString += " *";
        }
        return lifeString;
    }

    static void killTheCar() {
        if (GlobalVariables.myCar.live) {
            GlobalVariables.myCar.speed = 0;
            GlobalVariables.myCar.live = false;

            GlobalVariables.life--;

            if (GlobalVariables.life > 0) {
                if (GlobalVariables.roadObjects != null) {

                    countDown = 3;

                    GlobalVariables.screenBlur = true;
                    GlobalVariables.hasOnScreenText = true;
                }
            } else {
                try {
                    GlobalVariables.onScreenText = "GAME OVER!";
                    GlobalVariables.screenBlur = true;
                    GlobalVariables.hasOnScreenText = true;

                    GlobalVariables.highScoreHandler.whatAboutThis(
                            (int) GlobalVariables.score);

                } catch (IOException ex) {
//                    System.out.println(ex);
                }
            }
        }
    }

    static void resume() {
        GlobalVariables.gameControlPane.pauseButton.setText("Pause");
        GlobalVariables.screenBlur = false;
        GlobalVariables.hasOnScreenText = false;

        long elapsedTime = System.nanoTime() - GlobalVariables.pausedTime;
        l1Ns += elapsedTime;
        l2Ns += elapsedTime;
        l3Ns += elapsedTime;
        l4Ns += elapsedTime;
        l5Ns += elapsedTime;
        cdNs += elapsedTime;
        fualCD += elapsedTime;
        refualCD += elapsedTime;
        pTimer += elapsedTime;
        GlobalVariables.paused = false;
    }

    static void pause() {
        if (GlobalVariables.gameStart.running && GlobalVariables.myCar.live) {
            GlobalVariables.gameControlPane.pauseButton.setText("Resume");

            GlobalVariables.onScreenText = "Paused";
            GlobalVariables.screenBlur = true;
            GlobalVariables.hasOnScreenText = true;
            GlobalVariables.paused = true;
            GlobalVariables.pausedTime = System.nanoTime();
        }
    }
}
