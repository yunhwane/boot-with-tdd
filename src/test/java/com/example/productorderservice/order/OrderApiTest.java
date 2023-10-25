package com.example.productorderservice.order;


import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductService;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.awt.*;
import java.net.http.HttpResponse;

import static com.example.productorderservice.order.OrderSteps.상품주문요청;
import static com.example.productorderservice.order.OrderSteps.상품주문요청_생성;
import static org.assertj.core.api.Assertions.assertThat;


public class OrderApiTest extends ApiTest {


    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final var request = 상품주문요청_생성();
        final var response = 상품주문요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
