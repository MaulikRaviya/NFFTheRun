/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maulikgame;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MaulikRaviya
 */
class ScorePanel extends JPanel {
    JLabel rockStarLabel;
    JLabel scoreLabel;
    
    
    public ScorePanel(String rockStar, int score){
        GridLayout gL = new GridLayout(1,2);
        //gL.setVgap(10);
        this.setLayout(gL);
        
        setBackground(new Color(255,255,255));
        
        rockStarLabel = new JLabel(rockStar);
        scoreLabel = new JLabel(""+score+". ");
        add(rockStarLabel);
        scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(scoreLabel);
    }
}
