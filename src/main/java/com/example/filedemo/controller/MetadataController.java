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

    @PostMapping(value = "/metadata/{locationId}", consumes = "application/json", produces = "application/json")
    public Metadata configureMetadata(@RequestBody Metadata metadata, @PathVariable Long locationId) {
        Location location = locationRepository.getOne(locationId);
        metadata.setLocation(location);
        return metadataRepository.save(metadata);
    }

    @PutMapping("/metadata/{locationId}/{metadataId}")
    public Metadata updateMetadata(@RequestBody Metadata metadata, @PathVariable Long locationId, @PathVariable Long metadataId) {
        Location location = locationRepository.getOne(locationId);
        metadata.setLocation(location);
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
