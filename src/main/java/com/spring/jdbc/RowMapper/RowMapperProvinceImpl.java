package com.spring.jdbc.RowMapper;

import com.spring.jdbc.entities.Province;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class RowMapperProvinceImpl implements RowMapper<Province> {

    @Override
    public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
        Province province = new Province();
        province.setProvinceName(rs.getString("province_name"));
        province.setCountryName(rs.getString("country_name"));
        return province;
    }
}
