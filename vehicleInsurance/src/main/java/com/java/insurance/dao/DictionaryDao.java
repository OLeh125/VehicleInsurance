package com.java.insurance.dao;

import com.java.insurance.domain.CountryArea;
import com.java.insurance.domain.Street;
import com.java.insurance.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;

}
