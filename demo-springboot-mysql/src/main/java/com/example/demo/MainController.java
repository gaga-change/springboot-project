package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/add")
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping(path = "/all")
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

}
