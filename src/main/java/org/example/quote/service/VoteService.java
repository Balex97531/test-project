package org.example.quote.service;

import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.quote.VoteType;
import org.example.quote.persistence.VoteEntity;
import org.example.quote.persistence.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;


@Service
@AllArgsConstructor
public class VoteService {

    private final QuoteService quoteService;
    private final VoteRepository voteRepository;

    @Transactional
    public void createVote(Long quoteId, VoteType voteType) throws QuoteNotFoundException {
        boolean isQuoteExists = quoteService.isQuoteExists(quoteId);
        if (!isQuoteExists)
            throw new QuoteNotFoundException();

        VoteEntity voteEntity = VoteEntity.builder()
                .voteType(voteType)
                .quoteId(quoteId)
                .voteMoment(OffsetDateTime.now())
                .build();
        voteRepository.save(voteEntity);
    }

}
