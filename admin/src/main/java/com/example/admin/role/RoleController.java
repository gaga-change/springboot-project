package com.example.admin.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;


@RestController
public class RoleController {
    private RoleRepository roleRepository;

    @Autowired
    RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @RequestMapping("/api/roles/all")
    Iterable findAll() {
        Iterable arrayList = roleRepository.findAll();
        return arrayList;
    }
}
