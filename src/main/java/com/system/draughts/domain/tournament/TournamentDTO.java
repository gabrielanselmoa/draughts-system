package com.system.draughts.domain.tournament;

import com.system.draughts.domain.player.PlayerDTO;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TournamentDTO {

    private Long id;
    private String name;

    @ManyToMany
    private List<PlayerDTO> players = new ArrayList<>();

    public TournamentDTO(){}

    public TournamentDTO(Long id, String name, List<PlayerDTO> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public TournamentDTO(Tournament tournament) {
        id = tournament.getId();
        name = tournament.getName();
        players = tournament.getPlayers().stream().map(x -> new PlayerDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> collect) {

    }
}
