package com.kodilla.good.patterns.challenges;

public class NewOrder {
    public OrderRequest newOrder() {
        User user = new User("John", "xJohnx");
        Product product = new Product(12143);
        return new OrderRequest(user,product);
    }
}
