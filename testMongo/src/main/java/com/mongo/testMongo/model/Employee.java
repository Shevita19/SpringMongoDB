package com.mongo.testMongo.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Float salary;

    private EmployeeType employeeType;

    public Employee(String firstName,  String lastName, Address address, Float salary, EmployeeType employeeType) {
       super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary= salary;
        this.employeeType= employeeType;
    }

}
