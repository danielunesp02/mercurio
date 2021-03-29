package com.mercurio.controller;

import com.mercurio.model.Customer;
import com.mercurio.model.DocumentAttribute;
import com.mercurio.repository.CustomerRepository;
import com.mercurio.repository.DocumentAttributeRepository;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentAttributeController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentAttributeController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private DocumentAttributeRepository documentAttributeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * {@code POST  /documentAttribute}  : Creates a new metadata.
     * <p>
     * Creates a new documentAttribute...
     *
     * @param documentAttributes
     * @return the {@link DocumentAttribute} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws
     */

    @PostMapping(value = "/documentAttribute/{customerId}", consumes = "application/json", produces = "application/json")
    public DocumentAttribute configureDocumentAttribute(@RequestBody DocumentAttribute documentAttributes, @PathVariable Long customerId) {
        Customer customer = customerRepository.getOne(customerId);

        documentAttributes.setCustomer(customer);

        DocumentAttribute ml = documentAttributeRepository.save(documentAttributes);
        return ml;
    }

    @PutMapping("/documentAttribute/{customerId}/{metadataId}")
    public DocumentAttribute updateDocumentAttribute(@RequestBody DocumentAttribute documentAttributes, @PathVariable Long customerId, @PathVariable Long metadataId) {
        Customer customer = customerRepository.getOne(customerId);
        documentAttributes.setCustomer(customer);
        return documentAttributeRepository.save(documentAttributes);

    }

    @GetMapping("/documentAttribute")
    public List <DocumentAttribute> getDocumentAttribute() {
        return documentAttributeRepository.findAll();

    }

    @GetMapping("/documentAttribute/{metadataId}")
    public DocumentAttribute downloadFile(@PathVariable Long metadataId) {
        return documentAttributeRepository.getOne(metadataId);
    }

}
