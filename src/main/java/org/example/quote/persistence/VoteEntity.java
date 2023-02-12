package org.example.quote.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.quote.VoteType;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@Setter
@Entity
@Table(name = "votes")
@NoArgsConstructor
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voteIdGenerator")
    @SequenceGenerator(name = "voteIdGenerator", sequenceName = "vote_id_seq", allocationSize = 1)

    private Long voteId;

    private OffsetDateTime voteMoment;

    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    private Long quoteId;


}
