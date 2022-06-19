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
public class creditsFrame extends JFrame {

    creditsFrame() {
        super("Credits");
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                g.drawImage(GlobalVariables.creditsPhoto, 0, 0, null);
            }
        };

        panel.setPreferredSize(new Dimension(
                GlobalVariables.creditsPhoto.getWidth(null),
                GlobalVariables.creditsPhoto.getHeight(null)));
        //setSize(977, 565);
        add(panel);
        
        setResizable(false);
        setIconImage(GlobalVariables.icon);
        setLocationByPlatform(true);
        setVisible(true);
        setAlwaysOnTop(true);
        pack();
        paint(panel.getGraphics());

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                //GameComputer.pause();
                GlobalVariables.gameControlPane.creditsButton.setEnabled(
                        false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();

                GlobalVariables.gameControlPane.creditsButton.setEnabled(true);
            }
        });
    }
}
