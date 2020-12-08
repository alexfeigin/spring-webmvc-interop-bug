package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.*;

import java.util.concurrent.CompletableFuture;

@Configuration
public class TestRoute {

    private final static Logger log = LoggerFactory.getLogger(TestRoute.class);

    @Bean
    RouterFunction<ServerResponse> staticResourceRouter() {
        return RouterFunctions.route()
                .nest(RequestPredicates.path("/a/b").or(RequestPredicates.path("/a")),
                        builder -> builder.path("/{pathVariable}/c",
                                cBuilder -> cBuilder.route(RequestPredicates.path("/e/{connectionId}")
                                        .or(RequestPredicates.path("/e"))
                                        .and(RequestPredicates.method(HttpMethod.POST)), this::method))
                        ).build();
    }

    public ServerResponse method(ServerRequest serverRequest) {
        if (serverRequest != null) {
            log.info("request path: {}, pathVariables: {}", serverRequest.path(), serverRequest.pathVariables());
        }
        return ServerResponse.async(CompletableFuture.supplyAsync(() -> ServerResponse.status(HttpStatus.NOT_FOUND).body("bad")));

    }

}
