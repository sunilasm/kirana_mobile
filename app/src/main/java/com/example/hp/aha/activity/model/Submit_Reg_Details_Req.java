package com.example.hp.aha.activity.model;

import java.util.ArrayList;

public class Submit_Reg_Details_Req {
    // check full request json below last...
    private String customerId;
    private String regionId;
    private String countryId;
    private ArrayList<AddressModel> street;
    private String INDIA;
    private String telephone;
    private String postcode;
    private String city;
    private String firstname;
    private String lastname;
    private String middlename;
    private boolean defaultShipping;
    private boolean defaultBilling;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public ArrayList<AddressModel> getStreet() {
        return street;
    }

    public void setStreet(ArrayList<AddressModel> street) {
        this.street = street;
    }

    public String getINDIA() {
        return INDIA;
    }

    public void setINDIA(String INDIA) {
        this.INDIA = INDIA;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public boolean isDefaultShipping() {
        return defaultShipping;
    }

    public void setDefaultShipping(boolean defaultShipping) {
        this.defaultShipping = defaultShipping;
    }

    public boolean isDefaultBilling() {
        return defaultBilling;
    }

    public void setDefaultBilling(boolean defaultBilling) {
        this.defaultBilling = defaultBilling;
    }
}
/*    {
        "id": 0,
            "region": "string",
            "regionId": 0,
            "regionCode": "string",
            "countryId": "string",
            "street": [
        "string"
  ],
        "company": "string",
            "telephone": "string",
            "fax": "string",
            "postcode": "string",
            "city": "string",
            "firstname": "string",
            "lastname": "string",
            "middlename": "string",
            "prefix": "string",
            "suffix": "string",
            "vatId": "string",
            "customerId": 0,
            "email": "string",
            "sameAsBilling": 0,
            "customerAddressId": 0,
            "saveInAddressBook": 0,
            "extensionAttributes": {
        "giftRegistryId": 0
    },
        "customAttributes": [
        {
            "attributeCode": "string",
                "value": "string"
        }
  ]
    }
}*/
