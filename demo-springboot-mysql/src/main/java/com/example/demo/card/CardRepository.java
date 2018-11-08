package com.example.demo.card;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
    Optional<Card> findByUserId(@Param("id") long id);
}
