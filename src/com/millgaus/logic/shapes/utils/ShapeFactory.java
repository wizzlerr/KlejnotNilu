package com.millgaus.logic.shapes.utils;

import com.millgaus.logic.shapes.Dollar;
import com.millgaus.logic.shapes.Jewel;
import com.millgaus.logic.shapes.Rolex;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by adam on 23.12.15.
 */
public class ShapeFactory {

    public static AbstractShape shape(String type){
        if(type.equals("Jewel"))
            return new Jewel();
        else if(type.equals("Rolex"))
            return new Rolex();
        else
        return new Dollar();
    }
}
