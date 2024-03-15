package com.spring.jdbc.dao;

import com.spring.jdbc.RowMapper.RowMapperDivisionImpl;
import com.spring.jdbc.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("divisionDao")
public class DivisionDaoImpl implements Dao<Division, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Division division) {
        // Insert division into database
        String query = "INSERT INTO division (division_name, provinc_name) VALUES (?, ?)";
        int rowsAffected = jdbcTemplate.update(query, division.getDivisionName(), division.getProvincName());
        return rowsAffected;
    }

    @Override
    public int change(Division division) {
        // Update division in the database
        String query = "UPDATE division SET division_name = ?, provinc_name = ? WHERE division_name = ?";
        int rowsAffected = jdbcTemplate.update(query, division.getDivisionName(), division.getProvincName(), division.getDivisionName());
        return rowsAffected;
    }


    @Override
    public int delete(String divisionName) {
        // Delete division from database
        String query = "DELETE FROM division WHERE division_name = ?";
        int rowsAffected = jdbcTemplate.update(query, divisionName);
        return rowsAffected;
    }

    @Override
    public Division get(String divisionName) {
        // Retrieve division from database
        String query = "SELECT * FROM division WHERE division_name = ?";
        RowMapper<Division> rowMapper = new RowMapperDivisionImpl();
        Division division = jdbcTemplate.queryForObject(query, rowMapper, divisionName);
        return division;
    }

    @Override
    public List<Division> getAll() {
        // Retrieve all divisions from database
        String query = "SELECT * FROM division";
        List<Division> divisions = jdbcTemplate.query(query, new RowMapperDivisionImpl());
        return divisions;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
