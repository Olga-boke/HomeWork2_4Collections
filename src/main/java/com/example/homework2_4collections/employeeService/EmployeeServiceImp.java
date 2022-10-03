package com.example.homework2_4collections.employeeService;

import com.example.homework2_4collections.exception.EmployeeAlreadyAddedException;
import com.example.homework2_4collections.exception.EmployeeNotFoundException;
import com.example.homework2_4collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService{

    Map<String,Employee> employees = new HashMap<>(Map.of(
           "Ivan Ivanov", new Employee("Ivan","Ivanov"),
            "Petr Petrov",new Employee("Petr","Petrov"),
            "Vasiliy Pumpkin",new Employee("Vasiliy","Pumpkin")
    ));

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if(employees.containsKey(employee.getFullName())){
        return employees.get(employee.getFullName());
    }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException(" Такой сотрудник уже есть");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());

    }


}




