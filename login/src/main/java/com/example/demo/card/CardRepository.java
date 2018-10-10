package com.example.demo.card;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
}
