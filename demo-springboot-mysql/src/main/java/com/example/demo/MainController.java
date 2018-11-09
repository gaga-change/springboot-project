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
    Map createUser(@RequestBody UserBody userBody) {
        Map<String, Object> res = new HashMap<>();
        String msg = "";
        String username = userBody.getName();
        // 用户名不能为空
        if (username != null && !username.isEmpty()) {
            // 保存用户
            User user = new User(userBody.getName(), userBody.getAge(), new Date());
            userService.saveUser(user);
            // 保存身份证
            Card card = new Card(user, userBody.getCardNum(), new Date());
            cardService.saveCard(card);
        } else {
            msg = "用户名不能为空";
        }
        res.put("msg", msg);
        return res;
    }

    // 查询用户
    @GetMapping("/my_user/{id}")
    Map getUser(@PathVariable long id) {
        Map<String, Object> res = new HashMap<>();
        String msg = "";
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", user.getName());
            data.put("age", user.getAge());
            data.put("createAt", user.getCreateAt());
//            Card card = cardRepository.findByUserId(id).orElse(new Card());
            CardSummary card = cardRepository.findByUserId(id).orElse(null);
            data.put("card", card);
            res.put("data", data);
        } else {
            msg = "用户不存在";
        }
        res.put("msg", msg);
        return res;
    }
}

//@Entity
class UserBody extends User {
    private String cardNum;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
