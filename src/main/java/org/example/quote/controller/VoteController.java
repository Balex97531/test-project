package org.example.quote.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.common.exceptions.VoteTypeNotValidException;
import org.example.quote.VoteType;
import org.example.quote.controller.dto.NewVote;
import org.example.quote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/api/quotes/{quoteId}/vote-graph", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getVoteGraph() {
        return HttpStatus.OK;
    }

    private VoteType mapToVoteType(String inputString) throws VoteTypeNotValidException {
        boolean isEnumValue = VoteType.isEnumValue(inputString);
        if (!isEnumValue)
            throw new VoteTypeNotValidException();

        return VoteType.valueOf(inputString);
    }

}
