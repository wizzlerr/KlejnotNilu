package com.millgaus.main;

import com.millgaus.states.MainState;
import com.millgaus.states.StartGameState;
import com.millgaus.utils.Utilities;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-19.
 */
public class KlejnotNilu extends StateBasedGame {
    /**
     * Create a new basic game
     *
     * @param title The title for the game
     */

    public KlejnotNilu(String title) {
        super(title);
    }

    public static void main (String[] args) throws SlickException {
        AppGameContainer appGameContainer = new AppGameContainer(new KlejnotNilu("Klejnot Nilu "+ Utilities.gameVersion));
        appGameContainer.setDisplayMode(1280,720,false);
        appGameContainer.setTargetFrameRate(60);
        appGameContainer.start();

    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new MainState());
        this.addState(new StartGameState());
    }


}
