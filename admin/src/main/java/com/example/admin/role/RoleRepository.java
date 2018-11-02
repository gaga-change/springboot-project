package com.example.admin.role;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
