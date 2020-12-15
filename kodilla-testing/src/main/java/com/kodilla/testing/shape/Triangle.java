package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String shapeName;

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public int getField() {
        return 0;
    }
}
