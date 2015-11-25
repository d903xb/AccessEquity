package com.revosoft.web.authentication.service.impl;

import com.revosoft.netty.server.http.NettyServer;

import com.revosoft.web.authentication.repository.AuthenticationRepository;
import com.revosoft.web.authentication.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;

@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private JdbcOperations jdbcTemplate;
    private NettyServer nettyServer;

    public AuthenticationServiceImpl(JdbcOperations jdbcTemplate,
                                     NettyServer nettyServer) {
        this.jdbcTemplate = jdbcTemplate;
        this.nettyServer = nettyServer;
        this.run();
    }

    public void run() {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository(jdbcTemplate);
        authenticationRepository.getBooking();
        nettyServer.run();

    }

}
