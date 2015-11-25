package com.revosoft.web.database.repository.config;


import com.revosoft.web.database.repository.TokenRepository;
import com.revosoft.web.database.repository.TokenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;


@Configuration
public class TokenRepositoryConfig {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Bean
    public TokenRepository tokenRepository() {
        return new TokenRepositoryImpl(jdbcOperations);
    }

}