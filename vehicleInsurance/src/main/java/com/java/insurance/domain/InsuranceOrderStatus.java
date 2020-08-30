package com.java.insurance.domain;

public enum InsuranceOrderStatus {
    START, CHECkED;

    public static InsuranceOrderStatus fromValue(int value){
        for (InsuranceOrderStatus ios : InsuranceOrderStatus.values()){
            if(ios.ordinal() == value)
                return ios;
        }
        throw new RuntimeException("Unknown Value: " + value);
    }
}
