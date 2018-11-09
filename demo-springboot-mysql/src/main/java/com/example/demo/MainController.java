package com.example.demo;


import com.example.demo.card.Card;
import com.example.demo.card.CardRepository;
import com.example.demo.card.CardService;
import com.example.demo.card.CardSummary;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    private UserRepository userRepository;
    private CardRepository cardRepository;
    private CardService cardService;
    private UserService userService;

    public MainController(UserRepository userRepository, CardRepository cardRepository, CardService cardService, UserService userService) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.cardService = cardService;
        this.userService = userService;
    }

    // 创建数据
    @PostMapping("/create_user")
    Map createUser(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        String msg = "";
        cardRepository.save(user.getCard());
        userRepository.save(user);
        res.put("data", user);
        res.put("msg", msg);
        return res;
    }

    // 查询用户
    @GetMapping("/my_user/{id}")
    Map getUser(@PathVariable("id") User user) {
        Map<String, Object> res = new HashMap<>();
        String msg = "";
        res.put("msg", msg);
        res.put("data", user);
        return res;
    }
}