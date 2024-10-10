package com.system.draughts.domain.phone;

public class PhoneDTO {

    private Long id;
    private String description;
    private Integer ddd;
    private String number;

    public PhoneDTO(){}

    public PhoneDTO(Long id, String description, Integer ddd, String number) {
        this.id = id;
        this.description = description;
        this.ddd = ddd;
        this.number = number;
    }

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.description = phone.getDescription();
        this.ddd = phone.getDdd();
        this.number = phone.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
