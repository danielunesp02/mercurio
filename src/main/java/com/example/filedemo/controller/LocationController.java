package com.example.filedemo.controller;

import com.example.filedemo.model.City;
import com.example.filedemo.model.Location;
import com.example.filedemo.model.Metadata;
import com.example.filedemo.repository.CityRepository;
import com.example.filedemo.repository.LocationRepository;
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
