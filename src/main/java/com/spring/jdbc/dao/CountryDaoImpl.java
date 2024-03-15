package com.spring.jdbc.dao;

import com.spring.jdbc.RowMapper.RowMapperCountryImpl;
import com.spring.jdbc.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("countryDao")
public class CountryDaoImpl implements Dao<Country,String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override

    public int insert(Country country) {
        //insert

        String query="insert into country(country_name)values(?)";
        int r= this.jdbcTemplate.update(query,country.getCountryName());
        return r;
    }

//    @Override
//    public int change(Country country) {
//        //update
//        String query = "UPDATE country SET country_name = ? WHERE country_name = ?";
//      //  String query="update country where country_name=?";
//        int r= this.jdbcTemplate.update(query,country.getCountryName());
//        return r;
//
//    }
    public int change(Country country) {
        // Update query to set the new country name where the country name matches the input
        String query = "UPDATE country SET country_name = ? WHERE country_name = ?";

        // Parameters for the update query: new country name and the original country name
        int r = this.jdbcTemplate.update(query, country.getCountryName(), country.getCountryName());

        return r;
    }

    @Override
    public int delete(String s) {
        //delete
        String query="delete  from country where country_name=?";
        int r=  this.jdbcTemplate.update(query,s);
        return r;
    }

    @Override
    public Country get(String s) {
        //get single row
        String query="select * from country where country_name=?";
        RowMapper <Country> rowMapper=  new RowMapperCountryImpl();
        Country country=  this.jdbcTemplate.queryForObject(query,rowMapper,s);

        return country;
    }

    @Override
    public List<Country> getAll() {
        String query="select * from country";
        List <Country> student=  this.jdbcTemplate.query(query, new RowMapperCountryImpl());
        return student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}