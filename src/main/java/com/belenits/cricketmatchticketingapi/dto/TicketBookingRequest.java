package com.belenits.cricketmatchticketingapi.dto;


import lombok.Data;

@Data
public class TicketBookingRequest {
    private Integer matchId;
    private String customerName;
}