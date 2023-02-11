package org.example.quote.controller.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;



@Getter
@AllArgsConstructor
public class QuoteInfo {
    @Nonnull
    private final Long quoteId;
    @Nonnull
    private final String content;
    @Nonnull
    private final OffsetDateTime creationDate;
    @Nonnull
    private final OffsetDateTime lastUpdateDate;
    @Nonnull
    private final Long authorId;


}
