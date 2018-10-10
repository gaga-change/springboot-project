package com.example.payroll;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException() {
        super();
    }
    EmployeeNotFoundException(long id) {
        super("没有该信息");
    }
}
