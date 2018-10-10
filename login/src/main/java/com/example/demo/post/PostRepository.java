package com.example.demo.post;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

}
