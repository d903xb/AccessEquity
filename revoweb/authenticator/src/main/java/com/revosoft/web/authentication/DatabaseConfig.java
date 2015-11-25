package com.revosoft.web.authentication;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {

    @Value("${database.url}")
    private String url;

    @Value("${database.type}")
    private String type;

    @Bean
    public JdbcOperations jdbcTemplate(){
        return new JdbcTemplate(c3poDataSource());
    }

    @Bean
    public DataSource c3poDataSource()  {
        try {
            if (type != null && !type.equals("${database.type}") && type.equals("h2")) {
                final ComboPooledDataSource ds = new ComboPooledDataSource();
                ds.setDriverClass("org.h2.Driver");
                ds.setJdbcUrl("jdbc:h2:tcp://localhost/~/revosoft;MODE=MySQL");
                ds.setUser("sa");
                ds.setMaxPoolSize(30);
                ds.setMinPoolSize(10);
                return ds;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




}
