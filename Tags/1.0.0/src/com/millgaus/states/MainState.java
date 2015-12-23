package com.millgaus.states;

import com.millgaus.states.utils.AbstractState;
import com.millgaus.states.utils.StateCommmons;
import com.millgaus.utils.Utilities;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-19.
 */
public class MainState extends AbstractState implements StateCommmons{


    Image play;
    Image load;
    Image exit;
    Image logo;

    @Override
    public int getID() {
        return Utilities.getMyId(CLASS_NAME);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        logo = new Image("resources/testo.png");
        play = new Image("resources/buttons/start_new.png");
        load = new Image("resources/buttons/load.png");
        exit = new Image("resources/buttons/exit.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(logo,500,20);
        g.drawString("Millgaus "+ Utilities.gameVersion,1100,700);
        g.drawImage(play, 100,200);
        g.drawImage(load, 100,300);
        g.drawImage(exit, 100,400);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
                getButtonClicked(container, game);

    }

    private boolean isWithinPlayButtonRange(int mouseY, int mouseX, GameContainer container) {

        if(((mouseX>100 && mouseX<100+play.getWidth())&&(container.getHeight() - mouseY>200 && container.getHeight() - mouseY<200+play.getHeight()))) {

            return true;
        }
        else return false;
    }

    private boolean isWithinExitButtonRange(int mouseY, int mouseX, GameContainer container) {

        if(((mouseX>100 && mouseX<100+exit.getWidth())&&(container.getHeight() - mouseY>400 && container.getHeight() - mouseY<400+exit.getHeight()))) {

            return true;
        }
        else return false;
    }

    @Override
    public void getButtonClicked(GameContainer container, StateBasedGame game) {
        if(Mouse.isButtonDown(0)){
            int mouseY = Mouse.getY();
            int mouseX = Mouse.getX();

            if(isWithinPlayButtonRange(mouseY, mouseX, container)){
                game.enterState(Utilities.getMyId("com.millgaus.states.StartGameState"));
            }

            if(isWithinExitButtonRange(mouseY, mouseX, container)){
                System.exit(0);
            }
        }
    }

    @Override
    public void getMouseOverElement(GameContainer container, StateBasedGame game) {

    }
}
