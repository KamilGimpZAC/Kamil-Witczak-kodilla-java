package com.kodilla.testing.shape;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapeList = new LinkedList<>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (shapeList.contains(shape)) {
            shapeList.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n){
        Shape figure = shapeList.get(n);
        return figure;
    }

    public String showFigures(){
        String result = "";
        for(Shape shapeStirng: shapeList) {
            result += shapeStirng.toString();
        }
        return result;
    }
}
