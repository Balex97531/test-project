package org.example.user.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus createUser(
            @RequestBody @Valid NewUser newUser
    ) {
        userService.createUser(newUser);
        return HttpStatus.OK;
    }


/*

creation of a user account. User properties are name, email, password and date of creation;

addition,
viewing (including a method to get a random quote),
modification,
and deletion of quotes (real deletion from the database, not just via an archive flag).

Quote properties include content, date of creation / update, link to user who posted it, link to votes;
voting on quotes (either upvote or downvote);

view of the top and worse 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes over time.
 */

}

