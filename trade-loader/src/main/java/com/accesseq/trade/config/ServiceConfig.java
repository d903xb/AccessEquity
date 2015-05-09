package com.accesseq.trade.config;

import com.accesseq.trade.jdbc.DatabaseConnection;
import com.accesseq.trade.service.TradeLoaderService;
import com.accesseq.trade.service.impl.TradeLoaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Bean
    public TradeLoaderService tradeLoaderService () {
        return new TradeLoaderServiceImpl(databaseConnection);
    }
}
