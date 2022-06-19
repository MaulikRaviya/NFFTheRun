package maulikgame;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author MaulikRaviya
 */
public class GlobalVariables {

    public static int gameWidth;
    public static int gameHeight;

    public static GameStart gameStart = null;
    public static String rockStar = null;
    public static HighScoresHandler highScoreHandler = null;
    public static AskingScoreBoard askingScoreBoard = null;

    public static final int HDWIDTH = 720;

    public static int CAR_WIDTH, CAR_HEIGHT;

    public static ArrayList<RoadObject> roadObjects;

    public static ArrayList<RoadObject> lane1Cars;
    public static ArrayList<RoadObject> lane2Cars;
    public static ArrayList<RoadObject> lane3Cars;
    public static ArrayList<RoadObject> lane4Cars;
    public static ArrayList<RoadObject> lane5Cars;
    public static ArrayList<RoadObject> lane6Cars;

    public static MyCar myCar;

    public static double score = 0.0;

    public static int level = 1;

    public static RoadObject lane1Panoti = null;
    public static RoadObject lane2Panoti = null;
    public static RoadObject lane3Panoti = null;
    public static RoadObject lane4Panoti = null;
    public static RoadObject lane5Panoti = null;
    public static RoadObject lane6Panoti = null;

    public static Image spriteUpCar1, spriteUpCar2, spriteUpCar3, spriteUpCar4;
    public static Image spriteUpCar1_dead, spriteUpCar2_dead, spriteUpCar3_dead, spriteUpCar4_dead;

    public static Image spriteDownCar1, spriteDownCar2, spriteDownCar3, spriteDownCar4;
    public static Image spriteDownCar1_dead, spriteDownCar2_dead, spriteDownCar3_dead, spriteDownCar4_dead;

    public static Image spriteFual1, spriteFual2, spriteMyCar, spriteMyCar_dead;
    public static Image roadTexture;
    public static Image spritePolice1, spritePolice2, spritePolice_dead;

    public static final int ACTUAL_ROAD_WIDTH = 450;
    public static int roadWidth;
    public static int roadStartX;
    public static int lane1X, lane2X, lane3X, lane4X, lane5X, lane6X;

    public static int ID = 0;

    public static Random crazy = new Random();
    static int ratio = 16 / 9;

    public static boolean keysPressed[] = new boolean[128];
    static int roadStartY;

    public static GameControlPane gameControlPane;

    public static boolean rajniMode = false, infinityMilage = false, hasOnScreenText = false;
    public static String onScreenText = "";

    public static int fual;
    public static int inverseMilage = 15;

    public static MyKeyListner mk = new MyKeyListner();
    public static int life;
    static boolean screenBlur = false;
    public static FuelTank fuelObject = null;
    public static boolean paused = false;
    public static ScoreBoard scoreBoard = null;
    public static long pausedTime;
    private static boolean[] keyPressed;
    public static boolean cheated = false;
    public static PoliceCar policeCar = null;
    public static Image coverPhoto;
    public static Image helpPhoto;
    public static Image aboutPhoto;
    public static Image creditsPhoto;
    public static Image icon;

