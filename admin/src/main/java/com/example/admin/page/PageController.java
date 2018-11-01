package com.example.admin.page;

import com.example.admin.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController {
    /**
     * 首页
     * @return index.ftl
     */
    @RequestMapping("")
    public String admin(HttpSession httpSession) {
        // 校验是否登录
        User user = (User)httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:/login.html";
        }
        return "index";
    }

    /**
     * 登录页
     * @return login.ftl
     */
    @RequestMapping("login.html")
    public String login() {
        return "login";
    }

    /**
     * 退出登录
     */
    @RequestMapping("logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/login.html";
    }
}
