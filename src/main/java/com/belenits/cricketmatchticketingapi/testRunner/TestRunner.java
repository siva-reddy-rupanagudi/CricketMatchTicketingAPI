package com.belenits.cricketmatchticketingapi.testRunner;

import com.belenits.cricketmatchticketingapi.entity.Matches;
import com.belenits.cricketmatchticketingapi.entity.Tickets;
import com.belenits.cricketmatchticketingapi.repo.MatchesRepo;
import com.belenits.cricketmatchticketingapi.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private MatchesRepo matchesRepo;

    @Override
    public void run(String... args) throws Exception {
        Matches match = new Matches(null, "RCB", "MI", LocalDate.of(2026, 5, 22), "Chinnaswamy Stadium", 20000, 20000, null);

        Matches savedMatch = matchesRepo.save(match);
        Tickets ticket = new Tickets(null, "siva", LocalDate.now(), "CONFIRMED", savedMatch);

        ticketRepo.save(ticket);
    }
}
