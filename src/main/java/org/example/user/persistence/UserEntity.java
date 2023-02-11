package org.example.user.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    @SequenceGenerator(name = "userIdGenerator", sequenceName = "users_id_seq", allocationSize = 1)
    @Setter
    private Long userId;
    private String name;
    private String email;
    private String password;
    @Setter
    private OffsetDateTime creationDate;
}
