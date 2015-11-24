package com.revosoft.web.database.local;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseConfig {

    @Value("${database.url}")
    private String url;

    @Bean
    public javax.sql.DataSource h2DataSource() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        final JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("repository:h2:tcp://localhost/~/revosoft;MODE=MySQL");
        ds.setUser("sa");
        return ds;
    }

}
