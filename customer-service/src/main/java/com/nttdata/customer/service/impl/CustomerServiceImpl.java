package com.nttdata.customer.service.impl;

import com.nttdata.customer.repository.ICustomerRepository;
import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository repository;

    @Override
    public Mono<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Customer> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Mono<Customer> findByCustomerIdNumber(String customerIdNumber) {
        return repository.findByCustomerIdNumber(customerIdNumber);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }
}
