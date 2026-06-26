package com.belenits.cricketmatchticketingapi.controller;

import com.belenits.cricketmatchticketingapi.dto.MatcheDto;
import com.belenits.cricketmatchticketingapi.dto.TicketBookingRequest;
import com.belenits.cricketmatchticketingapi.dto.TicketDto;
import com.belenits.cricketmatchticketingapi.response.ApiResponse;
import com.belenits.cricketmatchticketingapi.service.MatchesService;
import com.belenits.cricketmatchticketingapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class UserController {
    @Autowired
    private TicketService ticketService;
     @PostMapping("/book")
     public ResponseEntity<ApiResponse<TicketDto>> bookTicket(@RequestBody TicketBookingRequest ticketBookingRequest){
         TicketDto ticketDto=ticketService.bookTicket(ticketBookingRequest);
         ApiResponse<TicketDto>response=new ApiResponse<>();
         response.setStatus(201);
         response.setMessage("Ticket successfully booked for " + ticketDto.getCustomerName());
         response.setData(ticketDto);
         return new ResponseEntity<>(response,HttpStatus.CREATED);
     }



}
