package com.millgaus.states;

import com.millgaus.logic.Game;
import com.millgaus.states.utils.AbstractState;
import com.millgaus.states.utils.StateCommmons;
import com.millgaus.utils.Utilities;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-19.
 */
public class StartGameState extends AbstractState implements StateCommmons {

    private Game thisGame;
    Image test;
    Rectangle r;


    @Override
    public int getID() {
        return Utilities.getMyId(CLASS_NAME);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        thisGame=new Game();
        test = new Image("resources/testoo.png");
        r=new Rectangle(thisGame.generateRandomX(),0,119,50);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(test,mousePosX(),720-200);
        g.drawString("Score: "+thisGame.getScore(),50,100);
        g.drawString("Mistakes: "+thisGame.getLeftMistakes(),50,120);

        for (Rectangle i : thisGame.dollars)
            g.texture(i, new Image("resources/dolar.jpg"), true);



    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        if(thisGame.spawnDollar()){
            thisGame.generateDollars();
        }

        for(Rectangle i:thisGame.dollars){
            i.setCenterY(i.getCenterY()+1);
            if(i.getCenterY()==0)
                thisGame.leftMistakes-=1;
        }

        System.out.println(thisGame.leftMistakes);
    }


    @Override
    public void getButtonClicked(GameContainer container, StateBasedGame game) throws SlickException {


    }



    @Override
    public void getMouseOverElement(GameContainer container, StateBasedGame game) throws SlickException {

    }

    private int mousePosX(){
        if(Mouse.getX()>1280-149)
            return 1280-149;
        else return Mouse.getX();
    }

}
