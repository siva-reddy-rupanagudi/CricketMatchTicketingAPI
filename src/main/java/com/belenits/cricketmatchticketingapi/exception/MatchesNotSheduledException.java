package com.belenits.cricketmatchticketingapi.exception;

public class MatchesNotSheduledException extends RuntimeException {
    public MatchesNotSheduledException(String message) {
        super(message);
    }
}
