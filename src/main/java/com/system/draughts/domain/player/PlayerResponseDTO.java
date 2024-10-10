package com.system.draughts.domain.player;

import com.system.draughts.enums.SexType;

import java.util.Date;

public class PlayerResponseDTO {

    private String name;
    private SexType sexType;
    private String email;

    public PlayerResponseDTO() {
    }

    public PlayerResponseDTO(String name, SexType sexType, String email) {
        this.name = name;
        this.sexType = sexType;
        this.email = email;
    }

    public PlayerResponseDTO(Player player){
        name = player.getName();
        sexType = player.getSexType();
        email = player.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
