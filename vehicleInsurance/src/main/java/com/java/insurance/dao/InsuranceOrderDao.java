package com.java.insurance.dao;

import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.exception.DaoException;


import java.util.List;

public interface InsuranceOrderDao {
    Long saveInsuranceOrder(InsuranceOrder insuranceOrder) throws DaoException;
    List<InsuranceOrder> getInsuranceOrders() throws DaoException;

}
