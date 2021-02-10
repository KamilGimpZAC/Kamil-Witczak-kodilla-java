package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User user;
    private boolean isAvailable;
    private Product product;

    public OrderDto(User user, boolean isAvailable) {
        this.user = user;
        this.isAvailable = isAvailable;
    }

    public User getUser() {
        return user;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
