/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author MaulikRaviya
 */
public class ImagePainter {

    static int i = 0, j = 0, x = 0;
    static RoadObject ro;
    static Graphics g2;
    static File img;

    static Font onScreenTextFont = new Font("Arial", Font.BOLD | Font.ITALIC, 36);
    static Font scoreFont = new Font("Arial", Font.BOLD, 20);
    static Font cheatFont = new Font("Arial", Font.PLAIN, 14);

    static Color fualColor5 = new Color(0, 255, 0);
    static Color fualColor4 = new Color(0, 250, 0);
    static Color fualColor3 = new Color(50, 200, 0);
    static Color fualColor2 = new Color(100, 150, 0);
    static Color fualColor1 = new Color(200, 50, 0);
    static Color fualColor0 = new Color(250, 0, 0);
    static int fualIndicator;
    static int fualIndicatorWidth = GlobalVariables.roadStartX - 20;
    static Color fualColors[] = {fualColor0, fualColor1, fualColor2, fualColor3,
        fualColor4, fualColor5};
    // static int dx1, dx2, sx1=0, sx2=0, sy1, sy2, dy1, dy2;
    
    static BufferedImage image2 =new BufferedImage(GlobalVariables.gameWidth , GlobalVariables.gameHeight, BufferedImage.TYPE_INT_RGB);;

    public static BufferedImage paint(/*BufferedImage image*/) {
        //image2 = new BufferedImage(GlobalVariables.gameWidth , GlobalVariables.gameHeight, BufferedImage.TYPE_INT_RGB);
        g2 = image2.getGraphics();
        
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, GlobalVariables.gameWidth, GlobalVariables.gameHeight);
        
        //g2.setColor(Color.GRAY);
        //GlobalVariables.roadTexture.getHeight(null)
        for (int j = GlobalVariables.roadStartY - GlobalVariables.roadTexture.getHeight(
                null); j <= GlobalVariables.gameHeight;
                j += GlobalVariables.roadTexture.getHeight(null)) {
            g2.drawImage(GlobalVariables.roadTexture, GlobalVariables.roadStartX,
                    j, null);
        }

        if (GlobalVariables.fuelObject != null) {
            g2.drawImage(GlobalVariables.fuelObject.image,
                    (int) GlobalVariables.fuelObject.positionX,
                    (int) GlobalVariables.fuelObject.positionY, null);
        }

        

        for (int i = 0; i < GlobalVariables.lane1Cars.size(); i++) {
            ro = GlobalVariables.lane1Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        for (int i = 0; i < GlobalVariables.lane2Cars.size(); i++) {
            ro = GlobalVariables.lane2Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        for (int i = 0; i < GlobalVariables.lane3Cars.size(); i++) {
            ro = GlobalVariables.lane3Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        for (int i = 0; i < GlobalVariables.lane4Cars.size(); i++) {
            ro = GlobalVariables.lane4Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        for (int i = 0; i < GlobalVariables.lane5Cars.size(); i++) {
            ro = GlobalVariables.lane5Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        for (int i = 0; i < GlobalVariables.lane6Cars.size(); i++) {
            ro = GlobalVariables.lane6Cars.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }

        g2.drawImage(GlobalVariables.myCar.image,
                (int) GlobalVariables.myCar.positionX,
                (int) GlobalVariables.myCar.positionY, null);

        for (int i = 0; i < GlobalVariables.roadObjects.size(); i++) {
            ro = GlobalVariables.roadObjects.get(i);
            //System.out.println(i + " redered");
            try {
                g2.drawImage(ro.image, (int) ro.positionX, (int) ro.positionY,
                        null);
            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("dont worry");
            }
        }
        if (GlobalVariables.policeCar != null) {
            g2.drawImage(GlobalVariables.policeCar.image,
                    (int)GlobalVariables.policeCar.positionX,
                    (int)GlobalVariables.policeCar.positionY, null);
        }
        g2.setFont(scoreFont);
        g2.setColor(Color.ORANGE);

        g2.drawString("Score: " + (int) GlobalVariables.score, 10, 30);

        g2.setColor(Color.YELLOW);
        g2.drawString(GameComputer.lifeString(), 10, 60);

        fualIndicator = GlobalVariables.fual / 200;
        g2.setColor(fualColors[fualIndicator]);
        g2.drawString("Fuel: ", 10, 120);
        g2.drawRect(10, 130, fualIndicatorWidth, 20);
        g2.fillRect(10, 130, fualIndicatorWidth * GlobalVariables.fual / 1000,
                20);

        g2.setColor(Color.WHITE);
        g2.drawString("Level: " + GlobalVariables.level, 10, 180);

        if (GlobalVariables.rajniMode) {
            g2.setFont(cheatFont);
            g2.setColor(Color.MAGENTA);
            g2.drawString("Rajnikanth mode: ON", 10, 240);
        }

        if (GlobalVariables.infinityMilage) {
            g2.setFont(cheatFont);
            g2.setColor(Color.MAGENTA);
            g2.drawString("InfinityMilageMode: ON", 10, 260);
        }

        if (GlobalVariables.screenBlur) {
            g2.setColor(new Color(0f, 0f, 0f, .5f));
            g2.fillRect(0, 0, GlobalVariables.gameWidth,
                    GlobalVariables.gameHeight);
        }
        if (GlobalVariables.hasOnScreenText) {
            g2.setColor(Color.YELLOW);
            g2.setFont(onScreenTextFont);
            g2.drawString(GlobalVariables.onScreenText,
                    GlobalVariables.gameWidth / 2,
                    GlobalVariables.gameHeight / 2);
        }

        //g2.drawString(GlobalVariables.onScreenText, GlobalVariables.gameWidth/2, GlobalVariables.gameHeight/2);
        g2.dispose();
        return image2;
    }

    public static void flush() {
        i = j = x = 0;
        ro = null;
        g2.dispose();
        g2 = null;
        img = null;
    }
}
