package com.revosoft.web.authentication.repository;


import com.revosoft.web.authentication.domain.Credentials;
import org.springframework.jdbc.core.JdbcOperations;

public class AuthenticationRepository {

    public AuthenticationRepository authenticationRepository;
    public JdbcOperations jdbcTemplate;

    public AuthenticationRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void getBooking() {
        String sql = "SELECT * FROM BOOKINGS WHERE ID = ?";

        Credentials booking = (Credentials)jdbcTemplate.queryForObject(
                sql, new Object[] { 1 }, new AuthenticationRowMapper());

        System.out.println("got booking : " + booking);
    }
}
