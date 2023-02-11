package org.example.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Quote not found")
public class QuoteNotFoundException extends Exception {



}
