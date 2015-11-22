package com.revosoft.web.booker.config;

import com.revosoft.web.booker.jdbc.DatabaseConnection;
import com.revosoft.web.booker.jdbc.H2DatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${database.url}")
    private String url;

    @Bean
    public DatabaseConnection getDBConnection () {

        return new H2DatabaseConnection(url);
    };

}
