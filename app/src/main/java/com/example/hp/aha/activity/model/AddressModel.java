package com.example.hp.aha.activity.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressModel implements Serializable{

    private String customerId;
    private String firstname;
    private String lastname;
    private String postcode;
    private String city;
    private String telephone;
    private String countryId;
    private boolean defaultShipping;
    private boolean defaultBilling;

    private ArrayList<String> street;

    public boolean isDefaultShipping() {
        return defaultShipping;
    }

    public boolean isDefaultBilling() {
        return defaultBilling;
    }

    public ArrayList<String> getStreet() {
        return street;
    }

    public void setStreet(ArrayList<String> street) {
        this.street = street;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean getDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        this.defaultShipping = defaultShipping;
    }

    public boolean getDefaultBilling() {
        return defaultBilling;
    }

    public void setDefaultBilling(boolean defaultBilling) {
        this.defaultBilling = defaultBilling;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

      public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
