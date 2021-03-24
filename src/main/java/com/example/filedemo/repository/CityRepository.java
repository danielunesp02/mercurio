package com.example.filedemo.repository;

import com.example.filedemo.model.City;
import com.example.filedemo.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
