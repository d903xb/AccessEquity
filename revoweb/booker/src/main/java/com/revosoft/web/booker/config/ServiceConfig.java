package com.revosoft.web.booker.config;

import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.web.booker.service.impl.BookingServiceImpl;
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
    public com.revosoft.web.booker.service.BookingService bookerService () {
        return new BookingServiceImpl(jdbcTemplate() , webServer);
    }


}
