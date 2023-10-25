package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import com.example.productorderservice.product.DiscountPolicy;
import com.example.productorderservice.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

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
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        final PaymentRequest request = new PaymentRequest(orderId,cardNumber);
        paymentService.payment(request);
    }

    private record PaymentRequest (Long orderId, String cardNumber){
        public PaymentRequest {
            Assert.notNull(orderId, "주문번호는 필수입니다.");
            Assert.notNull(cardNumber, "카드번호는 필수입니다.");

        }
    }

    private class PaymentService {
        private final PaymentPort paymentPort;

        private PaymentService(PaymentPort paymentPort) {
            this.paymentPort = paymentPort;
        }

        public void payment(PaymentRequest request) {

            Order order = paymentPort.getOrder(request.orderId());
            final Payment payment = new Payment(order, request.cardNumber());

            paymentPort.pay(payment);
            paymentPort.save(payment);
        }

    }

    private interface PaymentPort {

        Order getOrder(final Long orderId);

        void pay(Payment payment);

        void save(Payment payment);
    }

    private class Payment {
        private final Order order;
        private final String cardNumber;

        private Long id;

        public Payment(Order order, String cardNumber) {

            Assert.notNull(order, "주문은 필수입니다.");
            Assert.notNull(cardNumber, "카드번호는 필수입니다.");

            this.order = order;
            this.cardNumber = cardNumber;
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

    }

    private class PaymentAdepter implements PaymentPort {

        private final PaymentGeteway paymentGateway;
        private final PaymentRepository paymentRepository;

        private PaymentAdepter(PaymentGeteway paymentGateway, PaymentRepository paymentRepository) {
            this.paymentGateway = paymentGateway;
            this.paymentRepository = paymentRepository;
        }


        @Override
            public Order getOrder(final Long orderId) {
                return new Order(new Product("상품1",1000, DiscountPolicy.NONE), 2);
            }

            @Override
            public void pay(final Payment payment) {
                paymentGateway.excute(payment);
            }

            @Override
            public void save(Payment payment) {
               paymentRepository.save(payment);
            }
    }

    /*
    결제 api 연동 가정 후, 결제 api 호출
     */
    private interface PaymentGeteway {
        void excute(final Payment payment);
    }
    public class ConsolePaymentGeteway implements PaymentGeteway {

        @Override
        public void excute(Payment payment) {
            System.out.println("결제완료");
        }
    }

    private class PaymentRepository {

        private Map<Long,Payment> persistence = new HashMap<>();
        private Long sequence = 0L;
        
        public void save(Payment payment) {
            payment.assignId(++sequence);
            persistence.put(payment.getId(), payment);
        }
    }
}
