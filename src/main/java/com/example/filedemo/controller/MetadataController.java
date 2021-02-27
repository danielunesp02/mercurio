package com.example.filedemo.controller;

import com.example.filedemo.model.Metadata;
import com.example.filedemo.repository.MetadataRepository;
import com.example.filedemo.service.DBFileStorageService;
import com.example.filedemo.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataController {

    private static final Logger logger = LoggerFactory.getLogger(MetadataController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private MetadataRepository metadataRepository;

    @PostMapping(value = "/configureMetadata", consumes = "application/json", produces = "application/json")
    public Metadata configureNFe(@RequestBody Metadata metadata) {

        metadataRepository.save(metadata);

        return metadataRepository.save(metadata);
    }


}
