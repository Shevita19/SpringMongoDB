package com.mongo.testMongo.controller;

import com.mongo.testMongo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mongo.testMongo.service.EmployeeService;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public List<Employee> getAll(){
    return employeeService.getAll();
    }

    @PostMapping ("/")
    public Employee add(@RequestBody Employee emp) {
        return employeeService.add(emp);
    }

    @PutMapping("/")
    public Employee update(@RequestBody Employee emp){

        return employeeService.update(emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") String id)
    {
        employeeService.delete(id);
    }

    @GetMapping("/page")
    public Map<String, Object> getAllEmployeeInPage(@RequestParam(name= "pageno", defaultValue = "0") int pageNo,
                                                    @RequestParam(name= "pagesize", defaultValue = "2") int pageSize,
                                                    @RequestParam(name= "sortby", defaultValue = "id") String sortBy){


    return employeeService.getAllEmployeeInPage(pageNo, pageSize, sortBy);
}


    @GetMapping("/example")
    public List<Employee> getAllByExample(@RequestBody Employee emp){

        return employeeService.getAllByExample(emp);
    }

    @GetMapping("/firstName")
    public List<Employee> getAllByFirstNameStartingWith(@RequestParam(name= "firstname") String firstName){

        return employeeService.getAllByFirstNameStartingWith(firstName);
    }

    @GetMapping("/zipCode")
    public List<Employee> getAllByAddressZipCode(@RequestParam(name= "zipcode") int zipCode){

        return employeeService.getAllByAddressZipCode(zipCode);
    }
    @GetMapping("/salary")
    public List<Employee> getAllBySalaryGreaterThan(@RequestParam(name= "salary") float salary){

        return employeeService.getAllBySalaryGreaterThan(salary);
    }
}
