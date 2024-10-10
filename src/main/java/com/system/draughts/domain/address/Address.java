package com.system.draughts.domain.address;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street_address")
    private String streetAddress; // logradouro

    @Column(name = "complement")
    private String complement;

    @Column(name = "neighborhood")
    private String neighborhood; // BAIRRO

    @Column(name = "city")
    private String city;

    @Column(name = "state", nullable = false)
    private String state; // UF

    @Column(name = "ibge_code")
    private String ibgeCode;

    @Column(name = "area_code")
    private String areaCode; // DDD

    public Address() {
    }

    public Address(Long id, String postalCode, String streetAddress, String complement, String neighborhood, String state, String ibgeCode, String city, String areaCode) {
        this.id = id;
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.state = state;
        this.ibgeCode = ibgeCode;
        this.city = city;
        this.areaCode = areaCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

