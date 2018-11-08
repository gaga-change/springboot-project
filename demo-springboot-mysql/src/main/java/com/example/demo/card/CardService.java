package com.example.demo.card;

import com.example.demo.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CardService {
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * 创建身份证
     * @return Card
     */
    public Card saveCard(Card card) {
        cardRepository.save(card);
        return null;
    }
}
