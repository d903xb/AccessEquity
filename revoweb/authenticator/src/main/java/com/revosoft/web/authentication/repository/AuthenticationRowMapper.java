package com.revosoft.web.authentication.repository;


import com.revosoft.web.domain.Credentials;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthenticationRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Credentials booking = new Credentials();

        return booking;
    }

}

