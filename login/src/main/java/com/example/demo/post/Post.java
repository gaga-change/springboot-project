package com.example.demo.post;

import com.example.demo.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 文章类
 */
@Data
@Entity
public class Post {
    private @Id @GeneratedValue long id;

    private String content;

    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
