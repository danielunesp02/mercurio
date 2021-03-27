package com.mercurio.controller;

import com.mercurio.model.Customer;
import com.mercurio.repository.CustomerRepository;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public Customer customer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return customerRepository.findAll();

    }

    @GetMapping("/customer/{customerId}")
    public Customer downloadFile(@PathVariable Long customerId) {
        return customerRepository.getOne(customerId);
    }

}
