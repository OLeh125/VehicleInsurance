package com.java.insurance;

import com.java.insurance.domain.*;
import com.java.insurance.mail.MailSender;
import com.java.insurance.validators.*;


public class InsuranceOrderValidator {
    private StateNumberValidator stateNumberVal;
    private EmailValidator emailVal;
    private IndividualTaxpayerNumberValidator individualTaxpayerNumberVal;
    private MobilePhoneValidator mobilePhoneVal;
    private VehicleIdentificationNumberValidator vehicleIdentificationNumberVal;
    private MailSender mailSender;

    public InsuranceOrderValidator(){
        stateNumberVal = new StateNumberValidator();
        emailVal = new EmailValidator();
        individualTaxpayerNumberVal = new IndividualTaxpayerNumberValidator();
        mobilePhoneVal = new MobilePhoneValidator();
        vehicleIdentificationNumberVal = new VehicleIdentificationNumberValidator();
        mailSender = new MailSender();

    }

    public static void main(String[] args) {
        InsuranceOrderValidator ion = new InsuranceOrderValidator();
        ion.checkAll();

    }

    public void checkAll() {
        InsuranceOrder[] insuranceOrders = readInsuranceOrders();

        for (InsuranceOrder ion : insuranceOrders) {
            checkOneOrder(ion);
        }

    }

    public InsuranceOrder[] readInsuranceOrders(){
        InsuranceOrder [] inoArray = new InsuranceOrder[3];
        for (int i = 0; i <inoArray.length ; i++) {
            inoArray[i] = SaveInsuranceOrder.buildInsuranceOrder(i);

        }

        return inoArray;
    }

    public void checkOneOrder(InsuranceOrder insuranceOrders){
            AnswerStateNumber stateAnswer = checkStateNumber(insuranceOrders);


//            AnswerVehicleIdentificationNumber identificationNumberAnswer =
//                    checkVehicleIdentificationNumber(insuranceOrders);
//            AnswerCheckEmail answerCheckEmail = checkEmail(insuranceOrders);
//            AnswerCheckMobile answerCheckMobile= checkMobilePhone(insuranceOrders);
//            AnswerIndividualTaxpayerNumber answerIndividualTaxpayerNumber =
//                    checkIndividualTaxpayerNumber(insuranceOrders);
//
//            sendMail(insuranceOrders);

    }


     public AnswerStateNumber checkStateNumber(InsuranceOrder insuranceOrder){  // перевірка гос номеру
      return stateNumberVal.checkStateNumber(insuranceOrder);
    }

    public AnswerVehicleIdentificationNumber checkVehicleIdentificationNumber(InsuranceOrder insuranceOrder) { //перевірка номеру кузова
        return vehicleIdentificationNumberVal.checkVehicleIdentificationNumber(insuranceOrder);
    }

    public AnswerCheckEmail checkEmail(InsuranceOrder insuranceOrder){ // перевірка Email
        return emailVal.checkEmail(insuranceOrder);
    }

    public AnswerCheckMobile checkMobilePhone(InsuranceOrder insuranceOrder){ // перевірка мобільного телефону
        return mobilePhoneVal.checkMobilePhone(insuranceOrder);
    }

    public AnswerIndividualTaxpayerNumber checkIndividualTaxpayerNumber(InsuranceOrder insuranceOrder){ // перевірка ИНН - Идентификационный Номер Налогоплательщика
        return individualTaxpayerNumberVal.checkIndividualTaxpayerNumber(insuranceOrder);
    }

    public void sendMail(InsuranceOrder insuranceOrder) {
        mailSender.sendMail(insuranceOrder);
    }
}
