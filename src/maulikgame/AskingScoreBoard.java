/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author MaulikRaviya
 */
class AskingScoreBoard extends JFrame {

    AskingScoreBoard(int j) throws IOException {
        super("Your postition: " + (j+1) + "...");
        GlobalVariables.askingScoreBoard = this;

        setSize(300, 400);
        setResizable(false);
        setAlwaysOnTop(true);
        setIconImage(GlobalVariables.icon);
        setBackground(new Color(100, 100, 255));
        //this.setMinimumSize(new Dimension(300, 400));
        GridLayout gL = new GridLayout(10, 1);
        gL.setVgap(10);
        setLayout(gL);

        for (int i = 0; i < 10; i++) {
            if (i != j) {
                add(new ScorePanel(
                        "" + (i + 1) + ". " + GlobalVariables.highScoreHandler.rockStars[i],
                        GlobalVariables.highScoreHandler.scores[i]));
            } else {
                add(new AskingPanel(GlobalVariables.highScoreHandler.scores[i],
                        j));
            }
        }
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                if (GlobalVariables.myCar.live) {
                    GameComputer.pause();
                }
            }

            @Override
            public void windowClosing(WindowEvent e) {
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
        });
        setLocationByPlatform(true);
        setVisible(true);

    }

}
