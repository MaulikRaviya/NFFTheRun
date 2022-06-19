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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author MaulikRaviya
 */
public class ScoreBoard extends JFrame {

    JButton resetButton;

    ScoreBoard() {
        super("Scoreboard");
        GlobalVariables.scoreBoard = this;
        resetButton = new JButton("Reset");
        setResizable(false);
        setIconImage(GlobalVariables.icon);
        setAlwaysOnTop(true);
        setSize(300, 400);
        GridLayout gL = new GridLayout(11, 1);

        gL.setVgap(10);

        setLayout(gL);

        setBackground(new Color(100, 100, 255));

        
        //this.setMinimumSize(new Dimension(300, 400));
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                //GameComputer.pause();
                GlobalVariables.gameControlPane.highScoreButton.setEnabled(
                        false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                GlobalVariables.scoreBoard.dispose();
                GlobalVariables.scoreBoard = null;
                GlobalVariables.gameControlPane.highScoreButton.setEnabled(true);
            }
        });

        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GlobalVariables.highScoreHandler.resetFile();
                } catch (IOException ex) {
                    //System.out.println(ex);
                }
                GlobalVariables.scoreBoard.dispose();
                GlobalVariables.scoreBoard = null;
                new ScoreBoard();
            }

        });

        for (int i = 0; i < 10; i++) {
            add(new ScorePanel(
                    "" + (i + 1) + ". " + GlobalVariables.highScoreHandler.rockStars[i],
                    GlobalVariables.highScoreHandler.scores[i]));
        }
        add(resetButton);
        setLocationByPlatform(true);
        setVisible(true);
    }
}
