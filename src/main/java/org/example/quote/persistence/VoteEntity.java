package org.example.quote.persistence;

import org.example.quote.VoteType;

import java.time.OffsetDateTime;


public class VoteEntity {

    private Long voteId;

    private OffsetDateTime voteMoment;

    private VoteType voteType;

    private Long quoteId;


}
