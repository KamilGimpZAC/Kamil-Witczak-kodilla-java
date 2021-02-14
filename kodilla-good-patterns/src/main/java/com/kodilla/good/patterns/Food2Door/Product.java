package com.kodilla.good.patterns.Food2Door;

public class Product implements FoodProducer{
    private int id;
    private int amount;

    public Product(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String getProducts() {
        return "product id: " + id + " ,amount: " + amount;
    }
}
