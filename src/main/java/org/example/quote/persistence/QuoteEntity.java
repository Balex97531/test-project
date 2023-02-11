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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quoteId;
    @Setter
    private String content;
    @Setter
    private OffsetDateTime creationDate;
    @Setter
    private OffsetDateTime lastUpdateDate;
    private Long authorId;


}
