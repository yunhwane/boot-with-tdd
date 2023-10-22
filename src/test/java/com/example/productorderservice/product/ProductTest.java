package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    /*
    도메인 로직일때 도메인 테스트 진행하기
    fail test 먼저 진행 하기.
     */
    @Test
    void update() {
        final Product product = new Product("상품명",1000,DiscountPolicy.NONE);

        product.update("상품 수정",2000,DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }
}