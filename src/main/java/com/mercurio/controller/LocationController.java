package com.mercurio.controller;

import com.mercurio.model.Location;
import com.mercurio.repository.LocationRepository;
import com.mercurio.repository.MetadataRepository;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping(value = "/location", consumes = "application/json", produces = "application/json")
    public Location location(@RequestBody Location location) {
        return locationRepository.save(location);
    }


}
