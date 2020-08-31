package com.java.insurance;

import com.java.insurance.domain.InsuranceOrder;

import java.util.Random;

public class SaveInsuranceOrder {

    public static long saveInsuranceOrder(InsuranceOrder insuranceOrder){
        Random random = new Random();
        return random.nextInt(10000);
    }

}
