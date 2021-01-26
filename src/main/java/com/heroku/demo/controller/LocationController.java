package com.heroku.demo.controller;


import com.heroku.demo.model.City;
import com.heroku.demo.model.Record;
import com.heroku.demo.model.State;
import com.heroku.demo.repository.CityRepository;
import com.heroku.demo.repository.LocationRepository;
import com.heroku.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/locations")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel(@RequestBody Record hotel, HttpServletRequest request, HttpServletResponse response) {
        //Record createdHotel = this.repository.save(hotel);
    }


    @GetMapping
    public City retrieveCity() {
        City city = new City();

        return city;
    }

    @PostMapping(value = "/configureNFe", consumes = "application/json", produces = "application/json")
    public City configureNFe(@RequestBody City city) {

        cityRepository.save(city);

        return cityRepository.save(city);
    }


}