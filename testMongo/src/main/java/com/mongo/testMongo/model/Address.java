package com.mongo.testMongo.model;

import lombok.Data;

@Data
public class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private int zipCode;



    public Address(String line1, String line2, String city, String state, int zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


}
