package com.heroku.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Nfs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String nfsCode;

    @NotEmpty
    private String totalValue;

    @NotEmpty
    private String iss;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private City city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNfsCode() {
        return nfsCode;
    }

    public void setNfsCode(String nfsCode) {
        this.nfsCode = nfsCode;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }
}
