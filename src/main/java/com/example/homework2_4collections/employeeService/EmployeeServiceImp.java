package com.example.homework2_4collections.employeeService;

import com.example.homework2_4collections.exception.EmployeeAlreadyAddedException;
import com.example.homework2_4collections.exception.EmployeeNotFoundException;
import com.example.homework2_4collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan","Ivanov"),
            new Employee("Petr","Petrov"),
            new Employee("Vasiliy","Pumpkin")
    ));

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if(employees.contains(employee)){
        return employee;
    }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException(" Такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees);

    }


}




