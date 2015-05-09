package com.accesseq.trade.main;

import com.accesseq.trade.config.DatabaseConfig;
import com.accesseq.trade.config.JmsConfig;
import com.accesseq.trade.config.ServiceConfig;
import com.accesseq.trade.config.PropertiesConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main (final String[] args) {

        if(args.length != 1) {
           // log.error("Please specify location of config file TradeLoader.json");
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

      //  log.info("Trade loader started successfully.");


    }
}

