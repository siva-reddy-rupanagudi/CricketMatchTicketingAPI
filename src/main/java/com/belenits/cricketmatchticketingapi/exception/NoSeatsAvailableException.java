package com.belenits.cricketmatchticketingapi.exception;

public class NoSeatsAvailableException extends RuntimeException{
    public NoSeatsAvailableException(String msg){
        super(msg);
    }
}
