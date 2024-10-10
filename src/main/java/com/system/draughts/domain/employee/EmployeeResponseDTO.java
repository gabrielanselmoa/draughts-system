package com.system.draughts.domain.employee;

import com.system.draughts.enums.SexType;

import java.util.Date;

public class EmployeeResponseDTO {

    private String name;
    private SexType sexType;
    private String email;

    public EmployeeResponseDTO(){}

    public EmployeeResponseDTO(String name, SexType sexType, String email) {
        this.name = name;
        this.sexType = sexType;
        this.email = email;
    }

    public EmployeeResponseDTO(Employee employee) {
        name = employee.getName();
        sexType = employee.getSexType();
        email = employee.getEmail();
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
