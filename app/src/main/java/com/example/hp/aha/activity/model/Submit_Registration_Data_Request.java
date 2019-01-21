package com.example.hp.aha.activity.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Submit_Registration_Data_Request implements Serializable {


    private CustomerModel customer;


    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
