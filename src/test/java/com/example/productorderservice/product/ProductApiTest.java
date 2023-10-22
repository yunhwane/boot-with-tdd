package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.awt.*;

import static com.example.productorderservice.product.ProductSteps.상품등록요청;
import static com.example.productorderservice.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductApiTest extends ApiTest {



    @Test
    void 상품등록(){
        final var request = 상품등록요청_생성();
        final var response = 상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
