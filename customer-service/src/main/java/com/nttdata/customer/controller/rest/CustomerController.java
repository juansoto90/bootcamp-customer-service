package com.nttdata.customer.controller.rest;

import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id){
        return iCustomerService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Mono<Customer> findByName(@PathVariable String name){
        return iCustomerService.findByName(name);
    }

    @GetMapping("/number/{number}")
    public Mono<Customer> findByCustomerIdNumber(@PathVariable String number){
        return iCustomerService.findByCustomerIdNumber(number);
    }

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer){
        return iCustomerService.save(customer);
    }
}
