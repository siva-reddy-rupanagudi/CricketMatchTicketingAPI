package com.belenits.cricketmatchticketingapi.service;

import com.belenits.cricketmatchticketingapi.dto.MatcheDto;
import com.belenits.cricketmatchticketingapi.entity.Matches;
import com.belenits.cricketmatchticketingapi.exception.MatchNotFoundException;
import com.belenits.cricketmatchticketingapi.exception.MatchesNotSheduledException;
import com.belenits.cricketmatchticketingapi.repo.MatchesRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesService {
    @Autowired
    private MatchesRepo matchesRepo;

    public MatcheDto addMatch(MatcheDto matchesDto) {
        Matches matches = new Matches();
        BeanUtils.copyProperties(matchesDto, matches);
        BeanUtils.copyProperties(matchesRepo.save(matches), matchesDto);
        return matchesDto;
    }

    public MatcheDto updateMatchById(Integer id,MatcheDto matchesDto) {
        Matches matches= matchesRepo.findById(id).orElseThrow(()->new MatchNotFoundException("Match not found with id: "+id));
        BeanUtils.copyProperties(matchesDto, matches);
        BeanUtils.copyProperties(matchesRepo.save(matches), matchesDto);
        return matchesDto;

    }

    public List<MatcheDto> getAllMatches() {
        List<Matches> matchesList=matchesRepo.findAll();
        if(matchesList.isEmpty()) throw new MatchesNotSheduledException("No matches are scheduled at the moment.");
        List<MatcheDto> matcheDtos= matchesList.stream().map(matche->{
            MatcheDto matcheDto=new MatcheDto();
            BeanUtils.copyProperties(matche,matcheDto);
            return matcheDto;
        }).toList();
        return matcheDtos;
    }

    public MatcheDto getMatchbyid(Integer id) {
        MatcheDto matcheDto=new MatcheDto();
        Matches matches=matchesRepo.findById(id).orElseThrow(()->new MatchNotFoundException("Match Not Found by this Id: "+id));
        BeanUtils.copyProperties(matches,matcheDto);
        return matcheDto;
    }
}
