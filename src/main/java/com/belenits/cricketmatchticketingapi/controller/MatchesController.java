package com.belenits.cricketmatchticketingapi.controller;

import com.belenits.cricketmatchticketingapi.dto.MatcheDto;
import com.belenits.cricketmatchticketingapi.response.ApiResponse;
import com.belenits.cricketmatchticketingapi.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class AdminController {
    @Autowired
    private MatchesService matchesService;
    @PostMapping("/")
    public ResponseEntity<ApiResponse<MatcheDto>> addMatch(@RequestBody MatcheDto matchesDto){
        MatcheDto matcheDto= matchesService.addMatch(matchesDto);
        ApiResponse<MatcheDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(matcheDto);
        apiResponse.setStatus(201);
        apiResponse.setMessage("Match added Successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MatcheDto>> updateMatchById(@RequestBody MatcheDto matchesDto,
                                                                  @PathVariable Integer id){
        MatcheDto matcheDto= matchesService.updateMatchById(id,matchesDto);
        ApiResponse<MatcheDto> apiResponse = new ApiResponse<>();
        apiResponse.setData(matcheDto);
        apiResponse.setStatus(200);
        apiResponse.setMessage("Match updated Successfully");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}
