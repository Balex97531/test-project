package org.example.quote.controller;

import org.example.quote.controller.dto.QuoteInfo;
import org.example.quote.service.QuoteModel;


public class QuoteDtoMapper {

    static QuoteInfo mapToQuoteInfo(QuoteModel quoteModel) {
        return new QuoteInfo(
                quoteModel.getQuoteId(),
                quoteModel.getContent(),
                quoteModel.getCreationDate(),
                quoteModel.getLastUpdateDate(),
                quoteModel.getAuthorId()
        );


    }

}
