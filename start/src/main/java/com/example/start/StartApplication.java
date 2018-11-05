package com.example.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class StartApplication {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApplication.class, args);
    }
//    public static void main(String[] args) {
//        SpringApplication.run(StartApplication.class, args);
//    }
}
