package com.revosoft.web.booker.service.impl;

import com.revosoft.netty.server.http.NettyServer;
import com.revosoft.web.booker.jdbc.DatabaseConnection;
import com.revosoft.web.booker.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingServiceImpl implements BookingService {

    private DatabaseConnection databaseConnection;
    private NettyServer nettyServer;

    public BookingServiceImpl(DatabaseConnection databaseConnection,
                              NettyServer nettyServer) {
        this.databaseConnection = databaseConnection;
        this.nettyServer = nettyServer;
        this.run();
    }

    public void run() {

        nettyServer.run();
        log.info("Started service with database connection url : " + databaseConnection.getUrl());
    }

}
