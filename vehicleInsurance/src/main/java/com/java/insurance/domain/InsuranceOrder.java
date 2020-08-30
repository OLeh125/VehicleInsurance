package com.java.insurance.domain;


import com.java.insurance.domain.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InsuranceOrder {
    private long orderId;
    private LocalDateTime dataOfIssue;
    private InsuranceOrderStatus insuranceOrderStatus;
    private LocalDate endDate;
    private Customer customer;
    private Vehicle vehicle;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDataOfIssue() {
        return dataOfIssue;
    }

    public void setDataOfIssue(LocalDateTime dataOfIssue) {
        this.dataOfIssue = dataOfIssue;
    }

    public InsuranceOrderStatus getInsuranceOrderStatus() {
        return insuranceOrderStatus;
    }

    public void setInsuranceOrderStatus(InsuranceOrderStatus insuranceOrderStatus) {
        this.insuranceOrderStatus = insuranceOrderStatus;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
