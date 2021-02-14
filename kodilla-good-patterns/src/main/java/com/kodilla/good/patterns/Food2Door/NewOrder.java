package com.kodilla.good.patterns.Food2Door;

public class NewOrder{
    private boolean isCreated;
    private String products;
    private String companyName;

    public NewOrder(boolean isCreated, String products, String companyName) {
        this.isCreated = isCreated;
        this.products = products;
        this.companyName = companyName;
        System.out.println("Order for company: " + companyName + " ," + products + " ,created?: " + isCreated);
    }
}
