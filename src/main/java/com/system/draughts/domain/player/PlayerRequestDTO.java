package com.system.draughts.domain.player;

public class PlayerRequestDTO {

    private String name;
    private Integer score;

    public PlayerRequestDTO(){}

    public PlayerRequestDTO(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public PlayerRequestDTO(Player player){
        name = player.getName();
        score = player.getScore();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
