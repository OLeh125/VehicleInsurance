package com.java.insurance.validators;

import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.domain.AnswerIndividualTaxpayerNumber;

public class IndividualTaxpayerNumberValidator {
    public  AnswerIndividualTaxpayerNumber checkIndividualTaxpayerNumber(InsuranceOrder insuranceOrder){ // перевірка ИНН - Идентификационный Номер Налогоплательщика
        System.out.println("check Individual Taxpayer Number ");
        AnswerIndividualTaxpayerNumber aitn = new AnswerIndividualTaxpayerNumber();
        return aitn;
    }

}
