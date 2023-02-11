package org.example.quote.service;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;


@Builder
@Getter
public class QuoteModel {

    private final Long quoteId;
    private final String content;
    private final OffsetDateTime creationDate;
    private final OffsetDateTime lastUpdateDate;
    private final Long authorId;


}
