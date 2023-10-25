package com.example.productorderservice.product.application.port;

import com.example.productorderservice.product.domain.Product;

interface ProductPort {
    void save(final Product product);
    Product getProduct(final long productId);
}
