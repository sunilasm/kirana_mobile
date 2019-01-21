package com.example.hp.aha.activity.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerModel implements Serializable{

    private String email;
    private String firstname;
    private String lastname;
    private ArrayList<AddressModel> addresses;

    public ArrayList<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
