package com.revosoft.web.authentication.service.impl;

import com.revosoft.netty.server.http.NettyServer;

import com.revosoft.web.authentication.repository.BookingRepository;
import com.revosoft.web.authentication.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;

@Slf4j
public class BookingServiceImpl implements BookingService {

    private JdbcOperations jdbcTemplate;
    private NettyServer nettyServer;

    public BookingServiceImpl(JdbcOperations jdbcTemplate,
                              NettyServer nettyServer) {
        this.jdbcTemplate = jdbcTemplate;
        this.nettyServer = nettyServer;
        this.run();
    }

    public void run() {
        BookingRepository bookingRepository = new BookingRepository(jdbcTemplate);
        bookingRepository.getBooking();
        nettyServer.run();

    }

}
