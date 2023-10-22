package com.example.productorderservice.product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {


    @Autowired
    private ProductService productService;

    @Test
    void 상품조회(){
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        final long productId = 1L;
        // 상품 조회
        final GetProductResponse response = productService.getProduct(productId);
        // 상품 응답 검증 -> 결과값을 먼저 설정하고, 테스트 기능을 만드는 것이 더욱 깔끔한 코드 작성 가능
        assertThat(response).isNotNull();
    }
}
