package org.example.quote.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class VoteController {


    @PostMapping(value = "/api/quotes/{quoteId}/votes", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getCreateVote(
            @RequestBody @Valid VoteType voteType
    ){
        return HttpStatus.OK;
    }

    @GetMapping(value = "/api/quotes/{quoteId}/vote-graph", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getVoteGraph(){
        return HttpStatus.OK;
    }
}
