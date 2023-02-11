package org.example.quote.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewQuote {

    @NotBlank(message = "The content is required")
    private final String content;
    @NotNull(message = "The authorId is required")
    private final Long authorId;

}
