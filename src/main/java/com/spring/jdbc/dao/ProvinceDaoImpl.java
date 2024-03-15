package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Province;
import com.spring.jdbc.RowMapper.RowMapperProvinceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("provinceDao")
public class ProvinceDaoImpl implements Dao<Province, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Province province) {
        // Insert province into database
        String query = "INSERT INTO province (province_name, country_name) VALUES (?, ?)";
        int rowsAffected = jdbcTemplate.update(query, province.getProvinceName(), province.getCountryName());
        return rowsAffected;
    }
    @Override
    public int change(Province province) {
        // Update query
        String query = "UPDATE province SET province_name = ?, country_name = ? WHERE province_name = ?";
        int rowsAffected = jdbcTemplate.update(query, province.getProvinceName(), province.getCountryName(), province.getProvinceName());

        return rowsAffected;
    }



    @Override
    public int delete(String provinceName) {
        // Delete province from database
        String query = "DELETE FROM province WHERE province_name = ?";
        int rowsAffected = jdbcTemplate.update(query, provinceName);
        return rowsAffected;
    }

    @Override
    public Province get(String provinceName) {
        // Retrieve province from database
        String query = "SELECT * FROM province WHERE province_name = ?";
        RowMapper<Province> rowMapper = new RowMapperProvinceImpl();
        Province province = jdbcTemplate.queryForObject(query, rowMapper, provinceName);
        return province;
    }

    @Override
    public List<Province> getAll() {
        // Retrieve all provinces from database
        String query = "SELECT * FROM province";
        List<Province> provinces = jdbcTemplate.query(query, new RowMapperProvinceImpl());
        return provinces;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
