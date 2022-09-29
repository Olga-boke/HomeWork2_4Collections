package com.example.homework2_4collections.employeeService;

import com.example.homework2_4collections.model.Employee;

public interface EmployeeService {

    Employee findAnEmployee(String name, String surname);

    boolean addAnEmployee(String name, String surname);

    Employee removeAnEmployee(String name, String surname);


}

