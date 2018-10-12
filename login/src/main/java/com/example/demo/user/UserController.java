package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/api/login")
    public Map login(User loginUser) {
        User findUser = userRepository.findByUsername(loginUser.getUsername());
        System.out.println(findUser);
        return null;
    }
}
