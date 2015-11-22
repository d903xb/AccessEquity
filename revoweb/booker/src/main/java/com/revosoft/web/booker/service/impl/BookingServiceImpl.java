package com.revosoft.web.booker.service.impl;

import com.revosoft.web.booker.jdbc.DatabaseConnection;
import com.revosoft.web.booker.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingServiceImpl implements BookingService {

    private DatabaseConnection databaseConnection;

    public BookingServiceImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
        this.run();
    }

    public void run() {
      log.error("Started service with database connection url : " + databaseConnection.getUrl());
    }

}
