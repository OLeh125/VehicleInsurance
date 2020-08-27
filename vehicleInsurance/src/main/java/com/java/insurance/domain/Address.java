package com.java.insurance.domain;

public class Address {
    private String city;
    private String postCode;
    private Street street;
    private String building;
    private String extension;
    private String apartment;

    public Address() {
    }

    public Address(String city, String postCode, Street street, String building, String extension, String apartment) {
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.building = building;
        this.extension = extension;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
