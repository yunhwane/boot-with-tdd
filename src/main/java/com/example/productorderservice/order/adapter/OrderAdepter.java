package com.example.productorderservice.order.adapter;


import com.example.productorderservice.order.OrderPort;
import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.product.domain.Product;
import com.example.productorderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;


@Component
class OrderAdepter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdepter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    public void save(final Order order) {
        orderRepository.save(order);
    }
}
