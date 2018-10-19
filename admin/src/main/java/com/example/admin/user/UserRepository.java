package com.example.admin.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@Component
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaRepository<User, Long> {
}
