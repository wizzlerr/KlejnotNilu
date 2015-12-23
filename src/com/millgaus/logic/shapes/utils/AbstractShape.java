package com.millgaus.logic.shapes.utils;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by adam on 23.12.15.
 */
public abstract class AbstractShape {

    public Rectangle rectangle;
    public Image image;
    public int value;

    public AbstractShape(Rectangle r){
        this.rectangle=r;
    }

    public abstract boolean isType(String type);

}
