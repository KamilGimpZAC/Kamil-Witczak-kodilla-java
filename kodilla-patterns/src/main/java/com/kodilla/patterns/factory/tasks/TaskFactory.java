package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "ShoppingTask";
    public static final String PAINTINGTASK = "PaintingTask";
    public static final String DRIVINGTASK = "DrivingTask";

    public final Task makeTask(final String taskName){
        switch (taskName){
            case SHOPPINGTASK:
                return new ShoppingTask("ShoppingTask","Milk",5);
            case PAINTINGTASK:
                return new PaintingTask("PaintingTask","red","wall");
            case DRIVINGTASK:
                return new DrivingTask("DrivingTask","Misty Mountains", "eagles");
            default:
                return null;
        }
    }
}
