package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements FoodProducer{
    private static final String NAME = "GlutenFreeShop";
    public static NewOrder newOrder;

    @Override
    public String getNAME() {
        return NAME;
    }
}
