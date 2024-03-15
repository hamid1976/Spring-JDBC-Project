package com.spring.jdbc.RowMapper;

import com.spring.jdbc.entities.Country;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperCountryImpl implements RowMapper<Country>{

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setCountryName(rs.getString("country_name"));
        return country;
    }

}
