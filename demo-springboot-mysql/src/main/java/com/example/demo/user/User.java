package com.example.demo.user;

import com.example.demo.card.Card;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;

    @CreatedDate
    @Nullable
    private Date createAt;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public User() {
        super();
    }
}
