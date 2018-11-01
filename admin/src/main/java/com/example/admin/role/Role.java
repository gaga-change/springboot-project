package com.example.admin.role;

import com.example.admin.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String remark;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROLE_USER", joinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    }, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    })
    private Set<User> users;
}
