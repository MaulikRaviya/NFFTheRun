package maulikgame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author MaulikRaviya
 */
public class GameStart implements Runnable {

//    public static int scale = 3;
    public static boolean running = false;
    private final static String gameTitle = "NFF™ The Run";

    public Thread gameThread;
    private BufferStrategy bs;
    private Graphics g;

    public JFrame frame;
    public Canvas canvas;

    BufferedImage drawingBoard;

    public GameStart() {
        frame = new JFrame();
        canvas = new Canvas(){
            public void paint(Graphics g){
                g.drawImage(GlobalVariables.coverPhoto.getScaledInstance(getWidth(),
                        getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
            }
        };
        GlobalVariables.gameControlPane = new GameControlPane();
        HighScoresHandler highScoresHandler = new HighScoresHandler();

        GlobalVariables.gameWidth = GlobalVariables.HDWIDTH;
        GlobalVariables.gameHeight = GlobalVariables.gameWidth * 3 / 4;

        GlobalVariables.roadWidth = GlobalVariables.ACTUAL_ROAD_WIDTH * GlobalVariables.gameWidth / 900;
        GlobalVariables.roadStartX = (GlobalVariables.gameWidth - GlobalVariables.roadWidth) / 2 + 30;

        GlobalVariables.lane1X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 0 + 10;
        GlobalVariables.lane2X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 1 + 10;
        GlobalVariables.lane3X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 2 + 10;
        GlobalVariables.lane4X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 3 + 10;
        GlobalVariables.lane5X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 4 + 10;
        GlobalVariables.lane6X = GlobalVariables.roadStartX + (GlobalVariables.roadWidth / 6) * 5 + 10;

        GlobalVariables.CAR_WIDTH = 50 * GlobalVariables.gameWidth / 900;
        GlobalVariables.CAR_HEIGHT = 100 * GlobalVariables.gameHeight / (900) * 4 / 3;

        GlobalVariables.spriteUpCar1 = GlobalVariables.spriteUpCar1.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar2 = GlobalVariables.spriteUpCar2.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar3 = GlobalVariables.spriteUpCar3.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar4 = GlobalVariables.spriteUpCar4.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);

        GlobalVariables.spriteDownCar1 = GlobalVariables.spriteDownCar1.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar2 = GlobalVariables.spriteDownCar2.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar3 = GlobalVariables.spriteDownCar3.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar4 = GlobalVariables.spriteDownCar4.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        
        GlobalVariables.spriteUpCar1_dead = GlobalVariables.spriteUpCar1_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar2_dead = GlobalVariables.spriteUpCar2_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar3_dead = GlobalVariables.spriteUpCar3_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteUpCar4_dead = GlobalVariables.spriteUpCar4_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);

        GlobalVariables.spriteDownCar1_dead = GlobalVariables.spriteDownCar1_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar2_dead = GlobalVariables.spriteDownCar2_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar3_dead = GlobalVariables.spriteDownCar3_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        GlobalVariables.spriteDownCar4_dead = GlobalVariables.spriteDownCar4_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        
        GlobalVariables.spriteMyCar = GlobalVariables.spriteMyCar.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);
        
