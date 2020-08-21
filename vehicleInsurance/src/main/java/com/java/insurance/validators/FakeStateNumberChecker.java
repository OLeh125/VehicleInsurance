package com.java.insurance.validators;

import com.java.insurance.domain.StateNumberCheckerResponse;
import com.java.insurance.domain.Vehicle;
import com.java.insurance.exception.StateNumberException;

public class FakeStateNumberChecker implements StateNumberChecker{
    public static final String GOOD ="AA1111AA";


    public StateNumberCheckerResponse checkVehicle(Vehicle vehicle) throws StateNumberException {
        StateNumberCheckerResponse res = new StateNumberCheckerResponse();

        if (vehicle.getStateNumber().equals(GOOD)){
            System.out.println("Good");
            res.setExisting(true);
            res.setTemporal(false);
        }else {
            throw new StateNumberException("BAD");
        }

        System.out.println(res);
        return res;
    }
}
