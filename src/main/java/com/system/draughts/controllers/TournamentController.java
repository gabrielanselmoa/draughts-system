package com.system.draughts.controllers;

import com.system.draughts.domain.match.MatchDTO;
import com.system.draughts.domain.player.PlayerDTO;
import com.system.draughts.domain.tournament.TournamentDTO;
import com.system.draughts.domain.tournament.TournamentRequestDTO;
import com.system.draughts.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<TournamentDTO>> findAll(){
        return ResponseEntity.ok(tournamentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> findById(@PathVariable Long id) {
        TournamentDTO tournamentDTO = tournamentService.findById(id);
        return ResponseEntity.ok(tournamentDTO);
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentRequestDTO tournamentRequestDTO) {
        return ResponseEntity.ok(tournamentService.createTournament(tournamentRequestDTO));
    }

    @PostMapping("/{tournamentId}/generate-matches")
    public List<MatchDTO> generateMatches(@PathVariable Long tournamentId) {
        return tournamentService.determineMatchups(tournamentId);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TournamentDTO> update(@PathVariable Long id, @RequestBody TournamentRequestDTO dto){
        var tournamentoDTO = tournamentService.update(id, dto);
        return ResponseEntity.ok(tournamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tournamentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

