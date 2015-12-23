package com.millgaus.states.utils;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-20.
 */
public interface MapCommons {

    boolean clickedInsideCircle(GameContainer container, int mouseY, int mouseX, int planetPosY, int planetPosX);
}
