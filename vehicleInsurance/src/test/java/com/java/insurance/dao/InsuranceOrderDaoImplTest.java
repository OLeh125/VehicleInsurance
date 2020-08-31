package com.java.insurance.dao;

import com.java.insurance.domain.Address;
import com.java.insurance.domain.Customer;
import com.java.insurance.domain.InsuranceOrder;
import com.java.insurance.domain.Street;
import com.java.insurance.domain.vehicle.Vehicle;
import com.java.insurance.exception.DaoException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class InsuranceOrderDaoImplTest {

    @BeforeClass
    public static void startUp() throws URISyntaxException, IOException, SQLException {
        DBInit.startUp();
    }

    @Test
    public void saveInsuranceOrder() throws DaoException {
        InsuranceOrder io = buildInsuranceOrder(10);
        Long id = new InsuranceOrderDaoImpl().saveInsuranceOrder(io);
    }

    @Test
    public void getInsuranceOrders() throws DaoException {
        List<InsuranceOrder> list = new InsuranceOrderDaoImpl().getInsuranceOrders();
    }

    public InsuranceOrder buildInsuranceOrder(long id){
        InsuranceOrder ino = new InsuranceOrder();
        ino.setOrderId(id);
        ino.setDataOfIssue(LocalDateTime.now());
        ino.setEndDate(LocalDate.of(2021,8,21));
        Street street = new Street(1L,"First Street");
        Address address = new Address("195000","",street, "12", "", "142");
        Vehicle vehicle = new Vehicle(2002,"mercedes","W213",
                "JMZGG12F761624527","AA1111");
        Customer customer = new Customer("Oleh","Joh","Vasylovych","+380837341719",
                "oleeh.zhoh@gmail.com","6670087167",vehicle,address);

        ino.setCustomer(customer);

        ino.setVehicle(vehicle);
        return ino;
    }
}