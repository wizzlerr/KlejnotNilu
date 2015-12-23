package com.millgaus.logic.shapes;

import com.millgaus.logic.Game;
import com.millgaus.logic.shapes.utils.AbstractShape;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by adam on 23.12.15.
 */
public class Jewel extends AbstractShape{

    public Jewel(){
        super(new Rectangle(Game.generateRandomX(), 0, 60, 60));
        try {
            this.image=new Image("resources/klejnot.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        value=20;
    }

    @Override
    public boolean isType(String type) {
        if(this.getClass().getName().contains(type))
            return true;
        else return false;
    }
}
