package com.java.insurance.validators;

import com.java.insurance.domain.AnswerCheckEmail;
import com.java.insurance.domain.InsuranceOrder;

public class EmailValidator {
    public AnswerCheckEmail checkEmail(InsuranceOrder insuranceOrder){ // перевірка Email
        System.out.println("check Email");
        AnswerCheckEmail ace = new AnswerCheckEmail();
        return ace;
    }
}
