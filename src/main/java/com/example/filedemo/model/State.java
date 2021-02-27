package com.example.filedemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String acronym;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private Collection<City> cities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<City> getCities() {
        return cities;
    }

    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }
}
