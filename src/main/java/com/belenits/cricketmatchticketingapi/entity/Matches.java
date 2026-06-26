package com.belenits.cricketmatchticketingapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String team1;
    private String team2;
    private LocalDate matchDate;
    private String venue;
    private Integer totalSeats;
    private Integer availableSeats;
    @OneToMany(mappedBy = "match",cascade = CascadeType.ALL)
    private List<Tickets> tickets;
}
