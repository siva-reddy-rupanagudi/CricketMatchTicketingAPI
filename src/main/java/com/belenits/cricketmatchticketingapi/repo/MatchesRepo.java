package com.belenits.cricketmatchticketingapi.repo;

import com.belenits.cricketmatchticketingapi.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepo extends JpaRepository<Matches, Integer> {
}
