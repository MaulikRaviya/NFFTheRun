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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author MaulikRaviya
 */
public class GameControlPane extends JPanel {
    public JButton pauseButton;
    public JButton helpButton;
    public JButton creditsButton;
    public JButton aboutButton;
    public JButton highScoreButton;
    
    GameControlPane(){
        this.setLayout(new GridLayout(5,1));
        addKeyListener(GlobalVariables.mk);
        
        setBackground(Color.black);
        
        pauseButton = new JButton("Pause");
        helpButton = new JButton("Help");
        creditsButton = new JButton("Credits");
        aboutButton = new JButton("About");
        highScoreButton = new JButton("High Scores");
        
        
        pauseButton.addKeyListener(GlobalVariables.mk);
        
        pauseButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!GlobalVariables.gameStart.running){
                    GlobalVariables.gameStart.startGame();
                }
                else if(GlobalVariables.paused){
                    GameComputer.resume();
                }
                else{
                    GameComputer.pause();
                }
            }
            
        });
        
        highScoreButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(GlobalVariables.scoreBoard==null){
                    new ScoreBoard();
                }
            }
            
        });
        
        helpButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new helpFrame();
            }
            
        });
        
        creditsButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new creditsFrame();
            }
            
        });
        
        aboutButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new aboutFrame();
            }
            
        });
        
        add(pauseButton);
        add(highScoreButton);
        add(helpButton);
        add(creditsButton);
        add(aboutButton);
        
        
    }
}
