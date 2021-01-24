package com.heroku.demo.controller;


import com.heroku.demo.RecordRepository;
import com.heroku.demo.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/locations")
public class LocationController {

    @Autowired
    private RecordRepository repository;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel(@RequestBody Record hotel, HttpServletRequest request, HttpServletResponse response) {
        Record createdHotel = this.repository.save(hotel);
    }

}