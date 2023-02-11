package org.example.quote.service;

import org.example.quote.controller.dto.NewQuote;
import org.example.quote.controller.dto.UpdateQuote;
import org.example.quote.persistence.QuoteEntity;


public class QuoteMapper {

    static QuoteModel mapToQuoteModel(NewQuote newQuote) {
        QuoteModel model = QuoteModel.builder()
                .content(newQuote.getContent())
                .authorId(newQuote.getAuthorId())
                .build();
        return model;
    }

    static QuoteModel mapToQuoteModel(QuoteEntity quoteEntity) {
        QuoteModel model = new QuoteModel(quoteEntity.getQuoteId(),
                quoteEntity.getContent(),
                quoteEntity.getCreationDate(),
                quoteEntity.getLastUpdateDate(),
                quoteEntity.getAuthorId());
        return model;
    }

    static QuoteEntity mapToQuoteEntity(QuoteModel quoteModel) {
        QuoteEntity entity = QuoteEntity.builder()
                .quoteId(quoteModel.getQuoteId())
                .content(quoteModel.getContent())
                .authorId(quoteModel.getAuthorId())
                .creationDate(quoteModel.getCreationDate())
                .lastUpdateDate(quoteModel.getLastUpdateDate())
                .build();
        return entity;
    }

    static QuoteModel mapToQuoteModel(UpdateQuote updateQuote) {
        QuoteModel model = QuoteModel.builder()
                .content(updateQuote.getContent())
                .quoteId(updateQuote.getQuoteId())
                .build();
        return model;
    }
}