    public static void initilizeAll() {
        File fileUpCar1, fileUpCar2, fileUpCar3, fileUpCar4;
        File fileUpCar1_dead, fileUpCar2_dead, fileUpCar3_dead, fileUpCar4_dead;
        File fileDownCar1, fileDownCar2, fileDownCar3, fileDownCar4;
        File fileDownCar1_dead, fileDownCar2_dead, fileDownCar3_dead, fileDownCar4_dead;

        JFrame tempFrame = new JFrame("NFFTheRun by Maulik Raviya");
        tempFrame.add(new JLabel("Please wait untill everything is loded..."));
        tempFrame.setAlwaysOnTop(true);
        tempFrame.setSize(300, 100);
        tempFrame.setLocationByPlatform(true);
        tempFrame.setResizable(false);
        tempFrame.setVisible(true);

        int hashes = 0;
        final int targetHash = 224187022;
        try {
            fileUpCar1 = new File(
                    "00_game_data" + File.separatorChar + "fileupcar1.maulik");
            //System.out.println("fileUpCar1: " + CodeSecurity.findHash(fileUpCar1));
            hashes += CodeSecurity.findHash(fileUpCar1);

            fileUpCar2 = new File(
                    "00_game_data" + File.separatorChar + "fileupcar2.maulik");
            //System.out.println("fileUpCar2: " + CodeSecurity.findHash(fileUpCar2));
            hashes += CodeSecurity.findHash(fileUpCar2);

            fileUpCar3 = new File(
                    "00_game_data" + File.separatorChar + "fileupcar3.maulik");
            //System.out.println("fileUpCar3: " + CodeSecurity.findHash(fileUpCar3));
            hashes += CodeSecurity.findHash(fileUpCar3);

            fileUpCar4 = new File(
                    "00_game_data" + File.separatorChar + "fileupcar4.maulik");
            //System.out.println("fileUpCar4: " + CodeSecurity.findHash(fileUpCar4));
            hashes += CodeSecurity.findHash(fileUpCar4);

            //System.out.println(fileUpCar4.exists());
            //System.out.println(fileUpCar4.getAbsolutePath());
            
            fileUpCar1_dead = new File(
                    "00_game_data" + File.separatorChar + "fileupcar1dead.maulik");
            //System.out.println("fileUpCar1_dead: " + CodeSecurity.findHash(fileUpCar1_dead));
            hashes += CodeSecurity.findHash(fileUpCar1_dead);
            
           // System.out.println(fileUpCar1_dead.exists());
            //System.out.println(fileUpCar1_dead.getAbsolutePath());
            
            fileUpCar2_dead = new File(
                    "00_game_data" + File.separatorChar + "fileupcar2dead.maulik");
            //System.out.println("fileUpCar2_dead: " + CodeSecurity.findHash(fileUpCar2_dead));
            hashes += CodeSecurity.findHash(fileUpCar2_dead);
            
            //System.out.println(fileUpCar2_dead.exists());
            //System.out.println(fileUpCar2_dead.getAbsolutePath());

            fileUpCar3_dead = new File(
                    "00_game_data" + File.separatorChar + "fileupcar3dead.maulik");
            //System.out.println("fileUpCar3_dead: " + CodeSecurity.findHash(fileUpCar3_dead));
            hashes += CodeSecurity.findHash(fileUpCar3_dead);

            fileUpCar4_dead = new File(
                    "00_game_data" + File.separatorChar + "fileupcar4dead.maulik");
            //System.out.println("fileUpCar4_dead: " + CodeSecurity.findHash(fileUpCar4_dead));
            hashes += CodeSecurity.findHash(fileUpCar4_dead);

            fileDownCar1 = new File(
                    "00_game_data" + File.separatorChar + "filedowncar1.maulik");
            //System.out.println("fileDownCar1: " + CodeSecurity.findHash(fileDownCar1));
            hashes += CodeSecurity.findHash(fileDownCar1);

            fileDownCar2 = new File(
                    "00_game_data" + File.separatorChar + "filedowncar2.maulik");
            //System.out.println("fileDownCar2: " + CodeSecurity.findHash(fileDownCar2));
            hashes += CodeSecurity.findHash(fileDownCar2);

            fileDownCar3 = new File(
                    "00_game_data" + File.separatorChar + "filedowncar3.maulik");
            //System.out.println("fileDownCar3: " + CodeSecurity.findHash(fileDownCar3));
            hashes += CodeSecurity.findHash(fileDownCar3);

            fileDownCar4 = new File(
                    "00_game_data" + File.separatorChar + "filedowncar4.maulik");
            //System.out.println("fileDownCar4: " + CodeSecurity.findHash(fileDownCar4));
            hashes += CodeSecurity.findHash(fileDownCar4);

            fileDownCar1_dead = new File(
                    "00_game_data" + File.separatorChar + "filedowncar1dead.maulik");
            //System.out.println("fileDownCar1_dead: " + CodeSecurity.findHash(fileDownCar1_dead));
            hashes += CodeSecurity.findHash(fileDownCar1_dead);

            fileDownCar2_dead = new File(
                    "00_game_data" + File.separatorChar + "filedowncar2dead.maulik");
            //System.out.println("fileDownCar2_dead: " + CodeSecurity.findHash(fileDownCar2_dead));
            hashes += CodeSecurity.findHash(fileDownCar2_dead);

            fileDownCar3_dead = new File(
                    "00_game_data" + File.separatorChar + "filedowncar3dead.maulik");
            //System.out.println("fileDownCar3_dead: " + CodeSecurity.findHash(fileDownCar3_dead));
            hashes += CodeSecurity.findHash(fileDownCar3_dead);

            fileDownCar4_dead = new File(
                    "00_game_data" + File.separatorChar + "filedowncar4dead.maulik");
            //System.out.println("fileDownCar4_dead: " + CodeSecurity.findHash(fileDownCar4_dead));
            hashes += CodeSecurity.findHash(fileDownCar4_dead);

            File fileMyCar = new File(
                    "00_game_data" + File.separatorChar + "filemycar.maulik");
            //System.out.println("fileMyCar: " + CodeSecurity.findHash(fileMyCar));
            hashes += CodeSecurity.findHash(fileMyCar);

            File fileMyCar_dead = new File(
                    "00_game_data" + File.separatorChar + "filemycardead.maulik");
            //System.out.println("fileMyCar_dead: " + CodeSecurity.findHash(fileMyCar_dead));
            hashes += CodeSecurity.findHash(fileMyCar_dead);

            File fileRoadTexture = new File(
                    "00_game_data" + File.separatorChar + "roadtexture.maulik");
            //System.out.println("fileRoadTexture: " + CodeSecurity.findHash(fileRoadTexture));
            hashes += CodeSecurity.findHash(fileRoadTexture);

            File fileFual1 = new File(
                    "00_game_data" + File.separatorChar + "filefueltank.maulik");
            //System.out.println("fileFual1: " + CodeSecurity.findHash(fileFual1));
            hashes += CodeSecurity.findHash(fileFual1);

            File fileFual2 = new File(
                    "00_game_data" + File.separatorChar + "filebluefualtank.maulik");
            //System.out.println("fileFual2: " + CodeSecurity.findHash(fileFual2));
            hashes += CodeSecurity.findHash(fileFual2);

            File filePolice1 = new File(
                    "00_game_data" + File.separatorChar + "filepolice1.maulik");
            //System.out.println("filePolice1: " + CodeSecurity.findHash(filePolice1));
            hashes += CodeSecurity.findHash(filePolice1);

            File filePolice2 = new File(
                    "00_game_data" + File.separatorChar + "filepolice2.maulik");
            //System.out.println("filePolice2: " + CodeSecurity.findHash(filePolice2));
            hashes += CodeSecurity.findHash(filePolice2);

            File filePolice_dead = new File(
                    "00_game_data" + File.separatorChar + "filepolicedead.maulik");
            //System.out.println("filePolice_dead: " + CodeSecurity.findHash(filePolice_dead));
            hashes += CodeSecurity.findHash(filePolice_dead);

            File fileCoverPhoto = new File(
                    "00_game_data" + File.separatorChar + "filecoverphoto.maulik");
            //System.out.println("fileCoverPhoto: " + CodeSecurity.findHash(fileCoverPhoto));
            hashes += CodeSecurity.findHash(fileCoverPhoto);

            File fileHelp = new File(
                    "00_game_data" + File.separatorChar + "filehelp.maulik");
            //System.out.println("fileHelp: " + CodeSecurity.findHash(fileHelp));
            hashes += CodeSecurity.findHash(fileHelp);

            File fileAbout = new File(
                    "00_game_data" + File.separatorChar + "fileabout.maulik");
            //System.out.println("fileAbout: " + CodeSecurity.findHash(fileAbout));
            hashes += CodeSecurity.findHash(fileAbout);

            File fileCredits = new File(
                    "00_game_data" + File.separatorChar + "filecredits.maulik");
            //System.out.println("fileCredits: " + CodeSecurity.findHash(fileCredits));
            hashes += CodeSecurity.findHash(fileCredits);
            
            File fileIcon = new File("00_game_data" + File.separatorChar + "fileicon.maulik");
            hashes += CodeSecurity.findHash(fileIcon);
            
            //System.out.println(""+hashes);

            if(hashes!=targetHash){
                throw new Exception("Some data altered");
            }
  
            //System.out.println(hashes);
            
            
            spriteUpCar1 = ImageIO.read(fileUpCar1);
            spriteUpCar2 = ImageIO.read(fileUpCar2);
            spriteUpCar3 = ImageIO.read(fileUpCar3);
            spriteUpCar4 = ImageIO.read(fileUpCar4);

            spriteUpCar1_dead = ImageIO.read(fileUpCar1_dead);
            spriteUpCar2_dead = ImageIO.read(fileUpCar2_dead);
            spriteUpCar3_dead = ImageIO.read(fileUpCar3_dead);
            spriteUpCar4_dead = ImageIO.read(fileUpCar4_dead);

            spriteDownCar1 = ImageIO.read(fileDownCar1);
            spriteDownCar2 = ImageIO.read(fileDownCar2);
            spriteDownCar3 = ImageIO.read(fileDownCar3);
            spriteDownCar4 = ImageIO.read(fileDownCar4);

            spriteDownCar1_dead = ImageIO.read(fileDownCar1_dead);
            spriteDownCar2_dead = ImageIO.read(fileDownCar2_dead);
            spriteDownCar3_dead = ImageIO.read(fileDownCar3_dead);
            spriteDownCar4_dead = ImageIO.read(fileDownCar4_dead);

            spriteMyCar = ImageIO.read(fileMyCar);

            spriteMyCar_dead = ImageIO.read(fileMyCar_dead);

            roadTexture = ImageIO.read(fileRoadTexture);

            spriteFual1 = ImageIO.read(fileFual1);
            spriteFual2 = ImageIO.read(fileFual2);

            spritePolice1 = ImageIO.read(filePolice1);
            spritePolice2 = ImageIO.read(filePolice2);
            spritePolice_dead = ImageIO.read(filePolice_dead);

            coverPhoto = ImageIO.read(fileCoverPhoto);
            helpPhoto = ImageIO.read(fileHelp);
            aboutPhoto = ImageIO.read(fileAbout);
            creditsPhoto = ImageIO.read(fileCredits);

            icon = ImageIO.read(fileIcon);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tempFrame,
                    "Possible reson for error:\n- One or more files in 00_game_data folder is missing/altered, which are neccesary for game execution.\n\nMake sure 00_game_data folder is there and it is accesable by this user, and any file within it is not missing/altered.\n\nConatct google.com/+MaulikRaviya if help required.",
                    "Error while loading from 00_game_data",
                    JOptionPane.ERROR_MESSAGE);
                    
            //System.out.println(ex);
            System.exit(999);
        } finally {
            tempFrame.dispose();
        }
    }

    public static void flush() {
        gameStart = null;
        rockStar = null;
        highScoreHandler = null;
        askingScoreBoard = null;
        policeCar = null;
        roadObjects = null;

        if (roadObjects != null) {
            roadObjects.clear();
        }
        if (lane1Cars != null) {
            lane1Cars.clear();
        }
        if (lane2Cars != null) {
            lane2Cars.clear();
        }
        if (lane3Cars != null) {
            lane3Cars.clear();
        }
        if (lane4Cars != null) {
            lane4Cars.clear();
        }
        if (lane5Cars != null) {
            lane5Cars.clear();
        }
        if (lane6Cars != null) {
            lane6Cars.clear();
        }
        if (myCar != null) {
            myCar = null;
        }

        roadObjects = new ArrayList();
        lane1Cars = new ArrayList();
        lane2Cars = new ArrayList();
        lane3Cars = new ArrayList();
        lane4Cars = new ArrayList();
        lane5Cars = new ArrayList();
        lane6Cars = new ArrayList();
        myCar = new MyCar(GlobalVariables.lane3X, 3);

        score = 0;
        fual = 1000;
        life = 3;
        cheated = false;
        ID = 0;
        keysPressed = new boolean[128];
        mk = new MyKeyListner();
        rajniMode = false;
        infinityMilage = false;
        hasOnScreenText = false;
        level = 1;
        onScreenText = "";
        screenBlur = false;
        fuelObject = null;
        paused = false;
        scoreBoard = null;
        inverseMilage = 15;
    }
}
