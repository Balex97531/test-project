package org.example.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Vote type is not a valid enum value")
public class VoteTypeNotValidException extends Exception {

}
