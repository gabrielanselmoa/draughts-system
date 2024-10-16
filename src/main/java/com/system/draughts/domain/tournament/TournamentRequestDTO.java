package com.system.draughts.domain.tournament;

import java.util.List;

public class TournamentRequestDTO {

    private String tournamentName;
    private List<Long> playerIds;

    public TournamentRequestDTO() {
    }

    public TournamentRequestDTO(String tournamentName, List<Long> playerIds) {
        this.tournamentName = tournamentName;
        this.playerIds = playerIds;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
