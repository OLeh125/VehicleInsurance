package com.java.insurance.validators;

import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.domain.AnswerStateNumber;
import com.java.insurance.domain.StateNumberCheckerResponse;
import com.java.insurance.exception.StateNumberException;

public class StateNumberValidator {
     public String hostName;
     public int port;
     public String login;
     public String password;
     private StateNumberChecker vehicleChecker;

    public StateNumberValidator() {
        vehicleChecker = new FakeStateNumberChecker();
    }

    public  AnswerStateNumber checkStateNumber(InsuranceOrder insuranceOrder){  // перевірка гос номеру
        try {
            StateNumberCheckerResponse ans = vehicleChecker.checkVehicle(insuranceOrder.getVehicle());
        } catch (StateNumberException e) {
            e.printStackTrace();
        }
        AnswerStateNumber asn = new AnswerStateNumber();
        return asn;
    }
}
