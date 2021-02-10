package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private SendInformation sendInformation;
    private CreateOrder createOrder;
    private IsAvailable isAvailable;

    public ProductOrderService(final IsAvailable isAvailable, final SendInformation sendInformation, final CreateOrder createOrder) {
        this.sendInformation = sendInformation;
        this.createOrder = createOrder;
        this.isAvailable = isAvailable;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean available = isAvailable.check(orderRequest.getProduct());

        if (available){
            sendInformation.inform(orderRequest.getUser());
            createOrder.create(orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
