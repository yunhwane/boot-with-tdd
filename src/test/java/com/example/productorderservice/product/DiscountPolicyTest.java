package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountPolicyTest {

    @Test
    void applyDiscount() {
        final int price = 10000;

        final int discountPrice = DiscountPolicy.Fix_1000_AMOUNT.applyDiscount(price);

        assertEquals(9000, discountPrice);
    }

    @Test
    void noneDiscountPrice() {
        final int price = 10000;

        final int discountPrice = DiscountPolicy.NONE.applyDiscount(price);

        assertEquals(10000, discountPrice);
    }

    @Test
    void exceptionDiscountPrice() {
        final int price = 0;

        final int discountPrice = DiscountPolicy.Fix_1000_AMOUNT.applyDiscount(price);

        assertEquals(0, discountPrice);
    }

}