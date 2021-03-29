package com.mercurio.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class DocumentAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String key;
    private String value;

    @ColumnDefault("true")
    private boolean enable;
    private String validationMessage;
    private String validationPositiveMessage;
    private String validationNegativeMessage;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String colorOk;
    private String colorError;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getValidationPositiveMessage() {
        return validationPositiveMessage;
    }

    public void setValidationPositiveMessage(String validationPositiveMessage) {
        this.validationPositiveMessage = validationPositiveMessage;
    }

    public String getValidationNegativeMessage() {
        return validationNegativeMessage;
    }

    public void setValidationNegativeMessage(String validationNegativeMessage) {
        this.validationNegativeMessage = validationNegativeMessage;
    }

    public String getColorOk() {
        return colorOk;
    }

    public void setColorOk(String colorOk) {
        this.colorOk = colorOk;
    }

    public String getColorError() {
        return colorError;
    }

    public void setColorError(String colorError) {
        this.colorError = colorError;
    }
}
