package com.example.admin.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.example.admin.util.ResFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@RestController
@RepositoryRestController
@RequestMapping("/api/user")
public class UserController {

    private long userNumber = -1;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    Map login(User user, HttpSession httpSession) {
        // 第一个登录用户 自动转为 管理员
        if (this.userNumber < 0) {
            this.userNumber = userRepository.count();
            if (this.userNumber == 0) {
                System.out.println("第一个用户");
                userRepository.save(user);
                this.userNumber++;
                httpSession.setAttribute("user", user);
                return ResFactory.getRes(user);
            }
        }
        // 根据用户名查找用户
        User findUser = userRepository.findByUsername(user.getUsername());
        if (findUser == null) {
            return ResFactory.getRes("用户名不存在");
        }
        // 验证密码
        if (!findUser.getPasswordEncrypt().equals(user.getPasswordEncrypt())) {
            return ResFactory.getRes("密码错误");
        }
        // 校验成功
        httpSession.setAttribute("user", user);
        return ResFactory.getRes(user);
    }
}
