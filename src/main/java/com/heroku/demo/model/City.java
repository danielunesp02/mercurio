package com.heroku.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "state_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private State state;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nfs_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Nfs nfs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Nfs getNfs() {
        return nfs;
    }

    public void setNfs(Nfs nfs) {
        this.nfs = nfs;
    }
}
