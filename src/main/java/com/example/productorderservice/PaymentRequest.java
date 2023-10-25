package com.example.productorderservice;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest {
        Assert.notNull(orderId, "주문번호는 필수입니다.");
        Assert.notNull(cardNumber, "카드번호는 필수입니다.");

    }
}
