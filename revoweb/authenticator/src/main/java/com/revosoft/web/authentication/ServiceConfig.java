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

    @Bean
    public JdbcOperations jdbcTemplate(){
        return new org.springframework.jdbc.core.JdbcTemplate(dataSource);
    }

    @Bean
    public AuthenticationService bookerService () {
        return new AuthenticationServiceImpl(jdbcTemplate() , webServer);
    }


}
