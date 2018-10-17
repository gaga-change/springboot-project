package com.example.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("")
    public String admin(Map<String, Object> map) {
        map.put("demo1", "123");
        map.put("demo3", "456");
        map.put("demo2", "456");
        System.out.println(map.toString());
        return "index";
    }
}
