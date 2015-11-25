package com.revosoft.web.authentication.repository;


import com.revosoft.web.authentication.domain.Booking;
import org.springframework.jdbc.core.JdbcOperations;

public class BookingRepository {

    public BookingRepository bookingRepository;
    public JdbcOperations jdbcTemplate;

    public BookingRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void getBooking() {
        String sql = "SELECT * FROM BOOKINGS WHERE ID = ?";

        Booking booking = (Booking)jdbcTemplate.queryForObject(
                sql, new Object[] { 1 }, new BookingRowMapper());

        System.out.println("got booking : " + booking);
    }
}
