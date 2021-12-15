package com.nttdata.customer.service;

import com.nttdata.customer.entity.Customer;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<Customer> findByDocumentNumber(String documentNumber);
    Mono<Customer> findById(String id);
    Mono<Customer> findByName(String name);
    Mono<Customer> save(Customer customer);
}
