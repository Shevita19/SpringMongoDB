package com.mongo.testMongo.service;

import com.mongo.testMongo.model.Employee;
import com.mongo.testMongo.model.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongo.testMongo.repository.EmployeeRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {

        return  employeeRepository.findAll();
    }

    public Employee add(Employee emp)
        {
        return employeeRepository.insert(emp);
    }

    public Employee update(Employee emp) {

        return employeeRepository.save(emp);
    }

    public void delete (String id) {
        employeeRepository.deleteById(id);

    }

    public  Map<String, Object> getAllEmployeeInPage(int pageNo, int pageSize, String sortBy) {

        Map<String,Object> response = new HashMap<String, Object>();
        Sort sort= Sort.by(sortBy);
        Pageable page = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> employeePage=  employeeRepository.findAll(page);
        response.put("data", employeePage.getContent());
        response.put("Total no of Page", employeePage.getTotalPages());
        response.put("Total no of Elements", employeePage.getTotalElements());
        response.put("Current Page no", employeePage.getNumber());
        return response;
    }

    public List<Employee> getAllByExample(Employee emp) {

       // ExampleMatcher matcher= ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("lastName", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.ENDING));  //Custom matcher
        // Example<Employee> e = Example.of(emp, matcher);                  //we use matcher for defined field
        Example<Employee> e = Example.of(emp);                              //Can search with any field
        return employeeRepository.findAll(e);
    }

    public List<Employee> getAllByFirstNameStartingWith(String firstName) {
        return employeeRepository.findByFirstNameStartingWith(firstName);
    }

    public List<Employee> getAllByAddressZipCode(int zipCode) {
        return employeeRepository.findByAddressZipCode(zipCode);
    }

    public List<Employee> getAllBySalaryGreaterThan(float salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public List<Employee> getAllByEmployeeType(EmployeeType employeeType) {

        return employeeRepository.findAllByEmployeeType(employeeType);
    }

    public List<Employee> getAllByEmployeeTypeList(List<EmployeeType> employeeTypeList) {
        return employeeRepository.findAllByEmployeeTypeIn(employeeTypeList);                     // method name same as repository
    }
}
