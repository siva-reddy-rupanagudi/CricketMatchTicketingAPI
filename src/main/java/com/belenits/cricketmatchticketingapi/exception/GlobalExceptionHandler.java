package com.belenits.cricketmatchticketingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSeatsAvailableException.class)
    public ResponseEntity<String> noSeatsAvailableException(NoSeatsAvailableException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public ResponseEntity<String> matchNotFoundException(MatchNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MatchesNotSheduledException.class)
    public ResponseEntity<String> matchesNotSheduledException(MatchesNotSheduledException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<String> globalException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
