package com.millgaus.states;

import com.millgaus.logic.Game;
import com.millgaus.states.utils.AbstractState;
import com.millgaus.states.utils.StateCommmons;
import com.millgaus.utils.Utilities;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam on 2015-12-19.
 */
public class StartGameState extends AbstractState implements StateCommmons {

    private Game thisGame;
    Image test;
    Rectangle r;
    Color colorAlpha = new Color(1f,1f,1f,0.5f);


    @Override
    public int getID() {
        return Utilities.getMyId(CLASS_NAME);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        thisGame=new Game();
        test = new Image("resources/testoo.png");
        r=new Rectangle(mousePosX(),720-200,100,200);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.setAntiAlias(true);
        g.texture(r, new Image("resources/trans.png"), true);
        g.drawImage(test,mousePosX(),720-200);
        g.drawString("Score: "+thisGame.getScore(),50,100);
        g.drawString("Mistakes: "+thisGame.getLeftMistakes(),50,120);
        g.drawString("Balls: "+thisGame.dollars.size(),50,140);
        g.drawString("Level: "+thisGame.level,50,160);

        if(!thisGame.gameOver){
            for (Rectangle i : thisGame.dollars) {
                g.texture(i, new Image("resources/dolar.jpg"), true);
            }
        }
        else{
            g.drawString("Game Over",640,360);
        }





    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        if(thisGame.leftMistakes==0){
            thisGame.gameOver=true;
        }
        dollarsRenderAndLogic();
        getCheckLevel();
    }

    private void getCheckLevel() {
        if(!thisGame.gameOver&&thisGame.dollars.size()==0){
            thisGame=new Game(thisGame.level+=1,thisGame.leftMistakes+=thisGame.level,false,thisGame.score);
        }
    }

    private void rolexRenderAndLogic() {
        r=new Rectangle(mousePosX(),720-200,100,200);
        if(thisGame.spawnDollar()&&!thisGame.added){
            thisGame.generateDollars();
        }

        for(int i = thisGame.dollars.size()-1;i>=0;i--){
            thisGame.dollars.get(i).setCenterY(thisGame.dollars.get(i).getCenterY()+1);
            if(thisGame.dollars.get(i).getCenterY()>=720){
                thisGame.leftMistakes-=1;
                thisGame.dollars.remove(i);
            }
            if(isInterSectsTesto(thisGame.dollars.get(i))){
                thisGame.dollars.remove(i);
                thisGame.hitDolar();
            }
        }
    }

    private void dollarsRenderAndLogic() {
        r=new Rectangle(mousePosX(),720-200,100,200);
        if(thisGame.spawnDollar()&&!thisGame.added){
            thisGame.generateDollars();
        }

        for(int i = thisGame.dollars.size()-1;i>=0;i--){
            thisGame.dollars.get(i).setCenterY(thisGame.dollars.get(i).getCenterY()+1*thisGame.level);
            if(thisGame.dollars.get(i).getCenterY()>=720){
                thisGame.leftMistakes-=1;
                thisGame.dollars.remove(i);
            }
            if(isInterSectsTesto(thisGame.dollars.get(i))){
                thisGame.dollars.remove(i);
                thisGame.hitDolar();
            }
        }
    }

    private boolean isInterSectsTesto(Rectangle r) {
        return r.intersects(this.r);
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
