package com.example.demo.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int age;
    private Date createAt;
}
