package com.example.homework2_4collections.controller;

import com.example.homework2_4collections.employeeService.EmployeeService;
import com.example.homework2_4collections.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus
@RequestMapping("employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public boolean addAnEmployee(@RequestParam String name,
                       @RequestParam String surname) {
        return employeeService.addAnEmployee(name,surname);
    }
    @GetMapping("/remove")
    public Employee removeAnEmployee(@RequestParam String name,
                                     @RequestParam String surname) {
        return employeeService.removeAnEmployee(name, surname);
    }
    @GetMapping("/find")
    public Employee findAnEmployee(@RequestParam String name,
                                   @RequestParam String surname) {
        return employeeService.findAnEmployee(name, surname);
    }


}
