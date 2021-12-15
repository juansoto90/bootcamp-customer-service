package com.nttdata.customer.config;

import com.nttdata.customer.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(CustomerHandler handler){
        return route(GET("/customer/{id}"), handler::findById)
                .andRoute(GET("/customer/circuit/{id}"), handler::findByIdCircuitBreaker)
                .andRoute(GET("/customer/message/{id}"), handler::messageErrorFallBack)
                .andRoute(GET("/customer/document-number/{documentNumber}"), handler::findByDocumentNumber)
                .andRoute(POST("/customer"), handler::create);
    }
}
