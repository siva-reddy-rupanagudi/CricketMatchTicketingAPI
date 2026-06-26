package com.belenits.cricketmatchticketingapi.service;

import com.belenits.cricketmatchticketingapi.dto.MatcheDto;
import com.belenits.cricketmatchticketingapi.entity.Matches;
import com.belenits.cricketmatchticketingapi.repo.MatchesRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Matches matches=matchesRepo.findById(id).orElseThrow(()->new );

    }
}
