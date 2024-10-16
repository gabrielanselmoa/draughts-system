package com.system.draughts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.draughts.domain.match.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
