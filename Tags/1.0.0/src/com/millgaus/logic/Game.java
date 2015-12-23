package com.millgaus.logic;



import com.millgaus.logic.shapes.Dollar;
import com.millgaus.logic.shapes.utils.AbstractShape;
import com.millgaus.logic.shapes.utils.ShapeFactory;
import org.lwjgl.Sys;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Adam on 2015-12-22.
 */
public class Game {

    private final int COMBO_SIZE=500;
    public int score;
    private int timePassed;
    public int leftMistakes;
    public ArrayList<AbstractShape> dollars = new ArrayList<>();
    public ArrayList<AbstractShape> comboShapes = new ArrayList<>();

    public boolean goToNextLevel = false;


    private int combo;
    private int hitComboCounter;
    private int comboBoost;
    private int maxSize;
    public int level = 1;
    public boolean added = false;
    public boolean gameOver = false;
    public int dollarsToAdd;
    private int previousMistakes;
    public boolean isCombo = false;

    public Game(){
        score=0;
        leftMistakes=1000;
        combo=COMBO_SIZE;
        hitComboCounter = 3;
        dollars.add(ShapeFactory.shape(whatToSpawn()));
        timePassed=501;
        comboBoost=1;
        maxSize=
        dollarsToAdd= level * 10-1;
        previousMistakes=leftMistakes;
    }

    public Game(int level, int leftMistakes,boolean added, int score, ArrayList<AbstractShape> cs){
        this.score=score;
        this.leftMistakes=leftMistakes;
        combo=COMBO_SIZE;
        hitComboCounter = 3;
        dollars.add(ShapeFactory.shape(whatToSpawn()));
        timePassed=501;
        comboBoost=1;
        maxSize=10;
        this.level=level;
        this.added=added;
        dollarsToAdd= level * 10-1;
        previousMistakes=leftMistakes;
        comboShapes=cs;

    }

    public void hitDolar(){
        score+=1*comboBoost;
    }

    public void getHitCombo() {

        if(previousMistakes==leftMistakes){

            int value=0;
            for(AbstractShape as:comboShapes){
                value+=as.value;
            }
            System.out.println(value);
            if(value>=100){
                isCombo=true;
                startCombo();
            }
            else stopCombo();
        }
        else{
            stopCombo();
            previousMistakes=leftMistakes;
            comboShapes.clear();
        }
    }

    private void stopCombo() {
        combo=COMBO_SIZE;
        isCombo=false;
        comboBoost=1;
    }

    private void startCombo() {
        if(combo>0&&isCombo){
            combo-=1;
            comboBoost=5;
        }
        else {
            comboShapes.clear();
            stopCombo();
        };
    }

    public void hitRolex(){
        score+=5*comboBoost;
    }

    public void hitJewel(){
        score+=20*comboBoost;
    }

    public static int generateRandomX(){
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
                dollars.add( ShapeFactory.shape(whatToSpawn()));
                added=false;
                dollarsToAdd--;
            }
            else
                added=true;

    }

    public boolean spawnDollar(){
        if(timePassed>50-1*level){
            timePassed=0;
            return true;
        }
        else {
            timePassed++;
            return false;
        }
    }

    private String whatToSpawn(){
        int random = new Random().nextInt(100);

        if(random>0 && random<85){
            return "Dollar";
        }
        else if(random>85 && random<95){
            return "Rolex";
        }
        else if(random>95){
            return "Jewel";
        }
        return "Dollar";
    }

}
