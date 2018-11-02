package com.example.admin.user;

import com.example.admin.role.Role;
import com.example.admin.util.Encrypt;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

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

    private String passwordEncrypt;

    private String tel;

    private String email;

    private Date createDate;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    User(String username, String passwordEncrypt, String tel, String email) {
        this.username = username;
        this.passwordEncrypt = passwordEncrypt;
        this.tel = tel;
        this.email = email;
        this.createDate = new Date();
    }

    public void setPassword(String password) {
        this.passwordEncrypt = Encrypt.turnMesssage(password);
    }

//    public String getPassword() {
//        return this.passwordEncrypt;
//    }

}
