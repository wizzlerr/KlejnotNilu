package com.millgaus.states.utils;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-19.
 */
public interface StateCommmons {

   void getButtonClicked(GameContainer container, StateBasedGame game) throws SlickException;
   void getMouseOverElement(GameContainer container, StateBasedGame game) throws SlickException;
}
