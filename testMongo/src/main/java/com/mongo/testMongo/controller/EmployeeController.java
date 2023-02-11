package com.mongo.testMongo.controller;

import com.mongo.testMongo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mongo.testMongo.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @GetMapping("/gett")
    public List<Employee> getAll(){
    return service.getAll();
    }

    @PostMapping ("/")
    public List<Employee> add(){
        return service.add();
    }

    @PutMapping("/")
    public List<Employee> update(){
        return service.update();
    }

    @DeleteMapping("/")
    public List<Employee> delete(){
        return service.delete();
    }

}
