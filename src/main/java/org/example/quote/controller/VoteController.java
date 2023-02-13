package org.example.quote.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.common.exceptions.VoteTypeNotValidException;
import org.example.quote.VoteType;
import org.example.quote.controller.dto.NewVote;
import org.example.quote.service.VoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VoteController {

    private final VoteService voteService;

    @PostMapping(value = "/api/quotes/{quoteId}/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createVote(
            @PathVariable Long quoteId,
            @RequestBody @Valid NewVote newVote
    ) throws QuoteNotFoundException, VoteTypeNotValidException {
        VoteType voteType = mapToVoteType(newVote.getVoteType());
        voteService.createVote(quoteId, voteType);
        return ResponseEntity.ok().build();
    }

    private VoteType mapToVoteType(String inputString) throws VoteTypeNotValidException {
        boolean isEnumValue = VoteType.isEnumValue(inputString);
        if (!isEnumValue)
            throw new VoteTypeNotValidException();

        return VoteType.valueOf(inputString);
    }

}
