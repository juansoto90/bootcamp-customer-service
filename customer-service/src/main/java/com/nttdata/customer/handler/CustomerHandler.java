package com.nttdata.customer.handler;

import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class CustomerHandler {

    @Autowired
    private final ICustomerService service;

    public Mono<ServerResponse> create(ServerRequest request){
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        return customerMono.flatMap(service::save)
                .flatMap(c -> ServerResponse.created(URI.create("/customer/".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(c)
                );
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return service.findById(id)
                .flatMap(c -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(c)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByDocumentNumber(ServerRequest request){
        String documentNumber = request.pathVariable("documentNumber");
        return service.findByDocumentNumber(documentNumber)
                .flatMap(c -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(c)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
