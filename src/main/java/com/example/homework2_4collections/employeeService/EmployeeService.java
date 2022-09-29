package com.example.homework2_4collections.employeeService;

import com.example.homework2_4collections.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee find(String firstName, String lastName);

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);


    public Collection<Employee> findAll();
}

