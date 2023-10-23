package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
interface OrderPort {
    Product getProductById(final Long productId);

    void save(final Order order);
}
