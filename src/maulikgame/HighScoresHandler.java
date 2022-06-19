/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulikgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author MaulikRaviya
 */
public class HighScoresHandler {

    String rockStars[];
    int scores[];
    File highScoreFile;
    ScoreBoard scoreBoardDialog;
    BufferedReader br1;
    BufferedWriter bw1;

    public HighScoresHandler() {
        GlobalVariables.highScoreHandler = this;
        rockStars = new String[10];
        scores = new int[10];
        highScoreFile = new File(
                "00_game_data" + File.separatorChar + "high_scores.txt");
//        System.out.println("let us C");
        if (highScoreFile.exists()) {
            try {

                br1 = new BufferedReader(new FileReader(highScoreFile));

                String magicString = br1.readLine();
                //System.out.println("magic string="+magicString);
                //System.out.println("hash of magic string="+hash(magicString));
                String temp = decrypt(br1.readLine());
                //System.out.println("temp="+temp);

                String namesAndScores[] = magicString.split(";");

                if (namesAndScores.length != 10) {
//                    System.out.println(
//                            "cannt find 10 data : " + namesAndScores.length);
                    throw new Exception();
                }

                for (int i = 0; i < 10; i++) {
                    String spliter[] = namesAndScores[i].split("@");
                    if (spliter.length != 2) {
//                        System.out.println(
//                                "cannt split with @ : i=" + i + ", namesAndScores[i]=" + namesAndScores[i]);
                        throw new Exception();
                    }
                    rockStars[i] = spliter[0];

                    scores[i] = Integer.parseInt(spliter[1]);
                    //System.out.println("OK");
                }

                if (!temp.equals(hash(magicString))) {
//                    System.out.println("Wrong hash: " + temp + " != " + hash(
//                            temp));
                    resetFile();
                } else {
//                    System.out.println("all is well");
                }

            } catch (FileNotFoundException ex) {
//                System.out.println(ex);
            } catch (IOException ex) {
//                System.out.println(ex);
            } catch (Exception ex) {
//                System.out.println("who called me?? : " + ex);

                try {
                    resetFile();
                } catch (IOException ex1) {
//                    System.out.println("Buhsss!!");
                }
            } finally {
                try {
                    br1.close();
                } catch (IOException ex) {
//                    System.out.println(ex + " while closing br1");
                }
            }
        } else {
            try {
                resetFile();
            } catch (IOException ex) {
//                System.out.println(ex);
            }
        }

//        System.out.println("Scores are loded:\n" + rockStars + "\n" + scores);
        //for (String x : rockStars) {
            //System.out.print(x + " ");
        //}
        //for (int x : scores) {
//            System.out.print(" " + x);
        //}
    }

    public void resetFile() throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //System.out.println("Resetting..");
        highScoreFile.createNewFile();
        bw1 = new BufferedWriter(new FileWriter(highScoreFile));
        String magicString = "---@0;---@0;---@0;---@0;---@0;---@0;---@0;---@0;---@0;---@0";
        bw1.write(magicString);
        bw1.newLine();
        bw1.write(encrypt(hash(magicString)));
//        System.out.println("Written hash: " + hash(magicString));
        bw1.close();

        rockStars = new String[10];
        scores = new int[10];

        for (int i = 0; i < 10; i++) {
            rockStars[i] = "---";
            scores[i] = 0;
        }
        //System.out.println("Scores are generated:\n" + rockStars + "\n" + scores);
    }

    private String hash(String magicString) {
        return Integer.toString(magicString.hashCode());
    }

    public void whatAboutThis(int currentScore) throws IOException {
        int j = 10;
        while (j > 0 && scores[j - 1] < currentScore) {
            j--;
        }
        if (j < 10) {

            if (j < 9) {
                for (int i = 8; i>=j ; i--) {
                    rockStars[i + 1] = rockStars[i];
                    scores[i+1] = scores[i];
                }
            }
            if(!GlobalVariables.cheated) rockStars[j] = "Anonymous!";
            else rockStars[j] = "(cheater) Anonymous!";
            scores[j] = currentScore;
            update();
            AskingScoreBoard asb = new AskingScoreBoard(j);
            
        }
    }

    public void setName(int position) throws IOException {
        rockStars[position] = GlobalVariables.rockStar;
        update();
    }
/*
    public static void main(String args[]) throws IOException {
        System.out.println("HighScores testing manu.. :");
        HighScoresHandler h1 = new HighScoresHandler();

        Scanner yo = new Scanner(System.in);
        boolean done = false;

        do {
            switch (yo.nextInt()) {
                case 1:
                    System.out.println(
                            "Scores board:\n" + h1.rockStars + "\n" + h1.scores);
                    for (String x : h1.rockStars) {
                        System.out.print(x + " ");
                    }
                    for (int x : h1.scores) {
                        System.out.print(" " + x);
                    }
                    new ScoreBoard();
                    break;
                case 2:
                    System.out.print("Enter score:");
                    h1.whatAboutThis(yo.nextInt());
                    break;
                default:
                    done = true;
            }
        } while (!done);
    }
    */

    private void update() throws IOException {
        bw1 = new BufferedWriter(new FileWriter(highScoreFile));
        String magicString = rockStars[0] + "@" + scores[0];

        for (int i = 1; i < 10; i++) {
            magicString += ";" + rockStars[i] + "@" + scores[i];
        }
        String temp = hash(magicString);

        bw1.write(magicString);
        bw1.newLine();
        bw1.write(encrypt(temp));
        
        bw1.close();
    }
    
    private String encrypt(String plainText){
//        String cypherText = "";
//        for(int i=0; i<plainText.length(); i++){
//            cypherText += (char)(plainText.charAt(i)+('a'+i));
//        }
        return plainText;
    }
    
    private String decrypt(String cypherText){
//        String plainText = "";
//        for(int i=0; i<cypherText.length(); i++){
//            plainText += (char)(cypherText.charAt(i)-('a'+i));
//        }
        return cypherText;
    }
}
