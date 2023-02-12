package org.example.quote.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.example.quote.VoteType;


@AllArgsConstructor
public class NewVote {
    @NotBlank(message = "The voteType is required")
    public final VoteType voteType;

}
