package com.example.filedemo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String location;

    //@OneToOne(mappedBy = "location")
    //private City city;

    @Column(nullable = false)
    private String identifier;

    @OneToMany(targetEntity = Metadata.class)
    private List<Metadata> metadata;


    public Location() {
    }

    public Location(String location) {
        super();
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }
}
