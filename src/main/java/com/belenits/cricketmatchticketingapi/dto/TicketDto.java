package com.belenits.cricketmatchticketingapi.dto;

import com.belenits.cricketmatchticketingapi.entity.Matches;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Integer id;
    private String customerName;
    private LocalDate bookingDate;
    private String status;
}
