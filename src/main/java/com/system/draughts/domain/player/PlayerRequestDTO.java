package com.system.draughts.domain.player;

import com.system.draughts.enums.SexType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class PlayerRequestDTO {

    private String name;
    private Date birthdayDate;
    private SexType sexType;
    private String email;
    private String password;
    private String cpf;

    public PlayerRequestDTO() {
    }

    public PlayerRequestDTO(String name, Date birthdayDate, SexType sexType, String email, String password, String cpf) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.sexType = sexType;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
