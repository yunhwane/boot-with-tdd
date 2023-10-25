package com.example.productorderservice;

import com.example.productorderservice.order.Order;

public interface PaymentPort {

    Order getOrder(final Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
