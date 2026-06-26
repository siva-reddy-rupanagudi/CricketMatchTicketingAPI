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
        // Test Case 1: Create a match and ticket
        Matches match1 = new Matches(null, "RCB", "MI", LocalDate.of(2026, 5, 22), "Chinnaswamy Stadium", 20000, 20000, null);
        Matches savedMatch1 = matchesRepo.save(match1);
        Tickets ticket1 = new Tickets(null, "siva", LocalDate.now(), "CONFIRMED", savedMatch1);
        ticketRepo.save(ticket1);

        // Test Case 2: Create another match with different teams
        Matches match2 = new Matches(null, "CSK", "KKR", LocalDate.of(2026, 6, 10), "M.A. Chidambaram Stadium", 15000, 15000, null);
        Matches savedMatch2 = matchesRepo.save(match2);
        Tickets ticket2 = new Tickets(null, "rajesh", LocalDate.now(), "CONFIRMED", savedMatch2);
        ticketRepo.save(ticket2);

        // Test Case 3: Create match with remaining seats
        Matches match3 = new Matches(null, "DC", "SRH", LocalDate.of(2026, 7, 15), "Arun Jaitley Stadium", 25000, 5000, null);
        Matches savedMatch3 = matchesRepo.save(match3);
        Tickets ticket3 = new Tickets(null, "priya", LocalDate.now(), "PENDING", savedMatch3);
        ticketRepo.save(ticket3);

        // Test Case 4: Create match with sold-out status
        Matches match4 = new Matches(null, "RR", "LSG", LocalDate.of(2026, 8, 20), "Sawai Mansingh Stadium", 18000, 0, null);
        Matches savedMatch4 = matchesRepo.save(match4);
        Tickets ticket4 = new Tickets(null, "amit", LocalDate.now(), "CANCELLED", savedMatch4);
        ticketRepo.save(ticket4);

        // Test Case 5: Multiple tickets for same match
        Matches match5 = new Matches(null, "GT", "RR", LocalDate.of(2026, 9, 5), "Narendra Modi Stadium", 22000, 22000, null);
        Matches savedMatch5 = matchesRepo.save(match5);
        Tickets ticket5a = new Tickets(null, "john", LocalDate.now(), "CONFIRMED", savedMatch5);
        Tickets ticket5b = new Tickets(null, "jane", LocalDate.now(), "CONFIRMED", savedMatch5);
        ticketRepo.save(ticket5a);
        ticketRepo.save(ticket5b);
    }
}
