package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {

        ResponseEntity<String> entity = restTemplate
                .postForEntity("http://localhost:" + this.port + "/a/b/var1/c/e/var2", null, String.class, "Arcade");

        Assertions.assertThat(entity.getStatusCode())
                .as("/ is FOUND")
                .isEqualTo(HttpStatus.OK);

    }

}
