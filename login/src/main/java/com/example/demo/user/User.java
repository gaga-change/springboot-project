package com.example.demo.user;

import com.example.demo.card.Card;
import com.example.demo.post.Post;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户类
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;

    @OneToOne(mappedBy = "user")
    private Card card;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
