package org.example.quote.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

    @Query(value = "SELECT * FROM  quotes q  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public QuoteEntity getRandomQuote();

    @Query(value =
            "SELECT  " +
                "q.quote_id, " +
                "q.content, " +
                "q.creation_date, " +
                "q.last_update_date, " +
                "q.author_id " +
            "FROM  quotes q " +
            "left join (SELECT quote_id, vote_type ,count(1) as amount " +
                            "FROM VOTES " +
                            "where vote_type=:voteType " +
                            "GROUP BY quote_id, vote_type) tbl_votes  ON q.quote_id =  tbl_votes.quote_id " +
            "ORDER BY amount Desc, quote_id " +
            "LIMIT 10", nativeQuery = true)
    public List<QuoteEntity> get10TopOrWorseQuotes(String voteType);

}
