package com.example.productorderservice.payment;

/*
결제 api 연동 가정 후, 결제 api 호출
 */


public interface PaymentGeteway {
    void excute(final int totalPrice, final String cardNumber);
}
