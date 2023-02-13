package org.example.quote.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.common.exceptions.UserNotFoundException;
import org.example.quote.VoteType;
import org.example.quote.controller.dto.NewQuote;
import org.example.quote.controller.dto.QuoteInfo;
import org.example.quote.controller.dto.UpdateQuote;
import org.example.quote.service.QuoteModel;
import org.example.quote.service.QuoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.quote.controller.QuoteDtoMapper.mapToQuoteInfo;


@RestController
@AllArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @PostMapping(value = "/api/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createQuote(
            @RequestBody @Valid NewQuote newQuote
    ) throws UserNotFoundException {
        quoteService.createQuote(newQuote);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateQuote(@RequestBody @Valid UpdateQuote updateQuote) throws QuoteNotFoundException {
        quoteService.updateQuote(updateQuote);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteQuote(@PathVariable Long quoteId) {
        quoteService.deleteQuote(quoteId);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuoteInfo> getQuote(@PathVariable Long quoteId) throws QuoteNotFoundException {
        QuoteInfo quoteInfo = mapToQuoteInfo(quoteService.getQuote(quoteId));
        return ResponseEntity.ok().body(quoteInfo);
    }

    @GetMapping(value = "/api/quotes/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuoteInfo> getRandomQuote() {
        QuoteInfo quoteInfo = mapToQuoteInfo(quoteService.getRandomQuote());
        return ResponseEntity.ok().body(quoteInfo);
    }

    @GetMapping(value = "/api/quotes/top10", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuoteInfo>> getTop10Quotes() {
        List<QuoteModel> quoteModelList = quoteService.get10Quotes(VoteType.UP_VOTE);
        List<QuoteInfo> quoteInfoList = quoteModelList.stream().map(val -> mapToQuoteInfo(val)).collect(Collectors.toList());
        return ResponseEntity.ok().body(quoteInfoList);
    }


    @GetMapping(value = "/api/quotes/worse10", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuoteInfo>> geWorse10Quotes() {
        List<QuoteModel> quoteModelList = quoteService.get10Quotes(VoteType.DOWN_VOTE);
        List<QuoteInfo> quoteInfoList = quoteModelList.stream().map(QuoteDtoMapper::mapToQuoteInfo).collect(Collectors.toList());
        return ResponseEntity.ok().body(quoteInfoList);
    }

}
