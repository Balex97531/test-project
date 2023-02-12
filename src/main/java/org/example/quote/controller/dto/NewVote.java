package org.example.quote.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NewVote {

    @NotBlank(message = "The voteType is required")
    private String voteType;

}
