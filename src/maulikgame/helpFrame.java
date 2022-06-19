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
public class helpFrame extends JFrame {


    helpFrame() {
        super("Help");
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(GlobalVariables.helpPhoto, 0, 0,  null);
            }
        };
        panel.setPreferredSize(new Dimension(GlobalVariables.helpPhoto.getWidth(null), GlobalVariables.helpPhoto.getHeight(null)));
        add(panel);
        
        setResizable(false);
        setIconImage(GlobalVariables.icon);
        setLocationByPlatform(true);
        setVisible(true);
        setAlwaysOnTop(true);
        pack();
        panel.paint(panel.getGraphics());
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                //GameComputer.pause();
                GlobalVariables.gameControlPane.helpButton.setEnabled(
                        false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();

                GlobalVariables.gameControlPane.helpButton.setEnabled(true);
            }
        });

    }
}
