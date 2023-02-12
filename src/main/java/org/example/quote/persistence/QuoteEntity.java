package org.example.quote.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "quotes")
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quoteIdGenerator")
    @SequenceGenerator(name = "quoteIdGenerator", sequenceName = "quotes_id_seq", allocationSize = 1)
    private Long quoteId;
    @Setter
    private String content;
    @Setter
    private OffsetDateTime creationDate;
    @Setter
    private OffsetDateTime lastUpdateDate;
    private Long authorId;


}
