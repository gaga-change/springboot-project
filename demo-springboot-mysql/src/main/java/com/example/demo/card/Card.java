package com.example.demo.card;

import com.example.demo.user.User;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Card {
    @Id
    @GeneratedValue
    private long id;

    private String carNum;

    private Date createAt;

    public Card(String carNum, Date createAt, User user) {
        this.carNum = carNum;
        this.createAt = createAt;
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "user", rel = "user")
    private User user;
}
