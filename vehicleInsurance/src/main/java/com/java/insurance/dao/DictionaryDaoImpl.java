package com.java.insurance.dao;

import com.java.insurance.config.Config;
import com.java.insurance.domain.CountryArea;
import com.java.insurance.domain.Street;
import com.java.insurance.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{

    public static final String GET_STREET = "SELECT street_code,street_name FROM o_street WHERE UPPER(street_name) LIKE UPPER(?);";
    private static final String GET_AREA = "SELECT * FROM  o_country_struct  WHERE area_id like ? and area_id <> ?" ;

    private Connection getConnection() throws SQLException{
        return ConnectionBuilder.getConnection();
    }

    @Override
    public List<Street> findStreets(String pattern) throws DaoException{
        List<Street> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_STREET)){
            stmt.setString(1,"%" + pattern + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street street = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(street);
            }

        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return  result;
    }

    @Override
    public List<CountryArea> findAreas(String areaId) throws DaoException {

        List<CountryArea> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_AREA)){

            String param1 =buildParam(areaId);
            String param2 = areaId;
            stmt.setString(1,param1);
            stmt.setString(2,param2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CountryArea countryArea = new CountryArea(
                        rs.getString("area_id"),rs.getString("area_name"));
                result.add(countryArea);
            }

        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return  result;

    }

    private String buildParam(String areaId) throws SQLException {
        if (areaId == null || areaId.trim().isEmpty()){
            return "__0000000000";
        } else if (areaId.endsWith("0000000000")){
            return areaId.substring(0,2) + "___0000000";
        }else if (areaId.endsWith("0000000")){
            return areaId.substring(0,5) + "___0000";
        }else if (areaId.endsWith("0000")){
            return areaId.substring(0,8) + "000";
        }
        throw new SQLException("Invalid parameter 'areaId':" + areaId);

    }

}
