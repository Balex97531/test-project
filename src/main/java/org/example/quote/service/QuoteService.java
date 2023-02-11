package org.example.quote.service;

import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.common.exceptions.UserNotFoundException;
import org.example.quote.controller.dto.NewQuote;
import org.example.quote.controller.dto.UpdateQuote;
import org.example.quote.persistence.QuoteEntity;
import org.example.quote.persistence.QuoteRepository;
import org.example.user.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.example.quote.service.QuoteMapper.mapToQuoteEntity;
import static org.example.quote.service.QuoteMapper.mapToQuoteModel;


@Service
@AllArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final UserService userService;

    @Transactional
    public void createQuote(NewQuote newQuote) throws UserNotFoundException {
        boolean isUserExists = userService.isUserExists(newQuote.getAuthorId());
        if (!isUserExists)
            throw new UserNotFoundException();
        QuoteModel quoteModel = mapToQuoteModel(newQuote);
        QuoteEntity quoteEntity = mapToQuoteEntity(quoteModel);
        quoteEntity.setCreationDate(OffsetDateTime.now());
        quoteEntity.setLastUpdateDate(OffsetDateTime.now());
        quoteRepository.save(quoteEntity);
    }

    @Transactional
    public void updateQuote(UpdateQuote updateQuote) throws QuoteNotFoundException {
        QuoteEntity quoteEntity = getQuoteEntity(updateQuote.getQuoteId());
        quoteEntity.setContent(updateQuote.getContent());
        quoteEntity.setLastUpdateDate(OffsetDateTime.now());
        quoteRepository.save(quoteEntity);

    }

    @Transactional
    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId); // проверить физическое удаление
    }

    public QuoteModel getQuote(Long quoteId) throws QuoteNotFoundException {
        QuoteEntity quoteEntity = getQuoteEntity(quoteId);
        return mapToQuoteModel(quoteEntity);
    }


    private QuoteEntity getQuoteEntity(Long quoteId) throws QuoteNotFoundException {
        Optional<QuoteEntity> entityOptional = quoteRepository.findById(quoteId);
        if (entityOptional.isEmpty())
            throw new QuoteNotFoundException();
        return entityOptional.get();
    }
/*
    public QuoteModel getRandomQuote() {

    }
*/

}
