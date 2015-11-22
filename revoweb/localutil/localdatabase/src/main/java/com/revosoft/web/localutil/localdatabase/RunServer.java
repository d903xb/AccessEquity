package com.revosoft.web.localutil.localdatabase;

import liquibase.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;

@Slf4j
public class RunServer {

    private static String port = "9092";
    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver");

            Server.createTcpServer("-tcpPort", port, "-tcpAllowOthers").start();
            applyLiquibasePatches();

            log.info("Started local database server on port " + port);

        } catch (Exception e) {
            log.error("Cannot start local database server : " + e.getMessage());
        }

    }

    private static void applyLiquibasePatches() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
 //      liquibase.setDataSource(dataSource());

    }

}