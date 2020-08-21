package com.java.insurance.domain;


import java.time.LocalDate;

public class InsuranceOrder {
    private long orderId;
    private LocalDate dataOfIssue;
    private LocalDate endDate;
    private Customer customer;
    private Vehicle vehicle;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDataOfIssue() {
        return dataOfIssue;
    }

    public void setDataOfIssue(LocalDate dataOfIssue) {
        this.dataOfIssue = dataOfIssue;
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
