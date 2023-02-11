package com.mongo.testMongo.service;

import com.mongo.testMongo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongo.testMongo.repository.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAll() {

        return  repository.getAll();
    }

    public List<Employee> add() {
        return null;
    }

    public List<Employee> update() {
        return null;
    }

    public List<Employee> delete() {
        return null;
    }
}
