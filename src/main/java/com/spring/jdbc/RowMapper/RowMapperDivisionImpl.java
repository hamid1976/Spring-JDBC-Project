package com.spring.jdbc.RowMapper;

import com.spring.jdbc.entities.Division;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class RowMapperDivisionImpl implements RowMapper<Division> {

    @Override
    public Division mapRow(ResultSet rs, int rowNum) throws SQLException {
        Division division = new Division();
        division.setDivisionName(rs.getString("division_name"));
        division.setProvincName(rs.getString("provinc_name"));
        return division;
    }
}