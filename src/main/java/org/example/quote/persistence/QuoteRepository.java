package org.example.quote.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

    @Query(value = "SELECT * FROM  quotes q  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public QuoteEntity getRandomQuote();

}
