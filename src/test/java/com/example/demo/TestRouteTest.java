package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.AsyncServerResponse;
import org.springframework.web.servlet.function.ServerResponse;

class TestRouteTest {


    @Test
    void method() {
        TestRoute testRoute = new TestRoute();
        ServerResponse response = testRoute.method(null);
        if (response instanceof AsyncServerResponse) {
            response = ((AsyncServerResponse) response).block();
        }
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}