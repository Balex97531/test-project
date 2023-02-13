package org.example.quote.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

}
