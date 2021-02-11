package com.kodilla.good.patterns.Food2Door;

public class Product {
    private int id;
    private int amount;

    public Product(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
