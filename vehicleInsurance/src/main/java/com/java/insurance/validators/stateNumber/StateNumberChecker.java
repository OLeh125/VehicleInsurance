package com.java.insurance.validators.stateNumber;

import com.java.insurance.domain.vehicle.stateNumber.StateNumberCheckerResponse;
import com.java.insurance.domain.vehicle.Vehicle;
import com.java.insurance.exception.StateNumberException;
import com.java.insurance.exception.TransportException;

public interface StateNumberChecker {
    StateNumberCheckerResponse checkVehicle(Vehicle vehicle) throws StateNumberException, TransportException;
}
