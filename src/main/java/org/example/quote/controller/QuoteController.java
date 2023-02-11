package org.example.quote.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.common.exceptions.QuoteNotFoundException;
import org.example.common.exceptions.UserNotFoundException;
import org.example.quote.controller.dto.NewQuote;
import org.example.quote.controller.dto.QuoteInfo;
import org.example.quote.controller.dto.UpdateQuote;
import org.example.quote.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateQuote(@RequestBody @Valid UpdateQuote updateQuote) throws QuoteNotFoundException {
        quoteService.updateQuote(updateQuote);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteQuote(@PathVariable Long quoteId) {
        quoteService.deleteQuote(quoteId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(value = "/api/quotes/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuoteInfo> getQuote(@PathVariable Long quoteId) throws QuoteNotFoundException {
        QuoteInfo quoteInfo = mapToQuoteInfo(quoteService.getQuote(quoteId));
        return ResponseEntity.status(HttpStatus.OK).body(quoteInfo);
    }

    @GetMapping(value = "/api/quotes/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getRandomQuote() {
        return HttpStatus.OK;
    }

  /*



    @GetMapping(value = "/api/quotes/top10", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getTop10Quotes() {
        return HttpStatus.OK;
    }

    @GetMapping(value = "/api/quotes/worse10", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus getWorse10Quotes() {
        return HttpStatus.OK;
    }

*/
}
