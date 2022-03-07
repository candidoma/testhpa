package com.candidoma.controller;

import com.candidoma.entity.Employee;
import com.candidoma.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeRepository repo;

    @GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAll() {
        log.info("Listing all employees");
        List<Employee> employees = repo.findAll();
        log.info("Found "+employees.size()+ " elements");
        return ResponseEntity.ok(employees);
    }

    @GetMapping(value = "/employees/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        log.info("Get Employee by id "+id);
        Optional<Employee> employee=repo.findById(id);
        if ( employee.isEmpty() ){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(employee.get());
        }
    }
}
