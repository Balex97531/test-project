package org.example.user.services;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class UserModel {
    private final String name;
    private final String email;
    private final String password;
    private final String creationDate;
}
