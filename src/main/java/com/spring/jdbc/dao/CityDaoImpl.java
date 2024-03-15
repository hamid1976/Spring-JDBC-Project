package com.spring.jdbc.dao;

import com.spring.jdbc.RowMapper.RowMapperCityImpl;
import com.spring.jdbc.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.*;
@Component("cityDao")
public class CityDaoImpl implements Dao<City, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(City city) {
        // Insert city into database
        String query = "INSERT INTO city (city_name, division_name, longitude, latitude) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(query, city.getCityName(), city.getDivisonName(), city.getLongitude(), city.getLatitude());
        return rowsAffected;
    }

    @Override
    public int change(City city) {
        // Update city in database
        String query = "UPDATE city SET city_name = ?, division_name = ?, longitude = ?, latitude = ? WHERE city_name = ?";
        int rowsAffected = jdbcTemplate.update(query, city.getCityName(), city.getDivisonName(), city.getLongitude(), city.getLatitude(), city.getCityName());
        return rowsAffected;
    }

    @Override
    public int delete(String cityName) {
        // Delete city from database
        String query = "DELETE FROM city WHERE city_name = ?";
        int rowsAffected = jdbcTemplate.update(query, cityName);
        return rowsAffected;
    }

    @Override
    public City get(String cityName) {
        // Retrieve city from database
        String query = "SELECT * FROM city WHERE city_name = ?";
        RowMapper<City> rowMapper = new RowMapperCityImpl();
        City city = jdbcTemplate.queryForObject(query, rowMapper, cityName);
        return city;
    }

    @Override
    public List<City> getAll() {
        // Retrieve all cities from database
        String query = "SELECT * FROM city";
        List<City> cities = jdbcTemplate.query(query, new RowMapperCityImpl());
        return cities;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
