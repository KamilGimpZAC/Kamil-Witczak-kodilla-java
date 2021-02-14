package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements OrderProcess{
    private static final String NAME = "GlutenFreeShop";
    private FoodProducer foodProducer;
    private OrderDone orderDone;

    public GlutenFreeShop(FoodProducer foodProducer, OrderDone orderDone) {
        this.foodProducer = foodProducer;
        this.orderDone = orderDone;
    }

    @Override
    public NewOrder process() {
        boolean check = orderDone.checkIfCreated();
        String products = foodProducer.getProducts();
        return new NewOrder(check,products,NAME);
    }
}
