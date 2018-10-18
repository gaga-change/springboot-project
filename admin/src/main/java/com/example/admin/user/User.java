package com.example.admin.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Data : lombok注解，自动设置get\set
 * Entity : jpa注解，声明类为实体或表
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;
}
