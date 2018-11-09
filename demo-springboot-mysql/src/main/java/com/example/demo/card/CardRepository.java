package com.example.demo.card;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
    @Query("select t from #{#entityName} t where t.user.id = ?1")
    Optional<CardSummary> findByUserId(long id);
    //    Optional<Card> findByUserId(long id);
}