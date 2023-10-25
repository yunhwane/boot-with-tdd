package com.example.productorderservice.product.domain;

public enum DiscountPolicy {
    NONE{
        @Override
        int applyDiscount(final int price) {
            return price;
        }
    },
    Fix_1000_AMOUNT{
        @Override
        int applyDiscount(final int price) {
            return Math.max(price - 1000, 0);
        }
    };

    abstract int applyDiscount(final int price);


}
