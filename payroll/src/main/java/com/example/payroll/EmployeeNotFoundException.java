package com.example.payroll;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException() {
        super();
    }
    EmployeeNotFoundException(long id) {
        super("Could not find employee " + id);
    }
}
