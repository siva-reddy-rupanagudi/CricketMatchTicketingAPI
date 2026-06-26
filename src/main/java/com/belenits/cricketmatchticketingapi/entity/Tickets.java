package com.belenits.cricketmatchticketingapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerName;
    private LocalDate bookingDate;
    private String status;
   @ManyToOne
   @JoinColumn(name = "match_id",referencedColumnName = "id")
    private Matches match;
}
