package com.system.draughts.services;

import com.system.draughts.domain.match.Match;
import com.system.draughts.domain.match.MatchDTO;
import com.system.draughts.domain.player.Player;
import com.system.draughts.domain.player.PlayerDTO;
import com.system.draughts.domain.tournament.Tournament;
import com.system.draughts.domain.tournament.TournamentDTO;
import com.system.draughts.domain.tournament.TournamentRequestDTO;
import com.system.draughts.repositories.MatchRepository;
import com.system.draughts.repositories.PlayerRepository;
import com.system.draughts.repositories.TournamentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private TournamentRepository tournamentRepository;
    private PlayerRepository playerRepository;
    private MatchRepository matchRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, PlayerRepository playerRepository, MatchRepository matchRepository) {
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @Transactional(readOnly = true)
    public List<TournamentDTO> findAll(){
        var list = tournamentRepository.findAll();
        return list.stream().map(x -> new TournamentDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TournamentDTO findById(Long id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        if (tournament.isEmpty()){
            throw new EntityNotFoundException("Tournament not found!!");
        }
        return new TournamentDTO(tournament.get());
    }

    public TournamentDTO createTournament(TournamentRequestDTO tournamentRequestDTO) {
        Tournament tournament = new Tournament();
        tournament.setName(tournamentRequestDTO.getTournamentName());

        List<Player> players = tournamentRequestDTO.getPlayerIds().stream()
                .map(id -> playerRepository.findById(id))
                .filter(Optional::isPresent) // Filtra os presentes
                .map(Optional::get) // Extrai os valores
                .collect(Collectors.toList());

        tournament.getPlayers().addAll(players);

        tournamentRepository.save(tournament);

        return new TournamentDTO(tournament);
    }

    @Transactional(readOnly = true)
    public List<PlayerDTO> getPlayersFromTournament(Long tournamentId) {
        Optional<Tournament> tournamentOpt = tournamentRepository.findById(tournamentId);
        if (tournamentOpt.isEmpty()){
            throw new EntityNotFoundException("Torneio não encontrado com o id: " + tournamentId);
        }

        Tournament tournament = tournamentOpt.get();

        return tournament.getPlayers().stream()
                .map(player -> new PlayerDTO(player.getId(), player.getName(), player.getScore()))
                .collect(Collectors.toList());
    }

    public List<MatchDTO> determineMatchups(Long tournamentId) {

        Optional<Tournament> tournamentOpt = tournamentRepository.findById(tournamentId);
        if (tournamentOpt.isEmpty()) {
            throw new EntityNotFoundException("Torneio não encontrado com o id: " + tournamentId);
        }

        Tournament tournament = tournamentOpt.get();
        List<Player> players = tournament.getPlayers();
        List<MatchDTO> matchDTOs = new ArrayList<>();

        for (int i = 0; i < players.size(); i += 2) {
            Player player1 = players.get(i);
            Player player2 = (i + 1 < players.size()) ? players.get(i + 1) : null;

            Match match = new Match(player1, player2);

            match = matchRepository.save(match);

            MatchDTO matchDTO = new MatchDTO(match);

            matchDTOs.add(matchDTO);
        }

        return matchDTOs;
    }

    public TournamentDTO update(Long id, TournamentRequestDTO dto) {

        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found"));
        tournament.setName(dto.getTournamentName());
        tournament.getPlayers().clear();

        TournamentDTO tournamentDTO = new TournamentDTO();
        tournamentDTO.setId(tournament.getId());
        tournamentDTO.setName(tournament.getName());

        List<Player> players = dto.getPlayerIds().stream()
                .map(playerRepository::findById)
                .filter(Optional::isPresent) // Filtra os presentes
                .map(Optional::get) // Extrai os valores
                .collect(Collectors.toList());

        for (Player p : players) {
            if (!tournament.getPlayers().contains(p)) {
                tournament.getPlayers().add(p);
                tournamentDTO.getPlayers().add(new PlayerDTO(p));
            }
        }

        tournamentRepository.save(tournament);

        return tournamentDTO;
    }

    public void delete(Long id){
        if (!tournamentRepository.existsById(id)) {
            throw new EntityNotFoundException("Tournament not found!");
        }
        tournamentRepository.deleteById(id);
    }
}

