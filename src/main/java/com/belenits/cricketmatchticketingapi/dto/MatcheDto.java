package com.belenits.cricketmatchticketingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatcheDto {
    private Integer id;
    private String team1;
    private String team2;
    private LocalDate matchDate;
    private String venue;
    private Integer totalSeats;
    private Integer availableSeats;
}
