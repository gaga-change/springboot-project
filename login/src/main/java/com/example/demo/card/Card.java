package com.example.demo.card;

import com.example.demo.user.User;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Card {
    private @Id
    @GeneratedValue
    long id;

    private String cardNum;

    private Date createAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "user", rel = "user")
    private User user;
}
