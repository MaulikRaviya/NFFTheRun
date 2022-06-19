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
class RoadMaths {

    static boolean checkIns(int positionX, int positionY, int width, int height, int targetX, int targetY) {
        if(targetX>positionX && targetX<(positionX+width) && targetY>positionY && targetY<(positionY+height) ) return true;
        return false;        
    }
    
}
