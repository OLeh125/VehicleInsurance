package com.java.insurance.dao;

import com.java.insurance.domain.*;
import com.java.insurance.domain.vehicle.Vehicle;
import com.java.insurance.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class InsuranceOrderDaoImpl implements InsuranceOrderDao{

    private static final String INSERT_ORDER="INSERT INTO o_insurance_order( " +
            "insurance_order_status,insurance_order_date, costumer_name, costumer_last_name, " +
            " costumer_patronymic, costumer_mobile_phone, costumer_email, " +
            " costumer_individual_taxpayer_id, costumer_post_index, costumer_street_code, " +
            " costumer_building, costumer_extension, costumer_apartment, vehicle_year_of_production, " +
            " vehicle_brand, vehicle_model, vehicle_identification_number, vehicle_state_number) " +
            " VALUES ( ?, ?, ?, ?, " +
            " ?, ?, ?, " +
            " ?, ?, ?, " +
            " ?, ?, ?, ?, " +
            "  ?, ?, ?, ?);";

    private static final String SELECT_ORDERS = "SELECT * FROM o_insurance_order";

    private Connection getConnection() throws SQLException{
        return ConnectionBuilder.getConnection();
    }

    @Override
    public Long saveInsuranceOrder(InsuranceOrder insuranceOrder) throws DaoException {
        Long result = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER,new String[] {"insurance_order_id"})){
            con.setAutoCommit(false); // тепер самі керуємо транзакціями

            try {
                int start = 0;
                stmt.setInt(start + 1, InsuranceOrderStatus.START.ordinal());
                stmt.setTimestamp(start + 2, Timestamp.valueOf(LocalDateTime.now()));
                setParamsForCustomer(insuranceOrder, start, stmt);
                setParamsForVehicle(insuranceOrder, start, stmt);

                stmt.executeUpdate();

                ResultSet generatedKeys = stmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    result = generatedKeys.getLong(1);
                }

                con.commit(); // закомічує транзакція
            }catch (SQLException e){
                con.rollback(); // не закомічує транзакцію
                throw e; // викидую SQLException для наступного блоку try
            }

        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<InsuranceOrder> getInsuranceOrders() throws DaoException {
        List<InsuranceOrder> result = new LinkedList<>();
        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ORDERS);){

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                InsuranceOrder insuranceOrder = new InsuranceOrder();
                fillInsuranceOrder(rs,insuranceOrder);

                Customer customer = fillCustomer(rs);
                insuranceOrder.setCustomer(customer);

                result.add(insuranceOrder);
            }
            rs.close();
        }catch (SQLException ex){
            throw new DaoException(ex);
        }

        return result;
    }

    private Customer fillCustomer(ResultSet rs) throws SQLException {
        Customer customer =new Customer();
        customer.setName(rs.getString("costumer_name"));
        customer.setLastName(rs.getString("costumer_last_name"));
        customer.setPatronymic(rs.getString("costumer_patronymic"));
        customer.setMobilePhone(rs.getString("costumer_mobile_phone"));
        customer.setEmail(rs.getString("costumer_email"));
        customer.setIndividualTaxpayerNumber(rs.getString("costumer_individual_taxpayer_id"));

        // TODO add city to db and here
        Address address = new Address();
        Street street = new Street(rs.getLong("costumer_street_code"),"");
        address.setStreet(street);
        address.setPostCode(rs.getString("costumer_post_index"));
        address.setBuilding(rs.getString("costumer_building"));
        address.setExtension(rs.getString("costumer_extension"));
        address.setApartment(rs.getString("costumer_apartment"));
        customer.setAddress(address);

        Vehicle vehicle = new Vehicle();
        vehicle.setYearOfProduction(rs.getInt("vehicle_year_of_production"));
        vehicle.setVehicleBrand(rs.getString("vehicle_brand"));
        vehicle.setVehicleModel(rs.getString("vehicle_model"));
        vehicle.setVehicleIdentificationNumber(rs.getString("vehicle_identification_number"));
        vehicle.setStateNumber(rs.getString("vehicle_state_number"));

        customer.setVehicle(vehicle);


        return customer;
    }

    private void fillInsuranceOrder(ResultSet rs, InsuranceOrder insuranceOrder) throws SQLException {
        insuranceOrder.setOrderId(rs.getLong("insurance_order_id"));
        insuranceOrder.setDataOfIssue(rs.getTimestamp("insurance_order_date").toLocalDateTime());
        insuranceOrder.setInsuranceOrderStatus(InsuranceOrderStatus.fromValue(rs.getInt("insurance_order_status")));
    }


    private void setParamsForCustomer(InsuranceOrder insuranceOrder,int start ,PreparedStatement stmt) throws SQLException {
        stmt.setString(start + 3,insuranceOrder.getCustomer().getName());
        stmt.setString(start + 4,insuranceOrder.getCustomer().getLastName());
        stmt.setString(start + 5,insuranceOrder.getCustomer().getPatronymic());
        stmt.setString(start + 6,insuranceOrder.getCustomer().getMobilePhone());
        stmt.setString(start + 7,insuranceOrder.getCustomer().getEmail());
        stmt.setString(start + 8,insuranceOrder.getCustomer().getIndividualTaxpayerNumber());
        stmt.setString(start + 9,insuranceOrder.getCustomer().getAddress().getPostCode());
        stmt.setLong(  start + 10,insuranceOrder.getCustomer().getAddress().getStreet().getStreetCode());
        stmt.setString(start + 11,insuranceOrder.getCustomer().getAddress().getBuilding());
        stmt.setString(start + 12,insuranceOrder.getCustomer().getAddress().getExtension());
        stmt.setString(start + 13,insuranceOrder.getCustomer().getAddress().getApartment());
    }

    private void setParamsForVehicle(InsuranceOrder insuranceOrder, int start, PreparedStatement stmt) throws SQLException {
        stmt.setLong(start + 14 , insuranceOrder.getVehicle().getYearOfProduction());
        stmt.setString(start + 15,insuranceOrder.getVehicle().getVehicleBrand());
        stmt.setString(start + 16,insuranceOrder.getVehicle().getVehicleModel());
        stmt.setString(start + 17,insuranceOrder.getVehicle().getStateNumber());
        stmt.setString(start +18,insuranceOrder.getVehicle().getVehicleIdentificationNumber());
    }
}
