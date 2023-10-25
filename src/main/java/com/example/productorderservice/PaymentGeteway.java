package com.example.productorderservice;

/*
결제 api 연동 가정 후, 결제 api 호출
 */


import org.springframework.stereotype.Component;

@Component
public interface PaymentGeteway {
    void excute(final int totalPrice, final String cardNumber);
}
