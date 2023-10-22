package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse (long id, String name, int price, DiscountPolicy discountPolicy) {

    GetProductResponse{
        Assert.notNull(id,"상품 아이디는 필수 입니다.");
        Assert.hasText(name,"상품명은 필수 입니다.");
        Assert.isTrue(price>0,"상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy,"할인정책은 필수 입니다.");
    }
}
