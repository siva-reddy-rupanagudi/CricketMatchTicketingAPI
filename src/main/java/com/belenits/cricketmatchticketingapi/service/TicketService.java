package com.belenits.cricketmatchticketingapi.service;

import com.belenits.cricketmatchticketingapi.dto.MatcheDto;
import com.belenits.cricketmatchticketingapi.dto.TicketBookingRequest;
import com.belenits.cricketmatchticketingapi.dto.TicketDto;
import com.belenits.cricketmatchticketingapi.entity.Matches;
import com.belenits.cricketmatchticketingapi.entity.Tickets;
import com.belenits.cricketmatchticketingapi.exception.MatchNotFoundException;
import com.belenits.cricketmatchticketingapi.exception.NoSeatsAvailableException;
import com.belenits.cricketmatchticketingapi.repo.MatchesRepo;
import com.belenits.cricketmatchticketingapi.repo.TicketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TicketService {
    @Autowired
    private MatchesRepo matchesRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Transactional
    public TicketDto bookTicket(TicketBookingRequest ticketBookingRequest) {
        Matches matches=matchesRepo.findById(ticketBookingRequest.getMatchId()).orElseThrow(()->new MatchNotFoundException("Match not Found for this Id: "+ticketBookingRequest.getMatchId()));
        if(matches.getAvailableSeats()<=0) throw new NoSeatsAvailableException("House Full! No seats available for this match.");
        Tickets newtickets=new Tickets();
        TicketDto dto=new TicketDto();
        newtickets.setBookingDate(LocalDate.now());
        newtickets.setStatus("CONFIRMED");
        newtickets.setCustomerName(ticketBookingRequest.getCustomerName());
        newtickets.setMatch(matches);
        BeanUtils.copyProperties(ticketRepo.save(newtickets),dto);
        matches.setAvailableSeats(matches.getAvailableSeats()-1);
        matchesRepo.save(matches);
        return dto;


    }
}
