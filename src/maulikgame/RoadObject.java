package maulikgame;

import java.awt.Image;

/**
 *
 * @author MaulikRaviya
 */
public abstract class RoadObject {
    public float positionX, positionY;
    public int height, width;
    public Image image ;
    public float speed;
    public int type;
    public boolean live;
    public Image deathImage;
    public int lane;
    public RoadObject(int width, int height){
        this.height = height;
        this.width = width;
    }
    
    public abstract int update();
}