        GlobalVariables.spriteMyCar_dead = GlobalVariables.spriteMyCar_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT,
                Image.SCALE_SMOOTH);

        GlobalVariables.spritePolice1 = GlobalVariables.spritePolice1.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT, Image.SCALE_SMOOTH);
        GlobalVariables.spritePolice2 = GlobalVariables.spritePolice2.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT, Image.SCALE_SMOOTH);
        GlobalVariables.spritePolice_dead = GlobalVariables.spritePolice_dead.getScaledInstance(
                GlobalVariables.CAR_WIDTH, GlobalVariables.CAR_HEIGHT, Image.SCALE_SMOOTH);
        
        GlobalVariables.spriteFual1 = GlobalVariables.spriteFual1.getScaledInstance(40, 60, Image.SCALE_SMOOTH);
        GlobalVariables.spriteFual2 = GlobalVariables.spriteFual2.getScaledInstance(40, 60, Image.SCALE_SMOOTH);
        
        GlobalVariables.roadTexture = GlobalVariables.roadTexture.getScaledInstance(
                GlobalVariables.roadWidth,
                (int) ((double) GlobalVariables.roadWidth * (126.0 / 900.0)),
                Image.SCALE_SMOOTH);
        GlobalVariables.roadStartY = 0 - GlobalVariables.roadTexture.getHeight(
                null);

        //System.out.println(
               // "Lanes: " + GlobalVariables.lane1X + ", " + GlobalVariables.lane2X + ", " + GlobalVariables.lane3X + ", " + GlobalVariables.lane4X);
        //System.out.println("roadStartX: " + GlobalVariables.roadStartX);
        //System.out.println("roadStartY: " + GlobalVariables.roadStartY);

        GlobalVariables.cheated = false;
        
        canvas.setPreferredSize(new Dimension(GlobalVariables.gameWidth,
                GlobalVariables.gameHeight));

        frame.setTitle("NFF The Run");

        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = c.gridy = 0;

        frame.add(canvas, c);
        GlobalVariables.gameControlPane.setSize(100, GlobalVariables.gameHeight);

        c.gridx = 1;
        c.fill = GridBagConstraints.VERTICAL;
        frame.add(GlobalVariables.gameControlPane, c);

        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(GlobalVariables.icon);
        frame.setVisible(true);

        frame.pack();

        frame.addKeyListener(GlobalVariables.mk);
        canvas.addKeyListener(GlobalVariables.mk);

        drawingBoard = new BufferedImage(GlobalVariables.gameWidth,
                GlobalVariables.gameHeight, BufferedImage.TYPE_INT_RGB);

        //GlobalVariables.roadObjects.add();
        GlobalVariables.gameControlPane.pauseButton.setText("Start");
        //startGame();
        
        
        
        frame.addWindowFocusListener(new WindowFocusListener(){

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                GameComputer.pause();
            }
            
        });
    }

    public synchronized void startGame() {
        running = true;
        GlobalVariables.gameControlPane.pauseButton.setText("Pause");
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stopGame() {
        try {
            running = false;
            gameThread.join();
        } catch (InterruptedException ex) {
            //ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        int frames = 0, updates = 0;
        long ns2 = 0, uNs1 = 0, rNs1 = 0, rNs2;

        uNs1 = rNs2 = rNs1 = System.nanoTime();
        //System.out.println(ns1);
        GameComputer.flush();

        while (running) {
//            ns2 = System.nanoTime();

            if (System.nanoTime() - uNs1 >= 1000000000 / 60) {
                if (!GlobalVariables.paused) {
                    GameComputer.update();
                    updates++;
                }
                uNs1 = System.nanoTime();
            }

//            if (System.nanoTime() - rNs2 >= 1000000000 / 60) {
            render();

            frames++;
//                rNs2 = System.nanoTime();
//
//            }

            //System.out.println(time+"s");
            if (System.nanoTime() - rNs1 >= 1000000000) {
                //1 second elasped...
                frame.setTitle(gameTitle + " @" + frames + "FPS");
                frames = 0;
                updates = 0;
                rNs1 = System.nanoTime();
            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
        }
    }

    public void render() {
        bs = canvas.getBufferStrategy();
        if (bs == null) {
            //System.out.println("in null bs before="+bs);
            canvas.createBufferStrategy(2);
            //System.out.println("in null bs now="+bs);
            return;
        }
        //System.out.println("bs="+bs);

        g = bs.getDrawGraphics();

        drawingBoard = ImagePainter.paint(/*drawingBoard*/);
        g.drawImage(drawingBoard, 0, 0,  null);
        g.dispose();
        bs.show();

    }

}
