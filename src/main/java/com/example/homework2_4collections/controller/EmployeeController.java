package com.example.homework2_4collections.controller;

import com.example.homework2_4collections.employeeService.EmployeeService;
import com.example.homework2_4collections.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                       @RequestParam String lastName) {
        return employeeService.add(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                     @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll(){
       return employeeService.findAll();

    }



}
