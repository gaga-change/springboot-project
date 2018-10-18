package com.example.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("")
    public String admin() {
        return "index";
    }

    @RequestMapping("login.html")
    public String login() {
        return "login";
    }
}
