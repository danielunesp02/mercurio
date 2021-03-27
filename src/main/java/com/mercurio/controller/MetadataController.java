package com.mercurio.controller;

import com.mercurio.model.Customer;
import com.mercurio.model.Metadata;
import com.mercurio.repository.CustomerRepository;
import com.mercurio.repository.MetadataRepository;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MetadataController {

    private static final Logger logger = LoggerFactory.getLogger(MetadataController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * {@code POST  /metadata}  : Creates a new metadata.
     * <p>
     * Creates a new metadata...
     *
     * @param metadata
     * @return the {@link Metadata} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws
     */

    @PostMapping(value = "/metadata/{customerId}", consumes = "application/json", produces = "application/json")
    public Metadata configureMetadata(@RequestBody Metadata metadata, @PathVariable Long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        metadata.setCustomer(customer);
        return metadataRepository.save(metadata);
    }

    @PutMapping("/metadata/{customerId}/{metadataId}")
    public Metadata updateMetadata(@RequestBody Metadata metadata, @PathVariable Long customerId, @PathVariable Long metadataId) {
        Customer customer = customerRepository.getOne(customerId);
        metadata.setCustomer(customer);
        return metadataRepository.save(metadata);

    }

    @GetMapping("/metadata")
    public List <Metadata> getMetadata() {
        return metadataRepository.findAll();

    }

    @GetMapping("/metadata/{metadataId}")
    public Metadata downloadFile(@PathVariable Long metadataId) {
        return metadataRepository.getOne(metadataId);
    }

}
