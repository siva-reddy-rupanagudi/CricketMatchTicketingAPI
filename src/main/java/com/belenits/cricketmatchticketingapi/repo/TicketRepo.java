package com.belenits.cricketmatchticketingapi.repo;

import com.belenits.cricketmatchticketingapi.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Tickets, Integer> {
}
