package com.java.insurance;

import com.java.insurance.domain.*;
import com.java.insurance.domain.vehicle.stateNumber.AnswerStateNumber;
import com.java.insurance.domain.vehicle.AnswerVehicleIdentificationNumber;
import com.java.insurance.mail.MailSender;
import com.java.insurance.validators.*;

import java.util.LinkedList;
import java.util.List;


public class InsuranceOrderValidator  {

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
        List<InsuranceOrder> ioList =readInsuranceOrders();

        for (InsuranceOrder ion : ioList) {
            checkOneOrder(ion);
        }

    }

    public List<InsuranceOrder> readInsuranceOrders(){
        List<InsuranceOrder> ioList = new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            ioList.add(SaveInsuranceOrder.buildInsuranceOrder(i));
        }
        return ioList;
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
