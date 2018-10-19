package com.example.payroll;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    private @Id
    @GeneratedValue
    long id;
    private String firstName;
    private String lastName;
    private String role;

    Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] strs = name.split(" ");
        this.firstName = strs[0];
        if (strs.length  < 2) {
            this.lastName = "";
        } else {
            this.lastName = strs[1];
        }
    }
}
