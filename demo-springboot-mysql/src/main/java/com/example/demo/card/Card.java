package com.example.demo.card;

import com.example.demo.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String cardNum;

    private Date createAt;

    public Card() {
        super();
    }

    public Card(User user, String cardNum, Date createAt) {
        this.user = user;
        this.cardNum = cardNum;
        this.createAt = createAt;
    }
}
