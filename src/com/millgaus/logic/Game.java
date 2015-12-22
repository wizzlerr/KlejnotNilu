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
    private int combo;
    private int hitComboCounter;
    private int comboBoost;
    private int maxSize;
    private int level = 1;
    public boolean added = false;

    public Game(){
        score=0;
        leftMistakes=10;
        combo=0;
        hitComboCounter = 3;
        dollars.add(new Rectangle(1,1,60,25));
        timePassed=501;
        comboBoost=5;
        maxSize=10;

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
        getHitCombo("rolex");
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

    public boolean spawnDollar(){
        if(timePassed>50){
            timePassed=0;
            return true;
        }
        else {
            timePassed++;
            return false;
        }
    }

    public int getLeftMistakes() {
        return leftMistakes;
    }

    public int getScore() {
        return score;
    }

    public void generateDollars(){
            if(dollars.size()<=level*10)
                dollars.add(new Rectangle(generateRandomX(), 0, 60, 25));
            else
                added=true;

    }

}
