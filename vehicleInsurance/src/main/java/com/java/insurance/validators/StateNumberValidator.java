package com.java.insurance.validators;

import com.java.insurance.domain.Customer;
import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.domain.vehicle.Vehicle;
import com.java.insurance.domain.vehicle.stateNumber.AnswerStateNumber;
import com.java.insurance.domain.vehicle.stateNumber.StateNumberCheckerResponse;
import com.java.insurance.exception.StateNumberException;
import com.java.insurance.exception.TransportException;
import com.java.insurance.validators.stateNumber.FakeStateNumberChecker;
import com.java.insurance.validators.stateNumber.StateNumberChecker;

import java.util.concurrent.ExecutionException;

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
        return check(insuranceOrder.getCustomer().getVehicle());
    }

    private AnswerStateNumber check(Vehicle vehicle){
        AnswerStateNumber.StateNumberStatus status = null;
        AnswerStateNumber.StateNumberError error = null;
            try {
                StateNumberCheckerResponse ans = vehicleChecker.checkVehicle(vehicle);
                status = ans.isExisting() ?
                        AnswerStateNumber.StateNumberStatus.Yes :
                        AnswerStateNumber.StateNumberStatus.No;

            } catch (StateNumberException e) {
                e.printStackTrace();
                status = AnswerStateNumber.StateNumberStatus.ERROR;
                error = new AnswerStateNumber.StateNumberError(e.getCode(),e.getMessage());
            }catch (TransportException e){
                e.printStackTrace();
                status = AnswerStateNumber.StateNumberStatus.ERROR;
                error = new AnswerStateNumber.StateNumberError("NO_",e.getMessage());
            }catch (Exception e){
                e.printStackTrace();
                status = AnswerStateNumber.StateNumberStatus.ERROR;
                error = new AnswerStateNumber.StateNumberError("NO_",e.getMessage());
            }

            AnswerStateNumber ans = new AnswerStateNumber(status,vehicle,error);
            return ans;
        }
}
