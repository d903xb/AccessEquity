package com.accesseq.trade.service.impl;

import com.accesseq.trade.jdbc.DatabaseConnection;
import com.accesseq.trade.service.TradeLoaderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TradeLoaderServiceImpl  implements TradeLoaderService{

    private DatabaseConnection databaseConnection;

    public TradeLoaderServiceImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
        this.run();
    }

    public void run() {
      log.error("Started service with database connection url : " + databaseConnection.getUrl());
    }

}
