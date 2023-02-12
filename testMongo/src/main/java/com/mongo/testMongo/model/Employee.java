package com.mongo.testMongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
@Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Float salary;

    public Employee(){
        super();
    }

    public Employee(String firstName,  String lastName, Address address, Float salary) {
       super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary= salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
