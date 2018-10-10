package com.example.payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    private @Id @GeneratedValue long id;
    private String name;
    private String role;

    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
