/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MaulikRaviya
 */
class AskingPanel extends JPanel implements ActionListener {

    
    JLabel scoreLabel;
    JButton ok;
    JTextField rockStarInput;
    int j;

    public AskingPanel(int score, int j) {
        this.j = j;
        
        setBackground(new Color(255, 255, 255));
        
        GridLayout gL = new GridLayout(1, 3);
        gL.setHgap(10);
        setLayout(gL);
        
        rockStarInput = new JTextField();
        scoreLabel = new JLabel("" + score);
        ok = new JButton("OK");
        
        add(rockStarInput);
        add(ok);
        scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(scoreLabel);

        ok.addActionListener(this);
        rockStarInput.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String tName = rockStarInput.getText();
            if(tName.equals("")) {
                GlobalVariables.rockStar = "Anonymous!";
            }
            else if (tName.length() <= 10) {
                GlobalVariables.rockStar = tName;
            }
            else{
                GlobalVariables.rockStar = tName.substring(0, 9);
            }
            if(GlobalVariables.cheated) GlobalVariables.rockStar = "(cheater) " + GlobalVariables.rockStar;
            GlobalVariables.highScoreHandler.setName(j);
        } catch (IOException ex) {
//            System.out.println(ex);
        }
        finally{
            GlobalVariables.askingScoreBoard.dispose();
            GlobalVariables.askingScoreBoard = null;
            GlobalVariables.gameStart.stopGame();
            GlobalVariables.gameStart.frame.dispose();
            GlobalVariables.gameStart = null;
            GameComputer.flush();
            ImagePainter.flush();
            GlobalVariables.flush();
            
            GlobalVariables.gameStart = new GameStart();
        }
    }
}
