//package com.spring.jdbc.dao;
//
//import com.spring.jdbc.entities.City;
//import org.springframework.jdbc.core.RowMapper;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class RowMapperCityImpl {
//
//    public class RowMapperImpl implements RowMapper<City> {
//        @Override
//        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
//            City city=new City();
//            city.setCityName(rs.getString("city_name"));
//            city.setDivisonName(rs.getString("division_name"));
//            city.setLongitude(rs.getString("longitude"));
//            city.setLatitude(rs.getString("latitude"));
//            return city;
//        }
//    }
//}

package com.spring.jdbc.RowMapper;

import com.spring.jdbc.entities.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperCityImpl implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setCityName(rs.getString("city_name"));
        city.setDivisonName(rs.getString("division_name"));
        city.setLongitude(rs.getString("longitude"));
        city.setLatitude(rs.getString("latitude"));
        return city;
    }
}
