package com.kodilla.good.patterns.Food2Door;

public class HealthyShop implements FoodProducer{
    private static final String NAME = "HealthyShop";
    public static NewOrder newOrder;

    @Override
    public String getNAME() {
        return NAME;
    }
}
