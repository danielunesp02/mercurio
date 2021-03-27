package com.mercurio.controller;

import com.mercurio.model.Customer;
import com.mercurio.model.MetadataList;
import com.mercurio.repository.CustomerRepository;
import com.mercurio.repository.MetadataListRepository;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MetadataListController {

    private static final Logger logger = LoggerFactory.getLogger(MetadataListController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private MetadataListRepository metadataListRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * {@code POST  /metadata}  : Creates a new metadata.
     * <p>
     * Creates a new metadata...
     *
     * @param metadataList
     * @return the {@link MetadataList} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws
     */

    @PostMapping(value = "/metadataList/{customerId}", consumes = "application/json", produces = "application/json")
    public MetadataList configureMetadataList(@RequestBody MetadataList metadataList, @PathVariable Long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        MetadataList ml = metadataListRepository.save(metadataList);
        ml.setCustomer(customer);
        return ml;
    }

    @PutMapping("/metadataList/{customerId}/{metadataId}")
    public MetadataList updateMetadataList(@RequestBody MetadataList metadataList, @PathVariable Long customerId, @PathVariable Long metadataId) {
        Customer customer = customerRepository.getOne(customerId);
        metadataList.setCustomer(customer);
        return metadataListRepository.save(metadataList);

    }

    @GetMapping("/metadataList")
    public List <MetadataList> getMetadataList() {
        return metadataListRepository.findAll();

    }

    @GetMapping("/metadataList/{metadataId}")
    public MetadataList downloadFile(@PathVariable Long metadataId) {
        return metadataListRepository.getOne(metadataId);
    }

}
