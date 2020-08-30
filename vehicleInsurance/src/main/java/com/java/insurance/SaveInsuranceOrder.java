package com.java.insurance;

import com.java.insurance.dao.DictionaryDaoImpl;
import com.java.insurance.dao.InsuranceOrderDao;
import com.java.insurance.dao.InsuranceOrderDaoImpl;
import com.java.insurance.domain.*;
import com.java.insurance.domain.vehicle.Vehicle;
import com.sun.xml.internal.messaging.saaj.soap.SOAPDocument;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class SaveInsuranceOrder {
    public static void main(String[] args) throws Exception {
//        List<Street> d = new DictionaryDaoImpl().findStreets("");
//
//        for (Street s: d) {
//            System.out.println(s.getStreetName());
//        }

//        List<CountryArea> countryArea1 = new DictionaryDaoImpl().findAreas("");
//
//        for (CountryArea c : countryArea1) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//
//        System.out.println();
//        List<CountryArea> countryArea2 = new DictionaryDaoImpl().findAreas("020000000000");
//
//        for (CountryArea c : countryArea2) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//
//        System.out.println();
//        List<CountryArea> countryArea3 = new DictionaryDaoImpl().findAreas("020010000000");
//
//        for (CountryArea c : countryArea3) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }
//
//        System.out.println();
//        List<CountryArea> countryArea4 = new DictionaryDaoImpl().findAreas("020010010000");
//
//        for (CountryArea c : countryArea4) {
//            System.out.println(c.getAreaId() + " : " + c.getAreaName());
//        }


     //   InsuranceOrder s = buildInsuranceOrder(10);
        InsuranceOrderDao dao = new InsuranceOrderDaoImpl();
     //   Long id = dao.saveInsuranceOrder(s);


        List<InsuranceOrder> insuranceOrders = dao.getInsuranceOrders();
        for (InsuranceOrder io: insuranceOrders) {
            System.out.println(io.getOrderId());

        }

//        InsuranceOrder insuranceOrder = new InsuranceOrder();
//        long id  = saveInsuranceOrder(insuranceOrder);
//        System.out.println(id);
    }

    public static long saveInsuranceOrder(InsuranceOrder insuranceOrder){
        Random random = new Random();
        return random.nextInt(10000);
    }

    static InsuranceOrder buildInsuranceOrder(long id){
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
