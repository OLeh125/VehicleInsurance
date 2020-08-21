package com.java.insurance.domain;

public class Vehicle {
    private int yearOfProduction;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleIdentificationNumber;
    private String stateNumber;

    public Vehicle() {
    }

    public Vehicle(int yearOfProduction, String vehicleBrand, String vehicleModel, String vehicleIdentificationNumber, String stateNumber) {
        this.yearOfProduction = yearOfProduction;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.stateNumber = stateNumber;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }
}
