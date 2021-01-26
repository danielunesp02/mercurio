package com.heroku.demo.controller;


import com.heroku.demo.model.Record;
import com.heroku.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/example/v1/hotels")
public class RestController {

    @Autowired
    private RecordRepository repository;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel(@RequestBody Record hotel, HttpServletRequest request, HttpServletResponse response) {
        Record createdHotel = this.repository.save(hotel);
    }

}