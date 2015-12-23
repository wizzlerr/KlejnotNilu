package com.millgaus.utils;

import org.newdawn.slick.*;
import org.newdawn.slick.util.ResourceLoader;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Adam on 2015-12-19.
 */
public class Utilities {
    public static HashMap<String, Integer> gameStates = new HashMap<String, Integer>();
    public static int gameStatesId = 0;
    public static int currentGameState = 0;
    public final static String gameVersion = "1.0.0";

    public Image backgound;

    public Utilities(String className){
        getUpdateGameStats(className);
        gameStatesId++;
    }

    private void getUpdateGameStats(String className) {
        gameStates.put(className,gameStatesId);
    }

    public static int getMyId(String className){
        return gameStates.get(className);
    }

    public static int getMidScreenX(Image img, GameContainer container){
        return container.getWidth()/2-img.getWidth()/2;
    }

}
