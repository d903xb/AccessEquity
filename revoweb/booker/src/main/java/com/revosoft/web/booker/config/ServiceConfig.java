package com.revosoft.web.booker.config;

import com.revosoft.web.booker.jdbc.DatabaseConnection;
import com.revosoft.web.booker.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Bean
    public com.revosoft.web.booker.service.BookingService tradeLoaderService () {
        return new BookingServiceImpl(databaseConnection);
    }
}
