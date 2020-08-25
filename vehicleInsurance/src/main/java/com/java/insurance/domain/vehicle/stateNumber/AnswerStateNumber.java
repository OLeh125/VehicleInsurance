package com.java.insurance.domain.vehicle.stateNumber;

import com.java.insurance.domain.Customer;
import com.java.insurance.domain.vehicle.Vehicle;

public class AnswerStateNumber {
   public enum StateNumberStatus {
      Yes,No,ERROR;
   }

   public static class StateNumberError{
      private String code;
      private String text;

      public StateNumberError(String code, String text) {
         this.code = code;
         this.text = text;
      }

      public String getCode() {
         return code;
      }

      public void setCode(String code) {
         this.code = code;
      }

      public String getText() {
         return text;
      }

      public void setText(String text) {
         this.text = text;
      }
   }
   private StateNumberStatus status;
   private Vehicle vehicle;
   private StateNumberError error;


   public AnswerStateNumber(StateNumberStatus status, Vehicle vehicle) {
      this.status = status;
      this.vehicle = vehicle;
   }

   public AnswerStateNumber(StateNumberStatus status,Vehicle vehicle, StateNumberError error) {
      this.status = status;
      this.vehicle = vehicle;
      this.error = error;
   }

   public StateNumberStatus getStatus() {
      return status;
   }

   public void setStatus(StateNumberStatus status) {
      this.status = status;
   }

   public Vehicle getVehicle() { return vehicle; }

   public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

   public StateNumberError getError() {
      return error;
   }

   public void setError(StateNumberError error) {
      this.error = error;
   }
}
