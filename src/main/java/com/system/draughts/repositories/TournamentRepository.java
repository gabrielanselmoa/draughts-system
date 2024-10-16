package com.system.draughts.repositories;

import com.system.draughts.domain.tournament.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Optional<Tournament> findByName(String name);
}
