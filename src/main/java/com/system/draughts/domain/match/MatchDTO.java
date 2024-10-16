package com.system.draughts.domain.match;

import com.system.draughts.domain.player.PlayerDTO;

public class MatchDTO {

    private Long id;
    private PlayerDTO player1;
    private PlayerDTO player2;

    public MatchDTO() {}

    public MatchDTO(Long id, PlayerDTO player1, PlayerDTO player2) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
    }

    public MatchDTO(Match match) {
        this.id = match.getId();
        this.player1 = new PlayerDTO(match.getPlayer1());
        this.player2 = new PlayerDTO(match.getPlayer2());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerDTO getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerDTO player1) {
        this.player1 = player1;
    }

    public PlayerDTO getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerDTO player2) {
        this.player2 = player2;
    }
}
