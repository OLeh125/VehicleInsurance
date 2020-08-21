package com.java.insurance;

import com.java.insurance.domain.Address;
import com.java.insurance.domain.Customer;
import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.domain.Vehicle;


import java.time.LocalDate;
import java.util.Random;

public class SaveInsuranceOrder {
    public static void main(String[] args) {
        InsuranceOrder s = buildInsuranceOrder(10);


//        InsuranceOrder insuranceOrder = new InsuranceOrder();
//        long id  = saveInsuranceOrder(insuranceOrder);
//        System.out.println(id);
    }

    public static long saveInsuranceOrder(InsuranceOrder insuranceOrder){
        Random random = new Random();
        return random.nextInt(10000);
    }

    static InsuranceOrder buildInsuranceOrder(long id){
        InsuranceOrder ino = new InsuranceOrder();
        ino.setOrderId(id);
        ino.setDataOfIssue(LocalDate.of(2020,8,21));
        ino.setEndDate(LocalDate.of(2021,8,21));
        Address address = new Address("195000", "Заневский пр.", "12", "", "142");
        Vehicle vehicle = new Vehicle(2012,"mercedes","W213",
                "JMZGG12F761624527","AA1111AA");
        Customer customer = new Customer("Oleh","Artymiak","Bohdanovich",
                "+380837341719","oleh.artymiak@gmail.com","6670087167",vehicle,address);

        ino.setCustomer(customer);
        ino.setVehicle(vehicle);
        return ino;
    }

}
