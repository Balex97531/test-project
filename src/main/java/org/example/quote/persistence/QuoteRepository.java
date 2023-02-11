package org.example.quote.persistence;

import org.example.user.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
}
