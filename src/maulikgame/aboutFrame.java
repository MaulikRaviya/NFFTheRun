/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maulikgame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MaulikRaviya
 */
public class aboutFrame extends JFrame {
    
    

    
    aboutFrame(){
        super("About");
        
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(GlobalVariables.aboutPhoto, 0, 0,  null);
            }
        };
        
        
        panel.setPreferredSize(new Dimension(
                GlobalVariables.aboutPhoto.getWidth(null),
                GlobalVariables.aboutPhoto.getHeight(null)));
        
        //setSize(640, 495);
        add(panel);
       
        setResizable(false);
        setLocationByPlatform(true);
        setIconImage(GlobalVariables.icon);
        setVisible(true);
        setAlwaysOnTop(true);
        Graphics g = this.getGraphics();
        paint(panel.getGraphics());
         pack();
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                //GameComputer.pause();
                GlobalVariables.gameControlPane.aboutButton.setEnabled(
                        false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                
                GlobalVariables.gameControlPane.aboutButton.setEnabled(true);
            }
        });
        
    }
}
