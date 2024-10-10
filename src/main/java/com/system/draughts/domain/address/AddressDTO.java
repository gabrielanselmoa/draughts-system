package com.system.draughts.domain.address;

public class AddressDTO {

    private Long id;
    private String postalCode;
    private String streetAddress;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String ibgeCode;
    private String areaCode;

    public AddressDTO(){}

    public AddressDTO(Long id, String postalCode, String streetAddress, String complement, String neighborhood, String city, String state, String ibgeCode, String areaCode) {
        this.id = id;
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.ibgeCode = ibgeCode;
        this.areaCode = areaCode;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.postalCode = address.getPostalCode();
        this.streetAddress = address.getStreetAddress();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.ibgeCode = address.getIbgeCode();
        this.areaCode = address.getAreaCode();
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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
}
