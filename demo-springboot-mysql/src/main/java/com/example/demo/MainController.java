package com.example.demo;


import com.example.demo.card.Card;
import com.example.demo.card.CardRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    private UserRepository userRepository;
    private CardRepository cardRepository;

    public MainController(UserRepository userRepository, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @PostMapping("/create_user")
    Map createUser(@RequestBody UserBody userBody) {
        Map<String, Object> res = new HashMap<>();
        String msg = "";
        /*
        * 获取用户名
        *  - 有 创建用户
        *   - 获取身份证号码
        *     - 有 创建身份证
        *  - 无 退出
        * */
        String username = userBody.getName();
        if (username != null && !username.isEmpty()) {
            User user = new User();
            System.out.println(user.getId());
            user.setName(userBody.getName());
            userRepository.save(user);
            String cardNum = userBody.getCardNum();
            if (cardNum != null && !cardNum.isEmpty()) {
                Card card = new Card(cardNum, new Date(), user);
                cardRepository.save(card);
            }
        } else {
            msg = "用户名不能为空";
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
