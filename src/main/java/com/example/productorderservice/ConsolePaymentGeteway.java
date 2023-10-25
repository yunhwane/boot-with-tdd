package com.example.productorderservice;


import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGeteway implements PaymentGeteway {

    @Override
    public void excute(final int totalPrice, final String cardNumber) {
        System.out.println("결제완료");
    }
}
