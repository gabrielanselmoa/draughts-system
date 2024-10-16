package com.system.draughts.domain.player;

public class PlayerDTO {

    private Long id;
    private String name;
    private Integer score;

    public PlayerDTO(){}

    public PlayerDTO(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public PlayerDTO(Player player){
        id = player.getId();
        name = player.getName();
        score = player.getScore();
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
