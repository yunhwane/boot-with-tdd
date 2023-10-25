package com.example.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.productorderservice.payment.PaymentSteps.주문결제요청_생성;

public class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        final PaymentGeteway paymentGateway = new ConsolePaymentGeteway();
        PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdepter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        final PaymentRequest request = 주문결제요청_생성();
        paymentService.payment(request);
    }

}
