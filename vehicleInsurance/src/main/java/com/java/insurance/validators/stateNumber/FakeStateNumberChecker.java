package com.java.insurance.validators.stateNumber;

import com.java.insurance.domain.vehicle.stateNumber.StateNumberCheckerResponse;
import com.java.insurance.domain.vehicle.Vehicle;
import com.java.insurance.exception.StateNumberException;
import com.java.insurance.exception.TransportException;

public class FakeStateNumberChecker implements StateNumberChecker {
    public static final String GOOD ="AA1111";
    public static final String BAD ="AA1111AA";
    public static final String BAD_2 ="1111AA";


    public StateNumberCheckerResponse checkVehicle(Vehicle vehicle) throws StateNumberException, TransportException {
        StateNumberCheckerResponse res = new StateNumberCheckerResponse();
        String stateNumber = vehicle.getStateNumber();

        if (stateNumber.equals(GOOD)){
            System.out.println("Good");
            res.setExisting(true);
            res.setTemporal(false);
        }if(stateNumber.equals(BAD)) {
            throw new StateNumberException("1", "Error");
        }if(stateNumber.equals(BAD_2)){
            throw new TransportException(" Transport Error");
        }

        System.out.println(res);
        return res;
    }
}
