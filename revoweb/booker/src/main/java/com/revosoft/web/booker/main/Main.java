package com.revosoft.web.booker.main;

import com.revosoft.web.booker.config.DatabaseConfig;
import com.revosoft.web.booker.config.JmsConfig;
import com.revosoft.web.booker.config.ServiceConfig;
import com.revosoft.web.booker.config.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main (final String[] args) {

        if(args.length != 1) {
            log.error("Please specify location of config file RevoBooker.json");
            System.exit(1);
        }
        else {
            System.setProperty("propertyfile.location", args[0]);
        }

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        PropertiesConfig.class,
                        DatabaseConfig.class,
                        JmsConfig.class,
                        ServiceConfig.class);

         log.info("RevoWebBooker started successfully.");


    }
}

