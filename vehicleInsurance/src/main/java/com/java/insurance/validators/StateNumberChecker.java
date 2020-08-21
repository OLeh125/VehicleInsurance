package com.java.insurance.validators;

import com.java.insurance.domain.StateNumberCheckerResponse;
import com.java.insurance.domain.Vehicle;
import com.java.insurance.exception.StateNumberException;

public interface StateNumberChecker {
    StateNumberCheckerResponse checkVehicle(Vehicle vehicle) throws StateNumberException;
}
