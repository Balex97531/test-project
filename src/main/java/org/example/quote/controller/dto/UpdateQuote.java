package org.example.quote.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UpdateQuote {
    @NotNull(message = "The quoteId is required")
    private final Long quoteId;
    @NotBlank(message = "The content is required")
    private final String content;
}
