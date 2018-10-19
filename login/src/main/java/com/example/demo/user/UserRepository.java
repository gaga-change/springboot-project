package com.example.demo.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    public User findByUsername(@Param("username") String username);
}
