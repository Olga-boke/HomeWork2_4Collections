package com.example.homework2_4collections.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message){
        super(message);
        System.out.println("Массив переполнен");
    }

}
