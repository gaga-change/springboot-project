package com.example.demo.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Api(value = "springboot服务", description = "用户相关接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "登入", notes = "根据用户名和密码进行登入")
    @PostMapping("login")
    public Map login(@RequestBody User loginUser, HttpSession httpSession) {
        Map<String, Object> res = new HashMap<>();
        User findUser = userRepository.findByUsername(loginUser.getUsername());
        if (findUser == null) {
            res.put("error", "用户名不存在");
        } else if (findUser.getPassword().equals(loginUser.getPassword())) {
            httpSession.setAttribute("user", findUser);
        } else {
            res.put("error", "用户名不存在");
        }
        return res;
    }

    @ApiOperation(value = "获取当前登入用户")
    @PostMapping("current")
    public Map current(HttpSession httpSession) {
        Map<String, Object> res = new HashMap<>();
        User user = (User)httpSession.getAttribute("user");
        res.put("data", user);
        return res;
    }

    @ApiOperation(value = "退出登入")
    @PostMapping("logout")
    public Map logout(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return null;
    }

}
