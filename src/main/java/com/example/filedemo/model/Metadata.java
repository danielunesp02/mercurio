package com.example.filedemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String documentCode;

    @NotEmpty
    private String nfsCode;

    @NotEmpty
    private String totalValue;

    @NotEmpty
    private String iss;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
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

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
