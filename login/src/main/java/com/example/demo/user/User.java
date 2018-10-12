package com.example.demo.user;

import com.example.demo.card.Card;
import com.example.demo.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户类
 */
@ApiModel(value="用户对象", description = "用户对象User")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(value="用户名", example = "123")
    private String username;

    @ApiModelProperty(value="密码", example = "123")
    private String password;

//    @OneToOne(mappedBy = "user")
//    @ApiModelProperty(hidden = true)
//    private Card card;
//
//    @OneToMany(mappedBy = "user")
//    @ApiModelProperty(hidden = true)
//    private List<Post> posts = new ArrayList<>();
}