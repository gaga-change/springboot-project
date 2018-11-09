package com.example.demo.card;

import com.example.demo.user.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cardNum;

    @CreatedDate
    private Date createAt;

    public Card(String cardNum, Date createAt) {
        this.cardNum = cardNum;
        this.createAt = createAt;
    }
}
