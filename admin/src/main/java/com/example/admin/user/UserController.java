package com.example.admin.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RepositoryRestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    void login(User user) {

    }

//    @RequestMapping("test")
//    public Resource<User> test() {
//        long count = userRepository.count();
//        User user = null;
//        if (count == 0) {
//            user = new User("123", "123");
//            userRepository.save(user);
//        } else {
//            Long id = (long) 1;
//            Optional optional = userRepository.findById(id);
//            user = (User) optional.get();
//        }
//        return new Resource<>(user,
//                linkTo(methodOn(UserController.class).test()).withSelfRel(),
//                linkTo(methodOn(UserController.class).all()).withRel("users"));
//    }
}
