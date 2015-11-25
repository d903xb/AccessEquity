package com.revosoft.web.booker.repository;
import com.revosoft.web.booker.domain.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookingRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Booking booking = new Booking();
        booking.setId(rs.getInt("ID"));
        booking.setAddress(rs.getString("CLIENT-ADDRESS"));
        booking.setName(rs.getString("CLIENT-NAME"));
        return booking;
    }

}

