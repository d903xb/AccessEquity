package com.revosoft.web.authentication;

import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.web.authentication.service.AuthenticationService;
import com.revosoft.web.authentication.service.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;

import javax.sql.DataSource;

@Configuration
public class ServiceConfig {

    @Autowired
    private NettyServer webServer;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcOperations jdbcOperations;

    @Bean
    public AuthenticationService bookerService () {
        return new AuthenticationServiceImpl(jdbcOperations, webServer);
    }


}
