package com.java.insurance.dao;

import com.java.insurance.domain.CountryArea;
import com.java.insurance.domain.Street;
import com.java.insurance.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class DictionaryDaoImplTest {
    @BeforeClass
    public static void startUp() throws URISyntaxException, IOException, SQLException {
        DBInit.startUp();
    }

    @Test
    public void testStreet() throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("Про");
        Assert.assertTrue(d.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2 );
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2 );
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2 );
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 0 );
    }
}