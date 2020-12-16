package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String shapeName;

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public int getField() {
        return 0;
    }

    @Override
    public String toString() {
        return "Name: " + getShapeName() + ", field: " + getField() + " ";
    }
}
