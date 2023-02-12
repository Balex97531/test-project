package org.example.quote.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author alexander.burykin@bostongene.com
 */
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

}
