package com.example.homework2_4collections.employeeService;

import com.example.homework2_4collections.exception.EmployeeNotFoundException;
import com.example.homework2_4collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan","Ivanov"),
            new Employee("Petr","Petrov"),
            new Employee("Vasiliy","Pumpkin")
    ));



    @Override
    public Employee findAnEmployee(String name, String surname){
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(name) && employee.getLastName().equals(surname)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public boolean addAnEmployee(String name, String surname){
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(name) && employee.getLastName().equals(surname)) {
                throw new EmployeeNotFoundException("Сотрудник с таким именем уже есть");
            }
        }
        return employees.add(new Employee(name,surname));
    }

    @Override
    public Employee removeAnEmployee(String name, String surname) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(name) && employees.get(i).getLastName().equals(surname)) {
                return employees.remove(i);
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}
