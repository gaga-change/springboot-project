package com.example.demo.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private Date createAt;

    public User() {
        super();
    }

    public User(String name, int age, Date createAt) {
        this.name = name;
        this.age = age;
        this.createAt = createAt;
    }
}
