package com.example.filedemo.controller;

import com.example.filedemo.model.Location;
import com.example.filedemo.model.Metadata;
import com.example.filedemo.repository.LocationRepository;
import com.example.filedemo.repository.MetadataRepository;
import com.example.filedemo.service.DBFileStorageService;
import com.example.filedemo.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    private LocationRepository locationRepository;

    /**
     * {@code POST  /metadata}  : Creates a new metadata.
     * <p>
     * Creates a new metadata...
     *
     * @param metadata
     * @return the {@link Metadata} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws
     */

    @PostMapping(value = "/metadata", consumes = "application/json", produces = "application/json")
    public Metadata configureMetadata(@RequestBody Metadata metadata) {
        Location location = locationRepository.getOne(new Long(6));
        metadata.setLocation(location);

        return metadataRepository.save(metadata);
    }

    @PutMapping("/metadata")
    public Metadata updateMetadata(@RequestBody Metadata metadata) {
        return metadataRepository.save(metadata);

    }

    @GetMapping("/metadata")
    public List <Metadata> getMetadata() {
        return metadataRepository.findAll();

    }



}
