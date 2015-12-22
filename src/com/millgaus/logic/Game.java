package com.millgaus.logic;



import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Adam on 2015-12-22.
 */
public class Game {

    public int score;
    private int timePassed;
    public int leftMistakes;
    public ArrayList<Rectangle> dollars = new ArrayList<>();

    public boolean goToNextLevel = false;


    private int combo;
    private int hitComboCounter;
    private int comboBoost;
    private int maxSize;
    public int level = 1;
    public boolean added = false;
    public boolean gameOver = false;
    public int dollarsToAdd;

    public Game(){
        score=0;
        leftMistakes=10;
        combo=0;
        hitComboCounter = 3;
        dollars.add(new Rectangle(1,1,60,25));
        timePassed=501;
        comboBoost=5;
        maxSize=10;
        dollarsToAdd= level * 10-1;
    }

    public Game(int level, int leftMistakes,boolean added, int score){
        this.score=score;
        this.leftMistakes=leftMistakes;
        combo=0;
        hitComboCounter = 3;
        dollars.add(new Rectangle(1,1,60,25));
        timePassed=501;
        comboBoost=5;
        maxSize=10;
        this.level=level;
        this.added=added;
        dollarsToAdd= level * 10-1;

    }

    public void hitDolar(){
        score++;
        getHitCombo("dolar");
    }

    public void getHitCombo(String job) {
        combo++;

    }

    public void hitRolex(){
        score+=5;

    }

    public void hitJewel(){
        score+=20;

    }

    public int generateRandomX(){
        int ret = new Random().nextInt(1200);
        if(ret>1200 || ret<80)
            return generateRandomX();
        else return ret;
    }



    public int getLeftMistakes() {
        return leftMistakes;
    }








    public int getScore() {
        return score;
    }

    public void generateDollars(){

            if(dollars.size()<=dollarsToAdd){
                dollars.add(new Rectangle(generateRandomX(), 0, 60, 25));
                added=false;
                dollarsToAdd--;
            }
            else
                added=true;

    }

    public boolean spawnDollar(){
        if(timePassed>50-0.1*level){
            timePassed=0;
            return true;
        }
        else {
            timePassed++;
            return false;
        }
    }

}
