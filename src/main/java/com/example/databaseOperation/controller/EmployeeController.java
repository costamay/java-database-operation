package com.example.databaseOperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.databaseOperation.model.Employee;
import com.example.databaseOperation.repository.EmployeeJDBCRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeJDBCRepository employeeRepository;

    @PostMapping("create")
    public int createEmployee(@RequestBody Employee employee) {
        return employeeRepository.insert(employee);
    }

    @GetMapping("all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public int delete(@PathVariable long id) {
        return employeeRepository.deleteById(id);
    }

    @GetMapping("find/{id}")
    public Optional<Employee> find(@PathVariable long id) {
        return employeeRepository.findById(id);

    }



    @PutMapping("update/")
    public int update(@RequestBody Employee employee){
        return employeeRepository.update(employee);
    }
}
