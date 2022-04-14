package com.dogather.delivious.domain.customer.controller;

import com.dogather.delivious.domain.customer.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {this.customerRepository = customerRepository;}

    @GetMapping
    public ResponseEntity getAllCustomers() {
        return CustomerRepository.ok(this.customerRepository.findAll());
    }

}
