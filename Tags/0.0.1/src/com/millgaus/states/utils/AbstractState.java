package com.millgaus.states.utils;

import com.millgaus.utils.Utilities;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-20.
 */
public abstract class AbstractState extends BasicGameState {
    public final String CLASS_NAME = this.getClass().getName();
    public Utilities utility = new Utilities(CLASS_NAME);

    @Override
    public int getID() {
        return Utilities.getMyId(CLASS_NAME);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

}
