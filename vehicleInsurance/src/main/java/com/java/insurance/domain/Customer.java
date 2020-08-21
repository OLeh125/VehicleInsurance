package com.java.insurance.domain;

public class Customer {
    private String name;
    private String lastName;
    private String patronymic;
    private String mobilePhone;
    private String email;
    private String IndividualTaxpayerNumber;
    private Vehicle vehicle;
    private Address address;


    public Customer() {
    }

    public Customer(String name, String lastName, String patronymic, String mobilePhone,
                    String email, String individualTaxpayerNumber, Vehicle vehicle, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.mobilePhone = mobilePhone;
        this.email = email;
        IndividualTaxpayerNumber = individualTaxpayerNumber;
        this.vehicle = vehicle;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndividualTaxpayerNumber() {
        return IndividualTaxpayerNumber;
    }

    public void setIndividualTaxpayerNumber(String individualTaxpayerNumber) {
        IndividualTaxpayerNumber = individualTaxpayerNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
